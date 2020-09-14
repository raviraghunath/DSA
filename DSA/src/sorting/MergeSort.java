package sorting;

public class MergeSort {

	public static void main(String[] args) {
		MergeSort mergeSort = new MergeSort();
//		int array[] = new int[] { 3, 5, 1, 2, 4 };
		int array[] = new int[] { 3, 5, 7, 8, 4, 2, 1, 9, 6 };
		Utils.printArr(array);
		mergeSort.doMergeSort(array, 0, array.length - 1);
		Utils.printArr(array);
	}

	private void doMergeSort(int arr[], int st, int ed) {
		int len = ed - st + 1;
		if (arr == null || len == 1) {
			return;
		}
		if (len == 2) {
			if (arr[st] > arr[st + 1]) {
				int t = arr[st];
				arr[st] = arr[st + 1];
				arr[st + 1] = t;
			}
			return;
		}
		int mid = st + ((ed - st) / 2);
		doMergeSort(arr, st, mid);
		doMergeSort(arr, mid + 1, ed);
		merge(arr, st, mid, mid + 1, ed);
	}

	private void merge(int[] arr, int st1, int ed1, int st2, int ed2) {
		int i = st1;
		int j = st2;
		int len1 = ed1 - st1 + 1;
		int len2 = ed2 - st2 + 1;
		int tArr[] = new int[len1 + len2];
		int k = 0;
		while (i <= ed1 && j <= ed2) {
			if (arr[i] < arr[j]) {
				tArr[k] = arr[i];
				i++;
				k++;
			} else if (arr[i] > arr[j]) {
				tArr[k] = arr[j];
				j++;
				k++;
			} else {
				tArr[k] = arr[i];
				i++;
				j++;
			}
		}
		while (i <= ed1) {
			tArr[k++] = arr[i++];
		}
		while (j <= ed2) {
			tArr[k++] = arr[j++];
		}
		i = st1;
		k = 0;
		while (i <= ed1) {
			arr[i] = tArr[k];
			i++;
			k++;
		}
		j = st2;
		while (j <= ed2) {
			arr[j] = tArr[k];
			j++;
			k++;
		}
	}

}
