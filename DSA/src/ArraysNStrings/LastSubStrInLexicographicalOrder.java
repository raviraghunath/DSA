package ArraysNStrings;

import java.util.ArrayList;
import java.util.List;

public class LastSubStrInLexicographicalOrder {

	public static void main(String[] args) {
		LastSubStrInLexicographicalOrder lastSubStrInLexicographicalOrder = new LastSubStrInLexicographicalOrder();
		System.out.println(lastSubStrInLexicographicalOrder.lastSubstringV1("zrziy"));
		System.out.println(lastSubStrInLexicographicalOrder.lastSubstringV2("vmjtxddvzmwrjvfamgpoowncslddrkjhchqswkamnsitrcmnhn"));
		System.out.println(lastSubStrInLexicographicalOrder.lastSubstring("vmjtxddvzmwrjvfamgpoowncslddrkjhchqswkamnsitrcmnhn"));
	}

	public String lastSubstring(String str) {
		int maxC = str.charAt(0);
		List<Integer> indexes = new ArrayList<Integer>();
		for (int i = 1; i < str.length(); ++i) {
			if (maxC <= str.charAt(i)) {
				maxC = str.charAt(i);
				indexes.add(i);
			}
		}
		if (str.charAt(0) == str.charAt(indexes.get(0))) {
			indexes.add(0, 0);
		}
		int prev = indexes.get(0);
		int max = prev;
		for (int i = 1; i < indexes.size(); i++) {
			int curr = indexes.get(i);
			while (curr < str.length() && str.charAt(max) == str.charAt(curr)) {
				max++;
				curr++;
			}
			if (curr < str.length() && isBigger(str, curr, max)) {
				max = indexes.get(i);
				prev = max;
			} else {
				max = prev;
			}

		}
		return str.substring(prev);
	}

	private boolean isBigger(String s, int i, int j) {
		return s.charAt(i) >= s.charAt(j);
	}

	public String lastSubstringV2(String str) {
		int maxC = str.charAt(0);
		List<Integer> indexes = new ArrayList<Integer>();
		for (int i = 0; i < str.length(); ++i) {
			if (maxC <= str.charAt(i)) {
				maxC = str.charAt(i);
				indexes.add(i);
			}
		}
		if (indexes.size() == str.length()) {
			return str;
		}
		String maxSubString = str.substring(indexes.get(0));
		for (Integer i : indexes) {
			String t = str.substring(i);
			if (maxSubString.compareTo(t) <= 0) {
				maxSubString = t;
			}
		}
		return maxSubString;
	}

	public String lastSubstringV1(String str) {
		String mx = "";
		for (int i = 0; i < str.length(); ++i) {
			if (mx.compareTo(str.substring(i)) <= 0) {
				mx = str.substring(i);
			}
		}
		return mx;
	}

}
