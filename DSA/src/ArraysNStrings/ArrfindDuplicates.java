package ArraysNStrings;
// https://www.geeksforgeeks.org/find-duplicates-in-on-time-and-constant-extra-space/amp/
// Given an array of n elements which contains elements from 1 to n, with any of these numbers appearing any number of times. Find these repeating numbers in O(n) and using only constant memory space
public class ArrfindDuplicates {

	public static void main(String[] args) {
		ArrfindDuplicates arrfindDuplicates = new ArrfindDuplicates();
		int[] arr = new int[] { 1, 2, 3, 1, 3, 6, 6 };
		Solution.printArr(arr);
		// arrfindDuplicates.printDupCnt(new int[] { 1, 2, 3, 1, 3, 6, 6 });
		arrfindDuplicates.printDupCntV1(arr);
	}

	private void printDupCnt(int arr[]) {
		if (arr == null || arr.length == 0) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			arr[arr[i] - 1] = arr[arr[i] - 1] + arr.length;
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > (i + 1) + arr.length) {
				System.out.println((i + 1) + " duplicate");
			}
		}
	}

	private void printDupCntV1(int arr[]) {
		if (arr == null || arr.length == 0) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[Math.abs(arr[i] - 1)] > 0) {
				arr[arr[i] - 1] = -Math.abs(arr[arr[i] - 1]);
			} else {
				System.out.println("Duplicate : " + Math.abs(arr[Math.abs(arr[i] - 1)]));
			}
		}
		Solution.printArr(arr);
	}
	
	

}
