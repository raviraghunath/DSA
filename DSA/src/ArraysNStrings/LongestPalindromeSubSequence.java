//https://www.geeksforgeeks.org/longest-palindromic-subsequence-dp-12/
package ArraysNStrings;

public class LongestPalindromeSubSequence {
	public static void main(String[] args) {
		LongestPalindromeSubSequence longestPalindromeSubSequence = new LongestPalindromeSubSequence();
		System.out.println(longestPalindromeSubSequence.longestPalindromeSubseq("madm"));
		System.out.println(longestPalindromeSubSequence.lps("madm".toCharArray(), 0, "madm".length()-1));
	}

	public int longestPalindromeSubseq(String s) {
		return lpsDp(s);
	}

	int lpsDp(String s) {
		int tab[][] = new int[s.length()][s.length()];
		for (int i = 0; i < s.length(); i++) {
			tab[i][i] = 1;
		}
		int max = 1;
		for (int l = 2; l <= s.length(); l++) {
			for (int i = 0; i < s.length() - l + 1; i++) {
				int j = i + l - 1;
				if (s.charAt(i) == s.charAt(j) && l == 2) {
					tab[i][j] = 2;
				} else if (s.charAt(i) == s.charAt(j)) {
					tab[i][j] = 2 + tab[i + 1][j - 1];
				} else {
					tab[i][j] = Math.max(tab[i][j - 1], tab[i + 1][j]);
				}
				if (max < tab[i][j]) {
					max = tab[i][j];
				}
			}
		}
		print(tab);
		System.out.println(tab[0][s.length() - 1]);
		return max;
	}

	private void print(int tab[][]) {
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[i].length; j++) {
				System.out.print(tab[i][j]);
			}
			System.out.println();
		}
	}

	int lps(char seq[], int i, int j) {
		// Base Case 1: If there is only 1 character
		if (i == j) {
			return 1;
		}

		// Base Case 2: If there are only 2 characters and both are same
		if (seq[i] == seq[j] && i + 1 == j) {
			return 2;
		}

		// If the first and last characters match
		if (seq[i] == seq[j]) {
			return lps(seq, i + 1, j - 1) + 2;
		}

		// If the first and last characters do not match
		return Math.max(lps(seq, i, j - 1), lps(seq, i + 1, j));
	}
}
