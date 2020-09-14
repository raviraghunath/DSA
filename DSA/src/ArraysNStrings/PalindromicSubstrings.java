package ArraysNStrings;

public class PalindromicSubstrings {
	public static void main(String[] args) {
		PalindromicSubstrings palindromicSubstrings = new PalindromicSubstrings();
		System.out.println(palindromicSubstrings.countSubstrings("aaa"));
	}

	public int countSubstrings(String s) {
		boolean tab[][] = new boolean[s.length()][s.length()];
		int cnt = 0;
		for (int i = 0; i < s.length(); i++) {
			tab[i][i] = true;
			cnt++;
		}
		for (int k = 2; k <= s.length(); k++) {
			for (int i = 0; i < s.length() - k + 1; i++) {
				int j = i + k - 1;
				if (s.charAt(i) == s.charAt(j)) {
					if (k == 2) {
						tab[i][j] = true;
						cnt++;
					} else if (tab[i + 1][j - 1]) {
						tab[i][j] = tab[i + 1][j - 1];
						cnt++;
					}
				}
			}
		}
		return cnt;
	}

	private void print(int tab[][]) {
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[i].length; j++) {
				System.out.print(tab[i][j]);
			}
			System.out.println();
		}
	}
}
