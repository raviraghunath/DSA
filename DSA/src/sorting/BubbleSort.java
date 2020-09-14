package sorting;

public class BubbleSort {

	public static void main(String[] args) {
		BubbleSort bubbleSort = new BubbleSort();
		int array[] = new int[] { 4, 2, 1, 5, 3 };
		Utils.printArr(array);
		bubbleSort.doBubbleSort(array);
		Utils.printArr(array);
	}

	private void doBubbleSort(int arr[]) {

		boolean sorted = false;

		while (!sorted) {
			sorted = true;
			for (int index = 0; index < arr.length - 1; index++) {
				if (arr[index] > arr[index + 1]) {
					int temp = arr[index];
					arr[index] = arr[index + 1];
					arr[index + 1] = temp;
					sorted = false;
				}
			}
		}
	}
}
