package ArraysNStrings;

public class ShiftZeros {

	public static void main(String[] args) {
		ShiftZeros shiftZeros = new ShiftZeros();
		int arr[] = new int[] { 0, 1, 2, 0, 3, 0 };
		Solution.printArr(arr);
		shiftZeros.shiftZeros(arr);
		Solution.printArr(arr);
	}

	private void shiftZeros(int arr[]) {
		int zeroStIndex = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0 && zeroStIndex == -1) {
				zeroStIndex = i;
			}
			if (arr[i] != 0) {
				if (zeroStIndex != -1) {
					swap(arr, i, zeroStIndex);
					zeroStIndex = i;
				}
			}
		}
	}

	private void swap(int arr[], int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

}
