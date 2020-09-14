//https://leetcode.com/problems/binary-subarrays-with-sum/
package ArraysNStrings;

public class SubArrayWithSum {

	public static void main(String[] args) {
		SubArrayWithSum subArrayWithSum = new SubArrayWithSum();
		System.out.println(subArrayWithSum.numSubarraysWithSum(new int[] { 1, 0, 1, 0, 1 }, 2));

	}

	public int numSubarraysWithSum(int[] A, int S) {
		int res = 0;
		for (int i = 0; i < A.length; i++) {
			int cnt = 0;
			for (int j = i; j < A.length; j++) {
				cnt += A[j];
				if (cnt == S) {
					res++;
				} else if (cnt > S) {
					break;
				}
			}
		}
		return res;
	}

//	public int numSubarraysWithSum(int[] A, int S) {
//		int st = 0;
//		int ed = 0;
//		int cnt = 0;
//		int res = 0;
//		while (ed < A.length) {
//			cnt += A[ed];
//			if (cnt == S) {
//				res++;
//			}
//			if (cnt > S) {
//				while (st <= ed) {
//					cnt -= A[st];
//					if (cnt == S) {
//						res++;
//					}
//					st++;
//				}
//			} else {
//				ed++;
//			}
//		}
//		return res;
//	}

}
