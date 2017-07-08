import java.util.ArrayList;
public class Permutation1 {
    public static void main(String[] args) {
        String input = "abcd";
        Permutation1 permutationGenerator = new Permutation1();
        ArrayList<String> output = permutationGenerator.getPerm(input);
        for (String word : output) {
            System.out.println(word);
        }
    }
    public ArrayList<String> getPerm(String s) {
        ArrayList<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            result.add("");
            return result;
        }
        
        char first = s.charAt(0);
        String remainder = s.substring(1);
        ArrayList<String> partPermutations = getPerm(remainder);
        for (String word : partPermutations) {
            for (int j = 0; j <= word.length(); j++) {
                String perm = insert(word, j, first);
                result.add(perm);
            }
        }
    
        return result;
    }
    public String insert(String word, int index, char c) {
        return word.substring(0, index) + c + word.substring(index);
    }
}