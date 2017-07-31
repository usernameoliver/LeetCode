import java.util.*;
public class Bold {
	public static void main(String[] args) {
		String s = "aaabbcc";
		String[] dict = new String[] {"aaa","aab","bc"};
		Bold worker = new Bold();
		String result = worker.addBoldTag(s, dict);
		System.out.println(result);
	}
    public String addBoldTag(String s, String[] dict) {
        boolean[] bold = new boolean[s.length()];
        for (int i = 0, end = 0; i < s.length(); i++) {
            for (String word : dict) {
                if (s.startsWith(word, i)) {
                    end = Math.max(end, i + word.length());
                }
            }
            if (end > i)    bold[i] = true;
        }
        for (boolean b : bold) 	System.out.print(b + " ");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
        	System.out.println("i = " + i);
            if (!bold[i]) {
                result.append(s.charAt(i));
                continue;
            }
            int j = i;
            while (j < s.length() && bold[j]) j++;
            result.append("<b>" + s.substring(i, j) + "</b>");
            System.out.println(result.toString());
            System.out.println(j);
            i = j - 1;
        }
        return result.toString();
    }
}