
public class StringCompression {
	public static void main(String[] args) {
		String input = "aaaaaaaabbccccdd";
		String output = compress(input);
		System.out.println(output);
	}
	public static String compress(String str) {
		StringBuilder sb = new StringBuilder();
		int contConsecutive = 0;
		for (int i = 0; i < str.length(); i++) {
			contConsecutive++;
			if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
				sb.append(str.charAt(i));
				sb.append(contConsecutive);
				contConsecutive = 0;
			}
		}
		return sb.length() > str.length() ? str : sb.toString();
	}
}