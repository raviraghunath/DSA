package ArraysNStrings;

import java.util.Arrays;

public class IncreasingTripletSubsequence {

	public static void main(String[] args) {
		IncreasingTripletSubsequence increasingTripletSubsequence = new IncreasingTripletSubsequence();
		System.out.println(increasingTripletSubsequence.increasingTriplet(new int[] { 1, 2, 3, 4, 5 }));
		System.out.println(increasingTripletSubsequence.findNumberOfLIS(new int[] { 2, 2, 2, 2, 2 }));

	}

	public boolean increasingTriplet(int[] nums) {
		int f[] = new int[nums.length];
		Arrays.fill(f, 1);

		for (int i = 0; i < nums.length; i++) {
			for (int j = i; j < nums.length; j++) {
				if (nums[i] < nums[j]) {
					f[j] = Math.max(f[j], f[i] + 1);
					if (f[j] == 3) {
						return true;
					}
				}
			}
		}
		return false;
	}

	// https://leetcode.com/problems/number-of-longest-increasing-subsequence/
	public int findNumberOfLIS(int[] nums) {
		int f[] = new int[nums.length];
		Arrays.fill(f, 1);
		int ans = 1;
		int cnt = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i; j < nums.length; j++) {
				if (nums[i] < nums[j]) {
					f[j] = Math.max(f[j], f[i] + 1);
					if (ans < f[j]) {
						ans = f[j];
						cnt = 1;
					} else if (f[j] == ans) {
						cnt++;
					}
				}
			}
		}
		return cnt;
	}
}
