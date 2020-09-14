package Revision;

public class LongestCommonSubString {

	public static void main(String[] args) {
		LongestCommonSubString commonSubSequence = new LongestCommonSubString();
		System.out.println(commonSubSequence.getLCS("bcde", "ace", 0 , 0 ));

	}

	private int getLCS(String s1, String s2, int i, int j) {
		if (i >= s1.length() || j >= s2.length()) {
			return 0;
		}
		if (s1.charAt(i) == s2.charAt(j)) {
			return 1 + getLCS(s1, s2, i + 1, j + 1);
		} else {
			return Math.max(getLCS(s1, s2, i, j + 1), getLCS(s1, s2, i + 1, j));
		}
	}

}
