import java.util.*;
public class LongestSubstringKDistinct {
	public static void main(String[] args) {
		String s = "abZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZYX";
		int k = 2;
		LongestSubstringKDistinct worker = new LongestSubstringKDistinct();
		int result = worker.lengthOfLongestSubstringKDistinct(s, k);
		System.out.println(result);
	}
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() < k) {
            String result = distinctString(s, 0, s.length() - 1);
            return result.length();
        }
        String[][] dp = new String[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                dp[i][j] = distinctString(s, i, j);
            }
        }
        int len = k;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (dp[i][j].length() <= k && (j - i + 1) >= len) {
                    len = j - i + 1;
                    System.out.println("------------------");
                    System.out.println("i = " + i);
                    System.out.println("j = " + j);
                    System.out.println("len = " + len);
                    System.out.println("substr = " + dp[i][j]);
                    System.out.println(s.substring(i, j + 1));
                    
                    System.out.println("------------------");
                }
            }
        }
        return len;
    }
    
    public String distinctString(String s, int i, int j) {
        StringBuilder sb = new StringBuilder();
        String substr = s.substring(i, j + 1);
        int[] array = new int[256];
        for (int k = 0; k < substr.length(); k++) {
            array[substr.charAt(k)]++;
        }
        for (int k = 0; k < 256; k++) {
            if (array[k] != 0)  sb.append((char) k);
        }
        return sb.toString();
        
    }
}