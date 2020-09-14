//https://leetcode.com/problems/maximum-length-of-repeated-subarray/
package ArraysNStrings;

public class MaxLenRepeatedSubArray {

	public static void main(String[] args) {
//		int[] A = new int[] { 1, 2, 3, 2, 1 };
//		int[] B = new int[] { 3, 2, 1, 4, 7 };
		int[] A = new int[] { 0, 0, 0, 0, 0, 0, 1, 0, 0, 0 };
		int[] B = new int[] { 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 };
		MaxLenRepeatedSubArray maxLenRepeatedSubArray = new MaxLenRepeatedSubArray();
		System.out.println(maxLenRepeatedSubArray.findLength_missunderstood(A, B));
		System.out.println(maxLenRepeatedSubArray.findLengthV1(A, B));
		System.out.println(maxLenRepeatedSubArray.findLength(A, B));
		System.out.println(maxLenRepeatedSubArray.findLengthV2(A, B));
	}

	public int findLength(int[] A, int[] B) {
		int tab[][] = new int[A.length][B.length];
		int max = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				if (A[i] == B[j]) {
					if (i == 0 || j == 0) {
						tab[i][j] = 1;
					} else {
						tab[i][j] = 1 + tab[i - 1][j - 1];
					}
					max = Math.max(max, tab[i][j]);
				}
			}
		}
		return max;
	}

	public int findLengthV2(int[] A, int[] B) {
		int max = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				int k = 0;
				while (i + k < A.length && j + k < B.length && A[i + k] == B[j + k]) {
					k++;
				}
				max = Math.max(max, k);
			}
		}
		return max;
	}

	public int findLengthV1(int[] A, int[] B) {
		return findLengthV1(A, B, 0, 0, false, 0);
	}

	public int findLengthV1(int[] A, int[] B, int pos1, int pos2, boolean prevEq, int currVal) {
		if (pos1 == A.length || pos2 == B.length) {
			return currVal;
		} else {
			int res = Integer.MIN_VALUE;
			if (A[pos1] == B[pos2]) {
				if (prevEq) {
					res = Math.max(res, findLengthV1(A, B, pos1 + 1, pos2 + 1, true, currVal + 1));
				} else {
					res = Math.max(res, findLengthV1(A, B, pos1 + 1, pos2 + 1, true, 1));
				}
			}
			res = Math.max(res, findLengthV1(A, B, pos1, pos2 + 1, false, currVal));
			res = Math.max(res, findLengthV1(A, B, pos1 + 1, pos2, false, currVal));
			return res;
		}
	}

	// Pls focus here
	// This is wrong soln, I undertsood it wrongly... It will return max continous
	// or non-continous sub array;
	public int findLength_missunderstood(int[] A, int[] B) {
		return findLength_missunderstood(A, B, 0, 0);
	}

	public int findLength_missunderstood(int[] A, int[] B, int pos1, int pos2) {
		if (pos1 == A.length || pos2 == B.length) {
			return 0;
		} else {
			if (A[pos1] == B[pos2]) {
				return 1 + findLength_missunderstood(A, B, pos1 + 1, pos2 + 1);
			} else {
				return Math.max(findLength_missunderstood(A, B, pos1, pos2 + 1),
						findLength_missunderstood(A, B, pos1 + 1, pos2));
			}
		}
	}

}
