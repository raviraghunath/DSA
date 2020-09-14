//https://leetcode.com/problems/permutation-in-string/
package ArraysNStrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.

public class CheckInclusion {

	public static void main(String[] args) {
		CheckInclusion checkInclusion = new CheckInclusion();
		System.out.println(checkInclusion.checkInclusionV1("ab", "abab"));
	}

	public boolean checkInclusionV1(String s1, String s2) {
		Map<Character, Integer> map = fillMap(s1);
		boolean fnd = false;
		int currCnt = 0;
		int currSt = 0;
		for (int i = 0; i < s2.length() || currCnt == s1.length(); i++) {
			if (currCnt == s1.length()) {
				fnd = true;
				System.out.println(currSt);
				currSt++;
				i = currSt;
				map = fillMap(s1);
				currCnt = 0;
			}
			Integer val = map.get(s2.charAt(i));
			if (val != null) {
				if (val > 1) {
					map.put(s2.charAt(i), val - 1);
				} else {
					map.remove(s2.charAt(i));
				}
				currCnt++;
			} else {
				i = currSt++;
				map = fillMap(s1);
				currCnt = 0;
			}
		}
		return fnd;
	}

	private Map<Character, Integer> fillMap(String s1) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s1.length(); i++) {
			if (map.containsKey(s1.charAt(i))) {
				map.put(s1.charAt(i), map.get(s1.charAt(i)) + 1);
			} else {
				map.put(s1.charAt(i), 1);
			}
		}
		return map;
	}

	public boolean checkInclusion(String s1, String s2) {
		if (s1 == null) {
			return true;
		}
		if (s2 == null || s2.length() < s1.length()) {
			return false;
		}
		List<String> list = new ArrayList<String>();
		getPerumtationOfString(s1, 0, list);
		for (String str : list) {
			if (s2.contains(str)) {
				return true;
			}
		}
		return false;
	}

	private void getPerumtationOfString(String s, int pos, List<String> list) {
		if (s == null || s.length() == 0) {
			return;
		}
		if (pos == s.length() - 1) {
			list.add(s);
			return;
		}
		for (int i = pos; i < s.length(); i++) {
			getPerumtationOfString(swapChar(s, pos, i), pos + 1, list);
		}
	}

	private String swapChar(String s, int i, int j) {
		char[] charArr = s.toCharArray();
		char t = charArr[i];
		charArr[i] = charArr[j];
		charArr[j] = t;
		return new String(charArr);
	}

}
