package ArraysNStrings;

import java.util.HashSet;
import java.util.Set;

public class MaxVowelsInSubString {

	public static void main(String[] args) {
		MaxVowelsInSubString maxVowelsInSubString = new MaxVowelsInSubString();
		System.out.println(maxVowelsInSubString.maxVowelsV1("abciiidef", 3));
		System.out.println(maxVowelsInSubString.maxVowels("ibpbhixfiouhdljnjfflpapptrxgcomvnb", 33));
	}
	// 2 pointer
	public int maxVowels(String s, int k) {
		Set<Character> vowles = new HashSet<Character>();
		vowles.add('a');
		vowles.add('e');
		vowles.add('i');
		vowles.add('o');
		vowles.add('u');
		int res = 0;
		int slwPtr = 0;
		int curr = 0;
		for (int i = 0; i < s.length(); i++) {
			if (i - slwPtr > k - 1) {
				if (vowles.contains(s.charAt(slwPtr))) {
					curr--;
				}
				if (vowles.contains(s.charAt(i))) {
					curr++;
				}
				slwPtr++;
				res = Math.max(curr, res);
			} else {
				if (vowles.contains(s.charAt(i))) {
					curr++;
				}
				if (i == k - 1) {
					res = Math.max(curr, res);
				}
			}
		}
		return res;
	}
	//Sliding window
	public int maxVowelsV1(String s, int k) {
		Set<Character> vowles = new HashSet<Character>();
		vowles.add('a');
		vowles.add('e');
		vowles.add('i');
		vowles.add('o');
		vowles.add('u');
		int res = 0;
		for (int i = 0; i <= s.length() - k; i++) {
			int j = i + k - 1;
			int curr = 0;
			for (int l = i; l <= j; l++) {
				if (vowles.contains(s.charAt(l))) {
					curr++;
				}
			}
			res = Math.max(res, curr);
		}
		return res;
	}

}
