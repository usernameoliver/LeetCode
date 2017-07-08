import java.util.*;
public class Paren {
	public static void main(String[]  args) {
		Paren p = new Paren();
		List<String> result = p.generateParens(2);
		for (String s : result) {
			System.out.println(s);
		}
	}
	public List<String> generateParens(int n) {
		List<String> result = new ArrayList<>();
		char[] str = new char[n * 2];
		dfs(result, 0, n, n, str);
		return result;
	}
	public void dfs(List<String> result, int index, int left, int right, char[] str) {
		if (left < 0 || right < left)	return;
		if (index == str.length)	result.add(String.copyValueOf(str));
		else {
			str[index] = '(';
			dfs(result, index + 1, left - 1, right, str);
			str[index] = ')';
			dfs(result, index + 1, left, right - 1, str);
		}
	}
}