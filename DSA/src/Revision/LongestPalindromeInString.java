package Revision;

public class LongestPalindromeInString {

	public static void main(String[] args) {
		LongestPalindromeInString longestPalindromeInString = new LongestPalindromeInString();
		String s = "forgeeksskeegfor";
		System.out.println(longestPalindromeInString.getLongestPalindrome(s));
		System.out.println(longestPalindromeInString.getLongestPalindromeV1(s));
	}

	private String getLongestPalindromeV1(String str) {
		boolean tab[][] = new boolean[str.length()][str.length()];
		int maxSt = 0;
		int maxEd = 0;
		int maxLen = 1;
		for (int i = 0; i < str.length(); i++) {
			tab[i][i] = true;
		}
		for (int i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) == str.charAt(i + 1)) {
				tab[i][i + 1] = true;
				maxLen = 2;
				maxSt = i;
				maxEd = i + 1;
			}
		}
		for (int diff = 3; diff < str.length(); diff++) {
			for (int i = 0; i < str.length() - diff + 1; i++) {
				int j = i + diff - 1;
				if (tab[i + 1][j - 1] == true && str.charAt(i) == str.charAt(j)) {
					tab[i][j] = true;
					if(maxLen<diff) {
						maxLen=diff;
						maxSt=i;
						maxEd=j;
					}
				}
			}

		}
return str.substring(maxSt, maxEd+1);
	}

	private String getLongestPalindrome(String str) {
		String res = null;
		for (int i = 0; i < str.length() - 1; i++) {
			String res1 = expand(str, i, i);
			if (res == null || res.length() < res1.length()) {
				res = res1;
			}
			String res2 = expand(str, i, i + 1);
			if (res == null || res.length() < res2.length()) {
				res = res2;
			}
		}
		return res;
	}

	private String expand(String s, int st, int ed) {
		int i = st;
		int j = ed;
		while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
			i--;
			j++;
		}
		return s.substring(i + 1, j);
	}

}
