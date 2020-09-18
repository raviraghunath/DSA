package sorting;

import ArraysNStrings.Solution;

public class PancakeSorting {

	public static void main(String[] args) {
		PancakeSorting pancakeSorting = new PancakeSorting();
		int[] arr = new int[] { 4, 2, 7, 4, 9, 1, 23, 8 };
		pancakeSorting.doPancakeSort(arr);
		Solution.printArr(arr);
	}

	private void doPancakeSort(int arr[]) {
		for (int l = arr.length - 1; l > 0; l--) {
			int index = findMaxIndex(arr, l);

			if (index != l) {
				flip(arr, index);
				flip(arr, l);
			}
		}
	}

	private void flip(int arr[], int n) {
		int start = 0;
		while (start < n) {
			int t = arr[start];
			arr[start] = arr[n];
			arr[n] = t;
			n--;
			start++;
		}
	}

	private int findMaxIndex(int[] arr, int n) {
		int max = 0;
		for (int i = 0; i <= n; i++) {
			if (arr[max] < arr[i]) {
				max = i;
			}
		}
		return max;
	}

}
