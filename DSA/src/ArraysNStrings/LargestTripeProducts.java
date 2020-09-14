//You're given a list of n integers arr[0..(n-1)]. You must compute a list output[0..(n-1)] such that, for each index i (between 0 and n-1, inclusive), output[i] is equal to the product of the three largest elements out of arr[0..i] (or equal to -1 if i < 2, as arr[0..i] then includes fewer than three elements).
//Note that the three largest elements used to form any product may have the same values as one another, but they must be at different indices in arr.
//Signature
//int[] findMaxProduct(int[] arr)
//Input
//n is in the range [1, 100,000].
//Each value arr[i] is in the range [1, 1,000].
//Output
//Return a list of n integers output[0..(n-1)], as described above.
package ArraysNStrings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class LargestTripeProducts {

	public static void main(String[] args) {
		LargestTripeProducts largestTripeProducts = new LargestTripeProducts();
		Solution.printArr(largestTripeProducts.findMaxProduct(new int[] { 2, 1, 2, 1, 2}));
	}

	private int[] findMaxProduct(int[] arr) {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			priorityQueue.add(arr[i]);
			if (priorityQueue.size() < 3) {
				res[i] = -1;
			} else {
				int cnt = 0;
				int pdt = 1;
				List<Integer> list = new ArrayList<Integer>(3);
				while (cnt < 3) {
					int t = priorityQueue.poll();
					pdt *= t;
					list.add(t);
					cnt++;
				}
				priorityQueue.addAll(list);
				res[i] = pdt;
			}

		}
		return res;
	}

}
