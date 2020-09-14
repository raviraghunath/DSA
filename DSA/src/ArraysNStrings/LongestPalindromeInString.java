//https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/
//https://medium.com/@bhprtk/longest-palindromic-substring-a8190fab03ff
package ArraysNStrings;

public class LongestPalindromeInString {
	public static void main(String[] args) {
		LongestPalindromeInString longestPalindromeInString = new LongestPalindromeInString();
		System.out.println(longestPalindromeInString.getLongestPalindrome("forgeeksskeegfor"));
		System.out.println(longestPalindromeInString.getLongestPalindrome_V1("forgeeksskeegfor"));
		System.out.println(longestPalindromeInString.getLongestPalindrome_V2("forgeeksskeegfor"));
		System.out.println(longestPalindromeInString.getLongestPalindrome_V3("eeee3eeee", 0, "eeee3eeee".length()-1));
	}

	private String getLongestPalindrome_V2(String s) {
		int n = s.length();
		int max = 1;
		int maxSt = 0;
		int maxEd = 0;
		boolean table[][] = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			table[i][i] = true;
		}
		for (int i = 0; i < n - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				table[i][i + 1] = true;
				int currLen = 2;
				if (currLen > max) {
					max = currLen;
					maxSt = i;
					maxEd = i + 1;
				}
			}
		}
		for (int k = 3; k <= n; k++) {
			for (int i = 0; i < (n - k + 1); i++) {
				int j = i + k - 1;
				if (table[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
					table[i][j] = true;
					int currLen = j - i + 1;
					if (currLen > max) {
						max = currLen;
						maxSt = i;
						maxEd = j;
					}
				}
			}
		}
		return s.substring(maxSt, maxEd + 1);
	}

	private String getLongestPalindrome_V1(String s) {
		if (s == null || s.length() <= 1) {
			return s;
		}
		String res = null;
		for (int i = 0; i < s.length() - 1; i++) {
			String s1 = expand(s, i, i);
			if (res == null || res.length() < s1.length()) {
				res = s1;
			}
			String s2 = expand(s, i, i + 1);
			if (res == null || res.length() < s2.length()) {
				res = s2;
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

	private int getLongestPalindrome_V3(String s, int st, int ed) {
		if (st > ed) {
			return 0;
		}
		if (st == ed) {
			return 1;
		}
		if (s.charAt(st) == s.charAt(ed) && st + 1 == ed) {
			return 2;
		}
		if (s.charAt(st) == s.charAt(ed)) {
			return 2 + getLongestPalindrome_V3(s, st + 1, ed - 1);
		} else {
			return Math.max(getLongestPalindrome_V3(s, st + 1, ed), getLongestPalindrome_V3(s, st, ed - 1));
		}
	}

	// Brute Froce
	private String getLongestPalindrome(String s) {
		if (s == null || s.length() <= 1) {
			return s;
		}
		int max = 0;
		int maxSt = 0;
		int maxEd = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				if (isPalindrome(s, i, j)) {
					int currLen = j - i + 1;
					if (max < currLen) {
						max = currLen;
						maxSt = i;
						maxEd = j;
					}
				}
			}
		}
		return s.substring(maxSt, maxEd + 1);
	}

	private boolean isPalindrome(String s, int st, int ed) {
		boolean res = true;
		while (st < ed) {
			if (s.charAt(st) != s.charAt(ed)) {
				res = false;
				break;
			}
			st++;
			ed--;
		}
		return res;
	}
}
