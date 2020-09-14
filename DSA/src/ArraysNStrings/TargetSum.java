//https://leetcode.com/problems/target-sum/
package ArraysNStrings;

public class TargetSum {

	public static void main(String[] args) {
		TargetSum targetSum = new TargetSum();
		System.out.println(targetSum.findTargetSumWays(new int[] { 1, 1, 1, 1, 1 }, 3, 0));
	}

	public int findTargetSumWays(int[] nums, int S) {
		return findTargetSumWays(nums, S, 0);
	}

	private int findTargetSumWays(int[] nums, int S, int pos) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		if (S == 0 && pos == nums.length) {
			return 1;
		}
		if (pos == nums.length) {
			return -1;
		}
		int res = 0;
		int c1 = findTargetSumWays(nums, S - nums[pos], pos + 1);
		if (c1 != -1) {
			res += c1;
		}
		int c2 = findTargetSumWays(nums, S + nums[pos], pos + 1);
		if (c2 != -1) {
			res += c2;
		}

		return res;
	}
}
