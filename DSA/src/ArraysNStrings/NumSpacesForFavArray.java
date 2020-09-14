//https://www.youtube.com/watch?v=tOD6g7rF7NA
package ArraysNStrings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NumSpacesForFavArray {

	public static void main(String[] args) {
		NumSpacesForFavArray numSpacesForFavArray = new NumSpacesForFavArray();
		String s = "3141592653589793238462643383279";
		String[] favs = new String[] { "314", "49", "9001", "15926535897", "14", "9323", "8462643383279", "4", "793",
				"3141592653589793" ,"238462643383279","314159265358979323846264338327","3141592653589793238462643383279" };
		int minSpaces = numSpacesForFavArray.minSpaces(s, favs);
		System.out.println(minSpaces);
	}

	private int minSpaces(String s, String[] favs) { 
		Set<String> set = new HashSet<String>();
		for (String str : favs) {
			set.add(str);
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		return check(0, s, set, Integer.MAX_VALUE, map);
	}

	private int check(int pos, String s, Set<String> strs, int ans, Map<Integer, Integer> map) {
		if (pos >= s.length()) {
			return 0;
		}
		if(map.get(pos)!=null) {
			return map.get(pos);
		}
		String curr = "";
		boolean isMatch = false;
		for (int i = pos; i < s.length(); i++) {
			curr += s.charAt(i);
			if (strs.contains(curr)) {
				isMatch = true;
				int o = check(i + 1, s, strs, ans, map);
				ans = Math.min(ans, 1 + o);
				System.out.println(curr + "," + ans);
			}
		}
		int res = isMatch ? ans : 0;
		map.put(pos, res);
		return res;
	}

}
