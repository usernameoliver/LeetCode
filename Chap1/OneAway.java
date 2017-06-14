public class OneAway {
	public static void main(String[] args) {
		String s1 = "";
		String s2 = null;
		OneAway checker = new OneAway();
		boolean isOneEditAway = checker.isOneAway(s1, s2);
		System.out.println(isOneEditAway);

		// String s3 = "pale";
		// String s4 = "pales";
		// isOneEditAway = checker.isOneAway(s3, s4);
		// System.out.println(isOneEditAway);

		// String s5 = "pale";
		// String s6 = "bale";
		// isOneEditAway = checker.isOneAway(s5, s6);
		// System.out.println(isOneEditAway);

		// String s7 = "pale";
		// String s8 = "bake";
		// isOneEditAway = checker.isOneAway(s7, s8);
		// System.out.println(isOneEditAway);

		// String s9 = "";
		// String s10 = "abcd";
		// isOneEditAway = checker.isOneAway(s9, s10);
		// System.out.println(isOneEditAway);
	}
	public boolean isOneAway(String s1, String s2) {
		//delete, insert | replace
		if (s1 == null || s2 == null)	return false;
		if (Math.abs(s1.length() - s2.length()) > 1)	return false;
		String str1 = s1.length() < s2.length() ? s1 : s2;
		String str2 = s1.length() < s2.length() ? s2 : s1;
		int pointer1 = 0;
		int pointer2 = 0;
		boolean isDiff = false;
		while (pointer1 < str1.length() && pointer2 < str2.length()) {
			if (str1.charAt(pointer1) != str2.charAt(pointer2)) {
				if (isDiff)	return false;
				isDiff = true;
				if (str1.length() == str2.length()) {
					pointer1++;
					pointer2++;
				}
				else {
					pointer2++;
				}
			}
			else {
				pointer1++;
				pointer2++;
			}
		}
		System.out.println(pointer1);
		System.out.println(pointer2);
		return pointer1 == str1.length() && (pointer2 == str2.length() || (!isDiff));
	}
}
