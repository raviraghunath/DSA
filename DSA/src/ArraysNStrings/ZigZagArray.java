//https://leetcode.com/problems/decrease-elements-to-make-array-zigzag/
package ArraysNStrings;

public class ZigZagArray {

	public static void main(String[] args) {
		ZigZagArray zigZagArray = new ZigZagArray();
		System.out.println(zigZagArray.movesToMakeZigzag(new int[] { 10, 4, 4, 10, 10, 6, 2, 3 }));
	}

	public int movesToMakeZigzag(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return 0;
		}
		int res1 = movesToMakeZigzag(nums, 1, 0, nums[0], true);
		int res2 = movesToMakeZigzag(nums, 1, 0, nums[0], false);
		return Math.min(res1, res2);
	}
	
	public int movesToMakeZigzag(int[] nums, int pos, int count, int prev, boolean isInc) {
		if (pos == nums.length) {
			return count;
		}
		if (isInc) {
			if (nums[pos] > prev) {
				prev = nums[pos];
			} else {
				count += prev - nums[pos] + 1;
				prev = prev + 1;
			}
			return movesToMakeZigzag(nums, pos + 1, count, prev, !isInc);
		} else {
			if (nums[pos] < prev) {
				prev = nums[pos];
			} else {
				count += nums[pos] - prev + 1;
				prev = prev - 1;

			}
			return movesToMakeZigzag(nums, pos + 1, count, prev, !isInc);
		}

	}

}
