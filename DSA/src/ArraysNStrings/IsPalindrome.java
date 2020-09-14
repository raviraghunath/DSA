package ArraysNStrings;

public class IsPalindrome {

	public static void main(String[] args) {
		IsPalindrome isPalindrome = new IsPalindrome();
		System.out.println(isPalindrome.isPalindrome("tacoecat"));
	}

	private boolean isPalindrome(String s) {
		int i = 0;
		int j = s.length() - 1;
		while (s.charAt(i) == s.charAt(j) && i < j) {
			i++;
			j--;
		}
		return s.length() % 2 == 0 ? i == j + 1 : i == j;
	}

}
