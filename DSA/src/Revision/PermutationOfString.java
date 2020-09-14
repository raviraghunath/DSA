package Revision;

import java.util.ArrayList;
import java.util.List;

public class PermutationOfString {

	public static void main(String[] args) {
		PermutationOfString permutationOfString = new PermutationOfString();
		System.out.println(permutationOfString.getPermutation("abc", 0));
	}

	private List<String> getPermutation(String s, int pos) {
		if (pos == s.length() - 1) {
			List<String> list = new ArrayList<String>();
			list.add(s);
			return list;
		}
		List<String> list = new ArrayList<String>();
		for (int i = pos; i < s.length(); i++) {
			String s1 = swap(s, pos, i);
			list.addAll(getPermutation(s1, pos + 1));
		}
		return list;
	}

	private String swap(String str, int i, int j) {
		if (i == j) {
			return str;
		}
		char[] chars = str.toCharArray();
		char t = chars[i];
		chars[i] = chars[j];
		chars[j] = t;
		return new String(chars);

	}

}
