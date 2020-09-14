package ArraysNStrings;

public class LongestCommonSubSequence {
	public static void main(String[] args) {
		LongestCommonSubSequence commonSubSequence = new LongestCommonSubSequence();
		System.out.println(commonSubSequence.longestCommonSubsequence("bcde", "ace"));
	}

	public int longestCommonSubsequence(String text1, String text2) {
		int cache[][] = new int[text1.length()][text2.length()];
		for (int i = 0; i < cache.length; i++) {
			for (int j = 0; j < cache[i].length; j++) {
				cache[i][j] = -1;
			} 
		}
		int res = getLCS(text1, text2, 0, 0, cache);
		for (int i = 0; i < cache.length; i++) {
			for (int j = 0; j < cache[i].length; j++) {
				System.out.print(cache[i][j]+" ");
			}
			System.out.println();
		}
		return res;
	}

	private int getLCS(String str1, String str2, int i, int j, int cache[][]) {
		if (str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0 || i >= str1.length()
				|| j >= str2.length()) {
			return 0;
		}
		if (cache[i][j] != -1) {
			return cache[i][j];
		}
		if (str1.charAt(i) == str2.charAt(j)) {
			int res = 1 + getLCS(str1, str2, i + 1, j + 1, cache);
			cache[i][j] = res;
			return res;
		} else {
			int res1 = getLCS(str1, str2, i + 1, j, cache);
			int res2 = getLCS(str1, str2, i, j + 1, cache);
			int res = Math.max(res1, res2);
			cache[i][j] = res;
			return res;
		}
	}
}
