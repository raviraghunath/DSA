package sorting;

public class InsertionSort {

	public static void main(String[] args) {
		InsertionSort insertionSort = new InsertionSort();
		int array[] = new int[] { 3, 5, 7, 8, 4, 2, 1, 9, 6 };
		Utils.printArr(array);
		insertionSort.doInsertionSort(array);
		Utils.printArr(array);

	}

	private void doInsertionSort(int array[]) {
		int i = 0;
		while (i < array.length - 1) {
			if (array[i] > array[i + 1]) {
				int currEle = array[i + 1];
				int j = i;
				while (j >= 0 && currEle < array[j]) {
					if (currEle < array[j]) {
						array[j + 1] = array[j];
						j--;
					}
				}
				array[j + 1] = currEle;
			}
			i++;

		}
	}
}
