package sorting;

public class SelectionSort {

	public static void main(String[] args) {
		SelectionSort selectionSort = new SelectionSort();
		int array[] = new int[] { 3, 5, 1, 2, 4 };
		Utils.printArr(array);
		selectionSort.doSelectionSort(array);
		Utils.printArr(array);

	}

	private void doSelectionSort(int array[]) { 
		int sorterArrayTail = 0;
		for (int i = 0; i < array.length; i++) {
			int index1 = minIndex(array, i);
			int t = array[index1];
			array[index1] = array[sorterArrayTail];
			array[sorterArrayTail] = t;
			sorterArrayTail++;
		}
	}

	private int minIndex(int arr[], int start) {
		int minIndex = -1;
		int min = Integer.MAX_VALUE;
		for (int i = start; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
				minIndex = i;
			}
		}
		return minIndex;
	}
}
