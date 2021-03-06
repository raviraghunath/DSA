//You are given an array arr of N integers. For each index i, you are required to determine the number of contiguous subarrays that fulfills the following conditions:
//The value at index i must be the maximum element in the contiguous subarrays, and
//These contiguous subarrays must either start from or end on index i.
//Signature
//int[] countSubarrays(int[] arr)
//Input
//Array arr is a non-empty list of unique integers that range between 1 to 1,000,000,000
//Size N is between 1 and 1,000,000
//Output
//An array where each index i contains an integer denoting the maximum number of contiguous subarrays of arr[i]
//Example:
//arr = [3, 4, 1, 6, 2]
//output = [1, 3, 1, 5, 1]
//Explanation:
//For index 0 - [3] is the only contiguous subarray that starts (or ends) with 3, and the maximum value in this subarray is 3.
//For index 1 - [4], [3, 4], [4, 1]
//For index 2 - [1]
//For index 3 - [6], [6, 2], [1, 6], [4, 1, 6], [3, 4, 1, 6]
//For index 4 - [2]
//So, the answer for the above input is [1, 3, 1, 5, 1]

package ArraysNStrings;

public class ContiguousSubarrays {

	public static void main(String[] args) {
		ContiguousSubarrays contiguousSubarrays = new ContiguousSubarrays();
		int res[] = contiguousSubarrays.countSubarrays(new int[] { 3, 4, 1, 6, 2 });
		Solution.printArr(res);
	}

	int[] countSubarrays(int[] arr) {
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = 1 + helper(arr, i);
		}
		return res;
	}

	private int helper(int arr[], int pos) {
		int ways = 0;
		for (int i = pos + 1; i < arr.length; i++) {
			if (arr[i] < arr[pos]) {
				ways++;
			} else {
				break;
			}
		}
		for (int i = pos - 1; i >= 0; i--) {
			if (arr[i] < arr[pos]) {
				ways++;
			} else {
				break;
			}
		}
		return ways;
	}
}
