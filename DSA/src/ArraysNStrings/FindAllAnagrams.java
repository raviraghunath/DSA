//https://leetcode.com/problems/find-all-anagrams-in-a-string/submissions/
package ArraysNStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class FindAllAnagrams {

	public static void main(String[] args) {
		FindAllAnagrams findAllAnagrams = new FindAllAnagrams();
		System.out.println(findAllAnagrams.findAnagramsV1("abab", "ab"));
		System.out.println(findAllAnagrams.findAnagramsV2("abab", "ab"));
		System.out.println(findAllAnagrams.findAnagramsV3("abab", "ab"));
		System.out.println(findAllAnagrams.findAnagrams("abab", "ab"));

	}
	//Optimal
	public List<Integer> findAnagrams(String s, String p) {
		if (s == null || p == null || s.length() == 0 || p.length() == 0) {
			return new ArrayList<Integer>(1);
		}
		List<Integer> res = new ArrayList<Integer>();
		int[] arr = buildArray(p);
		int pLen = p.length();
		int sLen = s.length();
		int i = 0;
		while (i <= (sLen - pLen)) {
			String ss = s.substring(i, i + pLen);
			int[] arr1 = buildArray(ss);
			if (Arrays.equals(arr, arr1)) {
				res.add(i);
			}
			i++;
		}
		return res;
	}

	public List<Integer> findAnagramsV3(String s, String p) {
		if (s == null || p == null || s.length() == 0 || p.length() == 0) {
			return new ArrayList<Integer>(1);
		}
		List<Integer> res = new ArrayList<Integer>();
		Map<Character, Integer> map = buildMap(p);
		int pLen = p.length();
		int sLen = s.length();
		int i = 0;
		while (i <= (sLen - pLen)) {
			String ss = s.substring(i, i + pLen);
			Map<Character, Integer> map1 = buildMap(ss);
			if (map.equals(map1)) {
				res.add(i);
			}
			i++;
		}
		return res;
	}

	private int[] buildArray(String p) {
		int res[] = new int[26];
		for (int i = 0; i < p.length(); i++) {
			res[p.charAt(i) - 'a']++;
		}
		return res;
	}

	public List<Integer> findAnagramsV2(String s, String p) {
		if (s == null || p == null || s.length() == 0 || p.length() == 0) {
			return new ArrayList<Integer>(1);
		}
		List<Integer> res = new ArrayList<Integer>();
		Map<Character, Integer> map = buildMap(p);
		int pLen = p.length();
		int sLen = s.length();
		int i = 0;
		outer: while (i <= (sLen - pLen)) {
			Map<Character, Integer> map1 = new HashMap<Character, Integer>();
			for (int j = i; j < i + pLen; j++) {
				char c = s.charAt(j);
				if (map1.containsKey(c)) {
					map1.put(c, map1.get(c) - 1);
				} else {
					if (map.containsKey(c)) {
						map1.put(c, map.get(c) - 1);
					} else {
						i++;
						continue outer;
					}
				}
			}
			if (isNormalized(map1)) {
				res.add(i);
			}
			i++;
		}
		return res;
	}

	public List<Integer> findAnagramsV1(String s, String p) {
		if (s == null || p == null || s.length() == 0 || p.length() == 0) {
			return new ArrayList<Integer>();
		}
		List<Integer> res = new ArrayList<Integer>();
		int i = 0;
		int pLen = p.length();
		int sLen = s.length();
		outer: while (i <= (sLen - pLen)) {
			Map<Character, Integer> map = buildMap(p);
			for (int j = i; j < i + pLen; j++) {
				if (!map.containsKey(s.charAt(j))) {
					i++;
					continue outer;
				} else {
					map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
				}
			}
			if (isNormalized(map)) {
				res.add(i);
			}
			i++;
		}

		return res;

	}

	private Map<Character, Integer> buildMap(String p) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < p.length(); i++) {
			char c = p.charAt(i);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		return map;
	}

	private boolean isNormalized(Map<Character, Integer> map) {
		for (Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() != 0) {
				return false;
			}
		}
		return true;
	}

}
