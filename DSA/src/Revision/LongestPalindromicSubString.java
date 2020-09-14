package Revision;

public class LongestPalindromicSubString {

	public static void main(String[] args) {
		LongestPalindromicSubString longestPalindromicSubString = new LongestPalindromicSubString();
		System.out.println(longestPalindromicSubString.getLPS("GEEKSFORGEEKS", 0, "GEEKSFORGEEKS".length() - 1));
		System.out.println(longestPalindromicSubString.getLPSDp("GEEKSFORGEEKS"));
	}

	private int getLPS(String s, int i, int j) {
		if (i > j) {
			return 0;
		}
				
		if (i == j) {
			return 1;
		} else if (s.charAt(i) == s.charAt(j) && i + 1 == j) {
			return 2;
		} else if (s.charAt(i) == s.charAt(j)) {
			return 2 + getLPS(s, i + 1, j - 1);
		} else {
			return Math.max(getLPS(s, i + 1, j), getLPS(s, i, j - 1));
		}

	}

	private int getLPSDp(String s) {
		int tab[][] = new int[s.length()][s.length()];
		for (int i = 0; i < s.length(); i++) {
			tab[i][i] = 1;
		}
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1))
				tab[i][i + 1] = 2;
		}
		for (int len = 3; len <= s.length(); len++) {
			for (int i = 0; i < s.length() - len + 1; i++) {
				int j = i + len - 1;
				if (s.charAt(i) == s.charAt(j)) {
					tab[i][j] = 2 + tab[i + 1][j - 1];
				}else {
					tab[i][j] = Math.max(tab[i+1][j], tab[i][j-1]);
				}
			}
		}
		return tab[0][s.length() - 1];
	}

}
