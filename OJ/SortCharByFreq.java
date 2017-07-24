import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Collections;
public class SortCharByFreq {
    public String frequencySort(String s) {
        StringBuilder sb = new StringBuilder();
        Integer[] count = new Integer[256];
        Arrays.fill(count, 0);
        char[] letterArray = s.toCharArray();
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (char letter : letterArray) {
            count[letter]++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0)  continue;          
            Set<Integer> set = map.getOrDefault(count[i], new HashSet<>());
            set.add(i);
            map.put(count[i], set);
        }
            System.out.println(map.entrySet());
        Arrays.sort(count, Collections.reverseOrder());
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0)  continue;
            Set<Integer> set = map.get(count[i]);

            // System.out.println("set size " + set.size());
            // System.out.println("count " + count[i]);
            for (int j : set) {
                for (int k = 0; k < count[i]; k++) {
                    sb.append((char) (j));
                }
            }
            map.remove(count[i]);
            
        }
        return sb.toString();
        
    }
    public static void main(String[] args) {
    	String input = "tree";
    	SortCharByFreq worker = new SortCharByFreq();
    	String output = worker.frequencySort(input);
    	System.out.println(output);
    }
    
}