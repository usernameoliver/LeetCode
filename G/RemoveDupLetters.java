import java.util.*;
public class RemoveDupLetters {
    public static void main(String[] args) {
        RemoveDupLetters remover = new RemoveDupLetters();
        String input = "abacb";
        String output = remover.removeDuplicateLetters(input);
        System.out.println("the result is " + output);
    }
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        char[] array = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> lastOccur = new HashMap<>();
        for (int i = array.length - 1; i >= 0; i--) {
            if (!lastOccur.containsKey(array[i])) {
                lastOccur.put(array[i], i);
                stack.push(array[i]);
            }
        }
        int start = 0;
        while (!stack.isEmpty()) {
            Character letter = stack.pop();
            System.out.println("the letter popped out is " + letter);
            if (!lastOccur.containsKey(letter))   continue;
            int index = lastOccur.get(letter);
            char smallestLetter = letter;
            int smallestLetterIndex = index;
            
            for (int i = index - 1; i >= start; i--) {
                if (array[i] < smallestLetter && lastOccur.containsKey(array[i])) {
                    // System.out.println("the letter popped out is " + letter);
                    // System.out.println("the letter to add is " + array[i]);
                    // System.out.println("_______________________");
                    smallestLetter = array[i];
                    smallestLetterIndex = i;
                    
                }
            }
            if (smallestLetter != letter) {
                sb.append(smallestLetter);
                lastOccur.remove(smallestLetter);
                start = smallestLetterIndex + 1;
            }
            
            sb.append(letter);
            lastOccur.remove(letter);
            start = index + 1;
        }
        return sb.toString();
        

        
        
    }
}