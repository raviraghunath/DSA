package ArraysNStrings;

public class MaxSquare2DMatrix {

	public static void main(String[] args) {
		MaxSquare2DMatrix maxSquare2DMatrix = new MaxSquare2DMatrix();
		System.out.println(maxSquare2DMatrix.maximalSquare(new char[][] { { '1', '0', '1', '0', '0' },
				{ '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' }, { '1', '0', '0', '1', '0' } }));
	}

	public int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return 0;
		}
		int[][] subMatrix = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix[0].length; i++) {
			subMatrix[0][i] = (matrix[0][i] == '0' ? 0 : 1);
		}
		for (int i = 0; i < matrix.length; i++) {
			subMatrix[i][0] = (matrix[i][0] == '0' ? 0 : 1);
		}
		for (int i = 1; i < subMatrix.length; i++) {
			for (int j = 1; j < subMatrix[i].length; j++) {
				if (matrix[i][j] != '0') {
					subMatrix[i][j] = Math.min(subMatrix[i - 1][j - 1],
							Math.min(subMatrix[i][j - 1], subMatrix[i - 1][j])) + 1;
				}
			}
		}
		int maxLen = 0;
		for (int i = 0; i < subMatrix.length; i++) {
			for (int j = 0; j < subMatrix[i].length; j++) {
				if (subMatrix[i][j] > maxLen) {
					maxLen = subMatrix[i][j];
				}
			}
		}
		return maxLen*maxLen;
	}
}
