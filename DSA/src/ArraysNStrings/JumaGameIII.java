//https://leetcode.com/problems/jump-game-iii/
package ArraysNStrings;

import java.util.HashSet;
import java.util.Set;

public class JumaGameIII {

	public static void main(String[] args) {
		JumaGameIII jumaGameIII = new JumaGameIII();
		System.out.println(jumaGameIII.canReach(new int[] { 3, 0, 2, 1, 2 }, 2));

	}

	public boolean canReach(int[] arr, int start) {
		int[] cache = new int[arr.length];
		for (int i = 0; i < cache.length; i++) {
			cache[i] = -1;
		}
		return canReach(arr, start, new HashSet<Integer>(), cache);
	}

	public boolean canReach(int[] arr, int start, Set<Integer> visited, int[] cache) {
		if (start < 0 || start >= arr.length) {
			return false;
		}
		if (cache[start] != -1) {
			return cache[start] == 0 ? false : true;
		}
		if (arr[start] == 0) {
			cache[start] = 1;
			return true;
		}
		if (visited.contains(start)) {
			return false;
		}
		visited.add(start);
		boolean b = canReach(arr, start + arr[start], visited, cache)
				|| canReach(arr, start - arr[start], visited, cache);
		cache[start] = b ? 1 : 0;
		return b;
	}


}
