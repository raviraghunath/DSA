package ArraysNStrings;

public class LargestRectangleInMatrix {

	public static void main(String[] args) {
		LargestRectangleInMatrix largestRectangleInMatrix = new LargestRectangleInMatrix();
//		int A[][] = { { 0, 1, 1, 0 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 0, 0 }, };
		int A[][] = { { 0, 1, 1 }, { 1, 1, 1 }, { 0, 1, 1 }, };
		largestRectangleInMatrix.printBigestRectInMatric(A);

	}

	private void printBigestRectInMatric(int[][] arr) {
		int[][] arr1 = new int[arr.length][arr.length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (i == 0 || j == 0) {
					arr1[i][j] = arr[i][j];
				} else {
					if (arr[i][j] == 1) {
						if (arr1[i - 1][j] >= 1 && arr1[i][j - 1] >= 1 && arr1[i - 1][j - 1] >= 1) {
							arr1[i][j] = Math.max(arr1[i - 1][j], Math.max(arr1[i][j - 1], arr1[i - 1][j - 1])) + 1;
						} else {
							arr1[i][j] = arr[i][j];
						}
					} else {
						arr1[i][j] = arr[i][j];
					}
				}

			}
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr1[i][j] + "  ");
			}
			System.out.println();
		}

	}
}
