package ArraysNStrings;

public class ShortestPalindrome {

	public static void main(String[] args) {
		ShortestPalindrome shortestPalindrome = new ShortestPalindrome();
		System.out.println(shortestPalindrome.shortestPalindrome("aacecaaa"));
	}

	public String shortestPalindrome(String s) {
		if (s == null || s.length() <= 1) {
			return s;
		}
		if (isPalindrome(s, 0, s.length() - 1)) {
			return s;
		}

		String omittedStr = "";
		for (int i = s.length() - 2; i > 0; i--) {
			omittedStr += s.charAt(i+1);
			if (isPalindrome(s, 0, i )) {
				return omittedStr + s ;
			}
		}
		return revStr(s.substring(1, s.length())) + s;
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

	private String revStr(String s) {
		String rev = "";
		for (int j = s.length() - 1; j >= 0; j--) {
			rev += s.charAt(j);
		}
		return rev;
	}

}
