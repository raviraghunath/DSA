//https://leetcode.com/problems/delete-operation-for-two-strings/
package ArraysNStrings;

public class StringMinDistance {

	public static void main(String[] args) {
		StringMinDistance stringMinDistance = new StringMinDistance();
		System.out.println(stringMinDistance.minDistance("sea", "ate"));
		System.out.println(stringMinDistance.minDistanceV1("sea", "ate"));
	}

	public int minDistanceV1(String word1, String word2) {
		int n = word1.length();
		int m = word2.length();
		int[][] t = new int[n + 1][m + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				if (i == 0 || j == 0) {
					t[i][j] = 0;
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					t[i][j] = 1 + t[i - 1][j - 1];
				} else {
					t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
				}
			}
		}
		int lcs = t[n][m];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				System.out.print(t[i][j] + " ");
			}
			System.out.println();
		}
		return (n - lcs) + (m - lcs);
	}

	public int minDistance(String word1, String word2) {
		int[][] cache = new int[word1.length()][word2.length()];
		for (int i = 0; i < cache.length; i++) {
			for (int j = 0; j < cache.length; j++) {
				cache[i][j] = -1;
			}
		}
		if (word1 == null || word2 == null) {
			return 0;
		}
		if (word1.length() == 0 || word2.length() == 0) {
			return word1.length() == 0 ? word2.length() : word1.length();
		}
		int res = minDistance(word1, word2, 0, 0, cache);
		return res == -1 ? word1.length() + word2.length() : res;
	}

	public int minDistance(String word1, String word2, int i, int j, int[][] cache) {
		if (cache[i][j] != -1) {
			return cache[i][j];
		}
		if (word1.length() == i && word2.length() == j) {
			return 0;
		}
		if (i == word1.length() - 1) {
			int tCnt = 0;
			for (int k = j; k < word2.length(); k++) {
				if (word1.charAt(i) == word2.charAt(k)) {
					tCnt++;
					break;
				}
			}
			return 1 + (word2.length() - j) - (2 * tCnt);
		}
		if (j == word2.length() - 1) {
			int tCnt = 0;
			for (int k = i; k < word1.length(); k++) {
				if (word1.charAt(k) == word2.charAt(j)) {
					tCnt++;
					break;
				}
			}
			return 1 + (word1.length() - i) - (2 * tCnt);
		}

		char c1 = word1.charAt(i);
		char c2 = word2.charAt(j);
		int res = 0;
		if (c1 == c2) {
			res = minDistance(word1, word2, i + 1, j + 1, cache);
		} else {
			int res1 = 2 + minDistance(word1, word2, i + 1, j + 1, cache);
			int res2 = 1 + minDistance(word1, word2, i, j + 1, cache);
			int res3 = 1 + minDistance(word1, word2, i + 1, j, cache);
			res = Math.min(res1, Math.min(res2, res3));
		}
		cache[i][j] = res;
		return res;
	}

}
