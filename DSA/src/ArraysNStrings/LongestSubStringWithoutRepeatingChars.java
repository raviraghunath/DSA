package ArraysNStrings;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubStringWithoutRepeatingChars {

	public static void main(String args[]) {
		LongestSubStringWithoutRepeatingChars chars = new LongestSubStringWithoutRepeatingChars();
		int max = chars.lengthOfLongestSubstring("abba");
		System.out.println(max);
		max = chars.lengthOfLongestSubstring_V1("abba");
		System.out.println(max);
	}

	public int lengthOfLongestSubstring(String s) { 
		Map<Character, Integer> map = new HashMap<Character, Integer>(s.length());
		int max = 0;
		int curr = 0;
		int currstPos = 0;
		for (int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			if (map.containsKey(c)) {
				int i1 = map.get(c);
				if (max < curr)
					max = curr;
				curr = i - i1;
				for (int j = currstPos; j <= i1; j++) {
					Character cj = s.charAt(j);
					map.remove(cj);
				}
				map.put(c, i);
				currstPos = i1 + 1;
			} else {
				curr++;
				map.put(c, i);
			}
		}
		if (max < curr)
			max = curr;
		return max;
	}

	public int lengthOfLongestSubstring_V1(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>(s.length());
		int max = 0;
		int curr = 0;
		for (int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			curr = Math.min(i - map.getOrDefault(c, -1), curr + 1);
			map.put(c, i);
			max = Math.max(max, curr);
		}
		return max;
	}

}
