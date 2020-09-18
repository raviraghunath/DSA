package ArraysNStrings;

import java.util.HashMap;

public class SubArrayWithGvnSum {

	public static void main(String[] args) {
		SubArrayWithGvnSum arrayWithSum = new SubArrayWithGvnSum();
		// arrayWithSum.getSubArrayWithSum(new int[] { 1, 4, 20, 3, 10, 5 }, 33);
		arrayWithSum.getSubArrayWithSum(new int[] { 1, 4, 20, 3, 10 }, 28);
		System.out.println("--");
		arrayWithSum.getSubArrayWithSumWithNegativeEle(new int[] { 10, 2, -2, -20, 10 }, -10);
		System.out.println("--");
		subArraySum(new int[] { 10, 2, -2, -20, 10 }, 5, -10);
		System.out.println("--");
		subArraySumV1(new int[] { 10, 2, -2, -20, 10 }, 5, -22); //10 12 10 
	}

	// Without negative number array
	private int getSubArrayWithSum(int[] nums, int sum) {
		int start = 0;
		int cuSum = nums[start];
		for (int i = 1; i < nums.length; i++) {
			while (cuSum + nums[i] > sum && start < i) {
				cuSum = cuSum - nums[start];
				start++;
			}
			if (cuSum + nums[i] == sum) {
				System.out.println(start + "-" + i);
				return start;
			}
			cuSum += nums[i];
		}
		return -1;
	}

	// With negative number array , There is one issue here.. Need to find it
	private int getSubArrayWithSumWithNegativeEle(int[] nums, int sum) {
		int minEle = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			minEle = Math.min(minEle, nums[i]);
		}

		int start = 0;
		int cuSum = nums[start] + Math.abs(minEle);
		for (int i = 1; i <= nums.length; i++) {
			System.out.println((cuSum - (i - start) * Math.abs(minEle)));
			while ((cuSum - (i - start) * Math.abs(minEle) > sum) && start < i - 1) {
				cuSum = cuSum - nums[start] - Math.abs(minEle);
				start++;
			}
			if (cuSum - (i - start) * Math.abs(minEle) == sum) {
				System.out.println(start + "-" + (i - 1));
				return start;
			}
			if (i < nums.length) {
				cuSum = cuSum + nums[i] + Math.abs(minEle);
			}
		}
		return -1;

	}

	static void subArraySum(int arr[], int n, int sum) {
		int minEle = Integer.MAX_VALUE;

		// Find minimum element in the array
		for (int i = 0; i < n; i++)
			minEle = Math.min(arr[i], minEle);

		// Initialize curr_sum as value of
		// first element and starting point as 0
		int curr_sum = arr[0] + Math.abs(minEle);
		int start = 0, i;

		// Starting window length will be 1,
		// For generating new target sum,
		// add abs(minEle) to sum only 1 time
		int targetSum = sum;

		// Add elements one by one to curr_sum
		// and if the curr_sum exceeds the
		// updated sum, then remove starting element
		for (i = 1; i <= n; i++) {

			// If curr_sum exceeds the sum,
			// then remove the starting elements
			while (curr_sum - (i - start) * Math.abs(minEle) > targetSum && start < i - 1) {
				curr_sum = curr_sum - arr[start] - Math.abs(minEle);
				start++;
			}

			// If curr_sum becomes equal to sum,
			// then return true
			if (curr_sum - (i - start) * Math.abs(minEle) == targetSum) {
				System.out.println("Sum found between indexes " + start + " and " + (i - 1));
				return;
			}

			// Add this element to curr_sum
			if (i < n) {
				curr_sum = curr_sum + arr[i] + Math.abs(minEle);
			}
		}

		// If we reach here, then no subarray
		System.out.println("No subarray found");
	}

	public static void subArraySumV1(int[] arr, int n, int sum) {
		// cur_sum to keep track of cummulative sum till that point
		int cur_sum = 0;
		int start = 0;
		int end = -1;
		HashMap<Integer, Integer> hashMap = new HashMap<>();

		for (int i = 0; i < n; i++) {
			cur_sum = cur_sum + arr[i];
			// check whether cur_sum - sum = 0, if 0 it means
			// the sub array is starting from index 0- so stop
			if (cur_sum - sum == 0) {
				start = 0;
				end = i;
				break;
			}
			// if hashMap already has the value, means we already
			// have subarray with the sum - so stop
			if (hashMap.containsKey(cur_sum - sum)) {
				start = hashMap.get(cur_sum - sum) + 1;
				end = i;
				break;
			}
			// if value is not present then add to hashmap
			hashMap.put(cur_sum, i);

		}
		// if end is -1 : means we have reached end without the sum
		if (end == -1) {
			System.out.println("No subarray with given sum exists");
		} else {
			System.out.println("Sum found between indexes " + start + " to " + end);
		}

	}
	
	

}
