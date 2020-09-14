package ArraysNStrings;

import java.util.HashMap;
import java.util.Map;

public class SumpPairs {
	public static void main(String[] args) {
		SumpPairs sumpPairs = new SumpPairs();
		System.out.println(sumpPairs.numberOfWays(new int[] { 1, 5, 3, 3, 3 }, 6));
	}

		int numberOfWays(int[] arr, int k) {
			Map<Integer, Integer> set = new HashMap<Integer, Integer>();
			int ways = 0;
			for (int i : arr) {
				if (set.containsKey(k - i)) {
					ways += set.get(k - i);
				}
				if (set.containsKey(i)) {
					set.put(i, set.get(i) + 1);
				} else {
					set.put(i, 1);
				}
			}
			return ways;
		}
}
