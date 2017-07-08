import java.util.*;
public class WordBreak2 {
	public static void main(String[] args) {
		String s = "catsanddog";
		List<String> dict = new ArrayList<>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
		WordBreak2 wb = new WordBreak2();
		List<String> result = wb.wordBreak2(s, dict);
		for (String line : result) {
			System.out.println(line);
		}
	}
	public List<String> wordBreak2(String s, List<String> wordDict) {
		return DFS(s, wordDict, new HashMap<String, LinkedList<String>>());
	}

    List<String> DFS(String s, List<String> wordDict, HashMap<String, LinkedList<String>>map) {
	    if (map.containsKey(s)) 
	        return map.get(s);
	        
	    LinkedList<String>res = new LinkedList<String>();     
	    if (s.length() == 0) {
	        res.add("");
	        return res;
	    }               
	    for (String word : wordDict) {
	        if (s.startsWith(word)) {
	            List<String>sublist = DFS(s.substring(word.length()), wordDict, map);
	            for (String sub : sublist) 
	                res.add(word + (sub.isEmpty() ? "" : " ") + sub);               
	        }
	    }       
	    map.put(s, res);
	    return res;
	}
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for (String word : wordDict) {
            set.add(word);
        }
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        findNextWord(set, s, result, sb);
        return result;
    }
    public void findNextWord(Set<String> set, String remaining, List<String> result, StringBuilder sb) {
        System.out.println(remaining);
        if (remaining.length() == 0)    {
        	result.add(sb.toString());
        }
        for (int i = 0; i <= remaining.length(); i++) {
            String current = remaining.substring(0, i);
            if (set.contains(current)) {
                if (sb.length() != 0)	{
                	sb.append(" " + current);
                	findNextWord(set, remaining.substring(i, remaining.length()), result, sb);
                	sb.delete(sb.length() - current.length() - 1, sb.length());
                }   
                else {
                	sb.append(current);
                	findNextWord(set, remaining.substring(i, remaining.length()), result, sb);
                	sb = new StringBuilder();
                }
            }
        }
    }
}