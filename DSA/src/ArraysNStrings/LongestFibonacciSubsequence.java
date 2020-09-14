//https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/
package ArraysNStrings;

import java.util.HashSet;
import java.util.Set;

public class LongestFibonacciSubsequence {

	public static void main(String[] args) {
		LongestFibonacciSubsequence longestFibonacciSubsequence = new LongestFibonacciSubsequence();
		System.out.println(longestFibonacciSubsequence.lenLongestFibSubseq(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, }));
	}

	public int lenLongestFibSubseq(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		} 
		if (A.length == 1) {
			return A[0];
		}
		Set<Integer> set = new HashSet<Integer>();
		for (int i : A) {
			set.add(i);
		}
		int max = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = i + 1; j < A.length; j++) {
				int ele1 = A[i];
				int ele2 = A[j];
				int currMax = 0;
				while (set.contains(ele1 + ele2)) {
					int t = ele1;
					ele1 = ele2;
					ele2 = t + ele2;
					currMax = currMax == 0 ? 3 : currMax+1;
				}
				if (max < currMax)
					max = currMax;
			}
		}
		return max;
	}
}
