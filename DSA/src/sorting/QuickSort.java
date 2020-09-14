package sorting;

public class QuickSort {

	public static void main(String[] args) {
		QuickSort quickSort = new QuickSort();
		int array[] = new int[] { 3, 5, 7, 8, 4, 2, 1, 9, 6 };
		Utils.printArr(array);
		quickSort.doQuickSort(array, 0, array.length - 1);
		Utils.printArr(array);
	}

	private void doQuickSort(int arr[], int st, int ed) {
		int len = ed - st + 1;
		if (arr == null || len <= 1) {
			return;
		}
		int i = partition(arr, st, ed);
		doQuickSort(arr, st, i - 1); 
		doQuickSort(arr, i + 1, ed);
		
	}

	private int partition(int arr[], int begin, int end) {
		int pivot = end;
		int pivotEle = arr[pivot];
		int i = begin;

		for (int index = begin; index <= end; index++) {
			if (arr[index] < pivotEle) {
				int temp = arr[index];
				arr[index] = arr[i];
				arr[i] = temp;
				i++;
			}
		}
		int temp = arr[pivot];
		arr[pivot] = arr[i];
		arr[i] = temp;
		return i;
	}

}
