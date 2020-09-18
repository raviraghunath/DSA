package ArraysNStrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LIS_LongestIncrSubSequence {

	public static void main(String[] args) {
		LIS_LongestIncrSubSequence lis_LongestIncrSubSequence = new LIS_LongestIncrSubSequence();
		System.out.println(lis_LongestIncrSubSequence.lengthOfLIS(new int[] {  3, 10, 2, 11 }));
		System.out.println(lis_LongestIncrSubSequence.lengthOfLISV1(new int[] { 3, 10, 2, 11 }));
	}

	public int lengthOfLISV1(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int n = nums.length;
		int[] f = new int[n]; // states
		Arrays.fill(f, 1); // initialization
		int ans = 1;
		// function
		for (int i = 0; i < n; i++) {
			for (int j = i ; j < n; j++) {
				if (nums[i] < nums[j]) {
					f[j] = Math.max(f[j], f[i] + 1);
					ans = Math.max(ans, f[j]);
				}
			}
			// answer
		}
		return ans;
	}

	public int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		return lengthOfLIS(nums, 0, Integer.MIN_VALUE, new HashMap<Integer, Map<Integer, Integer>>());
	}

	public int lengthOfLIS(int[] nums, int pos, int prev, Map<Integer, Map<Integer, Integer>> cache) {
		Map<Integer, Integer> prevMap = cache.get(pos);
		if (prevMap != null) {
			Integer cVal = prevMap.get(prev);
			if (cVal != null) {
				return cVal;
			}
		}
		int res = 0;
		for (int i = pos; i < nums.length; i++) {
			if (prev == Integer.MIN_VALUE || prev < nums[i]) {
				res = Math.max(res, 1 + lengthOfLIS(nums, i + 1, nums[i], cache));
			}
		}
		if (prevMap == null) {
			prevMap = new HashMap<Integer, Integer>();
			cache.put(pos, prevMap);
		}
		prevMap.put(prev, res);
		return res;
	}

}
