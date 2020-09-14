package ArraysNStrings;
//https://leetcode.com/problems/house-robber/submissions/

public class Solution {

	public static void main(String args[]) {
		Solution solution = new Solution();
		System.out.println(solution.test1(new int[] { 0, 1, 2 }));
	}

	public int climbStairs(int n) {
		if (n <= 0) {
			return 0;
		} else if (n == 1) {
			return 1;

		} else if (n == 2) {
			return 2;

		}
		int arr[] = new int[n];
		arr[0] = 1;
		arr[1] = 2;
		for (int i = 2; i < n; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}
		printArr(arr);
		return arr[n - 1];
	}

	private static void doAnagram(String left, String val) {
		for (int i = 1; i <= val.length(); i++) {
			String letter = val.substring(i - 1, i);
			String pre = val.substring(0, i - 1);
			String rem = val.substring(i);
			if ((rem + pre).isEmpty())
				System.out.println(left + letter + pre + rem);
			doAnagram(left + letter, pre + rem);
		}
	}

	public int rob(int[] nums) {
		if (nums.length == 0) {
			return 0;
		} else if (nums.length == 1) {
			return nums[0];
		} else if (nums.length == 2) {
			return nums[0] < nums[1] ? nums[1] : nums[0];
		} else {
			int ptr[] = new int[3];
			ptr[0] = nums[0];
			ptr[1] = nums[1];
			ptr[2] = nums[0] + nums[2];
			int curr = 0;
			for (int i = 3; i < nums.length; i++) {
				curr = (ptr[1] > ptr[0]) ? ptr[1] + nums[i] : ptr[0] + nums[i];
				ptr[0] = ptr[1];
				ptr[1] = ptr[2];
				ptr[2] = curr;
			}
			return ptr[1] < ptr[2] ? ptr[2] : ptr[1];
		}
	}

	public static void printArr(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	private int test1(int arr[]) {
		if (arr.length == 0) {
			return -1;
		}
		int majorityNo = arr[0];
		int count = 0;
		for (int item : arr) {
			if (count == 0) {
				majorityNo = item;
			}
			count += (item == majorityNo ? 1 : -1);
		}

		return majorityNo;
	}

}