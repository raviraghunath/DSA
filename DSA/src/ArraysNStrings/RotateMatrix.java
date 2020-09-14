//https://www.youtube.com/watch?v=JGZ04Bi-sOc&feature=youtu.be&fbclid=IwAR2LOcLygxVkzWj9A3TUpWArx2Kp4ff1Nu_8iKy7ACDRKY03AGNih6hFwUI
package ArraysNStrings;

public class RotateMatrix {
	public static void main(String[] args) { 
		RotateMatrix rotateMatrix = new RotateMatrix();
		int[][] matrix = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		print(matrix);
		rotateMatrix.rotateMatrixBy90InPlace(matrix);
		System.out.println();
		print(matrix);
		System.out.println();
		matrix = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		print(rotateMatrix.rotateMatrixBy90(matrix));
	}

	private void rotateMatrixBy90InPlace(int[][] matrix) {
		//  transpose
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i; j < matrix[i].length; j++) {
				int t = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = t;
			}
		}
		
		// reverse
		for (int i = 0; i < matrix.length ; i++) {
			for (int j = 0; j < matrix.length/2; j++) {
				int t = matrix[i][j];
				matrix[i][j] = matrix[i][matrix.length - 1 - j];
				matrix[i][matrix.length - 1 - j] = t;
			}
		}
	}

	private int[][] rotateMatrixBy90(int[][] matrix) {
		int[][] resMatrix = new int[matrix.length][matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				resMatrix[j][matrix.length - 1 - i] = matrix[i][j];
			}
		}
		return resMatrix;
	}

	private static void print(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
