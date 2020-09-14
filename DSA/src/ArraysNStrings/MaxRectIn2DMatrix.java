package ArraysNStrings;

public class MaxRectIn2DMatrix {

	public static void main(String[] args) {
		MaxRectIn2DMatrix maxRectIn2DMatrix = new MaxRectIn2DMatrix();
		System.out.println(maxRectIn2DMatrix.maximalRectangle(new char[][] { { '0', '1' }, { '1', '0' } }));
//		System.out.println(maxRectIn2DMatrix.maximalRectangle(new char[][] { { '1', '0', '1', '0', '0' },
//			{ '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' }, { '1', '0', '0', '1', '0' } }));

	}

	private int maximalRectangleInt(int[][] matrix) {
		int[][] subMatrix = new int[matrix.length][matrix[0].length];

		for (int i = 0; i < matrix.length; i++) {
			subMatrix[0][i] = matrix[0][i];
		}

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				subMatrix[i][j] = subMatrix[i - 1][j] + matrix[i][j];
			}
		}

		LergestRectInHallogram hallogram = new LergestRectInHallogram();
		int maxLen = 0;
		for (int i = 0; i < subMatrix.length; i++) {
			int currLen = hallogram.largestRectangleAreaV1(subMatrix[i]);
			if (currLen > maxLen) {
				maxLen = currLen;
			}
		}
		return maxLen;

	}

	private int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return 0;
		}
		int[][] subMatrix = new int[matrix.length][matrix[0].length];

		for (int i = 0; i < matrix[0].length; i++) {
			subMatrix[0][i] = (matrix[0][i] == '0' ? 0 : 1);
		}

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] != '0') {
					subMatrix[i][j] = subMatrix[i - 1][j] + (matrix[i][j] == '0' ? 0 : 1);
				}
			}
		}

		LergestRectInHallogram hallogram = new LergestRectInHallogram();
		int maxLen = 0;
		for (int i = 0; i < subMatrix.length; i++) {
			int currLen = hallogram.largestRectangleArea(subMatrix[i]);
			if (currLen > maxLen) {
				maxLen = currLen;
			}
		}
		return maxLen;

	}
}
