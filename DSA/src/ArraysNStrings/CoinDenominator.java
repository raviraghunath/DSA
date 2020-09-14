package ArraysNStrings;

import java.util.HashMap;
import java.util.Map;

public class CoinDenominator {

	public static void main(String[] args) {
		CoinDenominator coinDenominator = new CoinDenominator();
//		System.out.println(coinDenominator.getDenoV1(new int[] { 25, 10, 5, 1 }, 0, 100));
		int n = 8539;
		int denom[] = new int[] { 19, 28, 176, 112, 30, 260, 491, 128, 70, 137, 253 };
		int[][] cache = new int[n + 1][denom.length];
		System.out.println(coinDenominator.getMinDenoV1(denom, 0, n, cache));
	}

	private int getDenoV1(int arr[], int i, int sum) {
		if (sum < 0 || i >= arr.length) {
			return 0;
		}
		if (sum == 0) {
			return 1;
		}
		return getDenoV1(arr, i, sum - arr[i]) + getDenoV1(arr, i + 1, sum);
	}

	private int getMinDenoV1(int arr[], int pos, int sum, int[][] cache) {
		if (sum == 0) {
			return 0;
		}
		if (sum < 0 || pos >= arr.length) {
			return -1;
		}
		int cVal = cache[sum][pos];
		if (cVal != 0) {
			return cVal;
		}
		int minNum = Integer.MAX_VALUE;
		for (int i = 0; i <= (sum / arr[pos]); i++) {
			int remAmt = sum - (i * arr[pos]);
			int res = getMinDenoV1(arr, pos + 1, remAmt, cache);
			if (res != -1) {
				res += i;
				if (res < minNum) {
					minNum = res;
				}
			}
		}
		int res = minNum == Integer.MAX_VALUE ? -1 : minNum;
		cache[sum][pos] = res;
		return res;
	}

	private void putCacheVal(Map<Integer, Map<Integer, Integer>> cache, int amt, int i, int val) {
		Map<Integer, Integer> subMap = cache.get(amt);
		if (subMap == null) {
			subMap = new HashMap<Integer, Integer>();
			cache.put(amt, subMap);
		}
		subMap.put(i, val);

	}

	private Integer gettCacheVal(Map<Integer, Map<Integer, Integer>> cache, int amt, int i) {
		Map<Integer, Integer> subMap = cache.get(amt);
		if (subMap == null) {
			return null;
		}
		return subMap.get(i);
	}

}
