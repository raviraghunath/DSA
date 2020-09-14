package Revision;

public class LongestSubString {

	public static void main(String[] args) {
		LongestSubString commonSubSequence = new LongestSubString();
		System.out.println(commonSubSequence.getLSS("bcde", "ace", 0, 0));

	}
	// without cacheing (DP)

	private int getLSS(String s1, String s2, int i, int j) {
		if (i >= s1.length() || j >= s2.length()) {
			return 0;
		}
		if (s1.charAt(i) == s2.charAt(j)) {
			return 1 + getLSS(s1, s2, i + 1, j + 1);
		} else {
			return Math.max(getLSS(s1, s2, i + 1, j), getLSS(s1, s2, i, j + 1));
		}
	}
}
