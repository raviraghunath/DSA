//https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/
package ArraysNStrings;

public class LogestSubArrayAfterDeleting1Ele {

	public static void main(String[] args) {
		LogestSubArrayAfterDeleting1Ele logestSubArrayAfterDeleting1Ele = new LogestSubArrayAfterDeleting1Ele();
		int[] arr = new int[] { 1, 1, 1 };
		System.out.println(logestSubArrayAfterDeleting1Ele.longestSubarrayV1(arr));
		System.out.println(logestSubArrayAfterDeleting1Ele.longestSubarray(arr));
	}

	public int longestSubarray(int[] nums) {
		int slwPtr = 0;
		int fstPtr = 0;
		int maxLen = 0;
		int currLen = 0;
		int i = 0;
		while (fstPtr < nums.length) {
			if (nums[i] == 1) {
				if (slwPtr == fstPtr) {
					slwPtr++;
					fstPtr++;
					currLen++;
				} else {
					if (nums[fstPtr] == 0) {
						slwPtr++;
						currLen++;
					} else {
						fstPtr++;
						currLen++;
					}
				}
			} else {
				if (slwPtr == fstPtr) {
					fstPtr++;
				} else {
					maxLen = Math.max(maxLen, currLen);
					currLen = 0;
					i = slwPtr;
					slwPtr++;
				}
			}
			i++;
		}
		maxLen = Math.max(maxLen, currLen);
		return maxLen == nums.length ? maxLen - 1 : maxLen;
	}

	public int longestSubarrayV1(int[] nums) {
		int maxLen = 0;
		boolean all1 = true;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				all1 = false;
				int curLen = getLen(nums, i);
				maxLen = Math.max(maxLen, curLen);
			}
		}
		return all1 ? nums.length - 1 : maxLen;
	}

	private int getLen(int[] nums, int pos) {
		int len = 0;
		for (int i = pos - 1; i >= 0; i--) {
			if (nums[i] == 1) {
				len++;
			} else {
				break;
			}
		}
		for (int i = pos + 1; i < nums.length; i++) {
			if (nums[i] == 1) {
				len++;
			} else {
				break;
			}
		}
		return len;
	}

}
