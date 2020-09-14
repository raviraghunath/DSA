package ArraysNStrings;

public class LargestSquareInMatrix {

	public static void main(String[] args) {
		LargestSquareInMatrix bigestSquareInMatrix = new LargestSquareInMatrix();
		int M[][] = { { 0, 1, 1, 0, 1 }, { 1, 1, 0, 1, 0 }, { 0, 1, 1, 1, 0 }, { 1, 1, 1, 1, 0 }, { 1, 1, 1, 1, 1 },
				{ 0, 0, 0, 0, 0 } };
		bigestSquareInMatrix.printBigestSquareInMatric(M);

	}

	private void printBigestSquareInMatric(int[][] arr) {
		int[][] arr1 = new int[arr.length][arr.length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (i == 0 || j == 0) {
					arr1[i][j] = arr[i][j];
				} else {
					if (arr[i][j] == 1) {
						if (arr1[i - 1][j] == 1 && arr1[i][j - 1] == 1 && arr1[i - 1][j - 1] >= 1) {
							arr1[i][j] = arr1[i - 1][j - 1] + 1;
						} else {
							arr1[i][j] = arr[i][j];
						}
					} else {
						arr1[i][j] = arr[i][j];
					}
				}
			}
		}
		int max = 0;
		int maxI = 0, maxJ = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr1[i][j] > max) {
					max = arr1[i][j];
					maxI = i;
					maxJ = j;
				}
			}
		}

		System.out.println(maxI + " " + maxJ);

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr1[i][j] + "  ");
			}
			System.out.println();
		}
	}

}
