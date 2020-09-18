//https://leetcode.com/problems/swap-for-longest-repeated-character-substring/
package ArraysNStrings;

public class SwapLongestRepeatedSubString {

	public static void main(String[] args) {
		SwapLongestRepeatedSubString swapLongestRepeatedSubString = new SwapLongestRepeatedSubString();
		System.out.println(swapLongestRepeatedSubString.maxRepOpt1V1("bbababaaaa"));
		System.out.println(swapLongestRepeatedSubString.maxRepOpt1("bbababaaaa"));

	}
	
	
	// Focus 
	public int maxRepOpt1(String text) {
		int[][] tab = new int[26][2];
		int count[] = new int[26];
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[i].length; j++) {
				tab[i][j] = -1;
			}
		}
		for (int i = 0; i < text.length(); i++) {
			count[text.charAt(i) - 'a'] = count[text.charAt(i) - 'a'] + 1;
		}
		int i = 0;
		int max = 0;
		while (i < text.length()) {
			char c = text.charAt(i);
			int index = c - 'a';
			int currSt = i;
			while (i < text.length() && c == text.charAt(i)) {
				i++;
			}
			int currBlockLen = i - currSt;
			if (tab[index][0] != -1 && tab[index][1] + 2 == currSt) {
				int prevBlockLen = tab[index][1] - tab[index][0] + 1;
				if (count[index] > currBlockLen + prevBlockLen) {
					max = Math.max(max, currBlockLen + prevBlockLen + 1);
				} else {
					max = Math.max(max, currBlockLen + prevBlockLen);
				}
			} else {
				if (count[index] > currBlockLen) {
					max = Math.max(max, currBlockLen + 1);
				} else {
					max = Math.max(max, currBlockLen);
				}
			}
			tab[index][0] = currSt;
			tab[index][1] = i - 1;
		}
		return max;
	}

	public int maxRepOpt1V1(String text) {

		int max = 0;

		int slwPtr = 0;
		int tCnt = 0;
		while (slwPtr < text.length()) {
			tCnt = 0;
			for (int i = 0; i < text.length(); i++) {
				if (text.charAt(slwPtr) == text.charAt(i)) {
					tCnt++;
				} else {
					tCnt = 0;
					int l1 = getRes(text.charAt(slwPtr), text, i, slwPtr) + 1;
					int l2 = getRes(text.charAt(i), text, slwPtr, i) + 1;
					max = Math.max(max, Math.max(l1, l2));
				}
				if (i == text.length() - 1) {
					slwPtr++;
				}
			}
		}
		return Math.max(max, tCnt);

	}

	private int getRes(char c, String s, int pos, int excldePos) {
		int cnt = 0;
		for (int i = pos - 1; i >= 0; i--) {
			if (s.charAt(i) == c && i != excldePos) {
				cnt++;
			} else {
				break;
			}
		}
		for (int i = pos + 1; i < s.length(); i++) {
			if (s.charAt(i) == c && i != excldePos) {
				cnt++;
			} else {
				break;
			}
		}
		return cnt;
	}
}
