package ArraysNStrings;

public class PeekNValley {

	public static void main(String[] args) {
		PeekNValley peekNValley = new PeekNValley();
		peekNValley.doPeekNValley(new int[] { 1, 2, 3, 4, 5 });
		peekNValley.doPeekNValley(new int[] { 5, 4, 3, 2, 1 });
	}

	private void doPeekNValley(int arr[]) {
		Solution.printArr(arr);
		int i1 = 0;
		int i2 = 1;
		for (int i = 2; i < arr.length; i++) {
			boolean stMin = arr[i1] < arr[i2];
			if (stMin) {
				if (arr[i] > arr[i2]) {
					int t = arr[i];
					arr[i] = arr[i2];
					arr[i2] = t;
				}
			} else {
				if (arr[i] < arr[i2]) {
					int t = arr[i];
					arr[i] = arr[i2];
					arr[i2] = t;
				}
			}
			i1 = i2;
			i2 = i;
		}
		Solution.printArr(arr);
	}

}
