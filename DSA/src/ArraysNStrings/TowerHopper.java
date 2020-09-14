package ArraysNStrings;

import java.util.HashMap;
import java.util.Map;

public class TowerHopper {

	public static void main(String[] args) {
		TowerHopper towerHopper = new TowerHopper();
		System.out.println(towerHopper.jump(new int[] { 2, 3, 1, 1, 4 }));
	}

	public int jump(int[] nums) {
		Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
		return doHop(nums, 0, cache);
	}

	private int doHop(int arr[], int pos, Map<Integer, Integer> cache) {
		if (cache.containsKey(pos)) {
			return cache.get(pos);
		}
		if (pos >= arr.length) {
			cache.put(pos, -1);
			return -1;
		}
		if (pos == arr.length - 1) {
			cache.put(pos, 0);
			return 0;
		}
		int i = pos + 1;
		int ele = arr[pos];
		int minCnt = -1;
		while (i <= pos + ele) {
			int currCnt = doHop(arr, i, cache);
			if (currCnt != -1) {
				currCnt++;
				if (minCnt == -1 || currCnt < minCnt) {
					minCnt = currCnt;
				}
			}
			i++;
		}
		int res = minCnt == Integer.MAX_VALUE ? -1 : minCnt;
		cache.put(pos, res);
		return res;
	}

}
