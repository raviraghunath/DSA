//https://leetcode.com/problems/maximum-width-ramp/
package ArraysNStrings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.TreeMap;

public class MaxWidthRamp {

	static class Node implements Comparable<Node> {
		int val;
		int idx;

		Node(int val, int idx) {
			this.val = val;
			this.idx = idx;
		}

		@Override
		public int compareTo(Node o) {
			Integer i1 = new Integer(val);
			Integer i2 = new Integer(o.val);
			return i1.compareTo(i2);
		}
	}

	public static void main(String[] args) {
		MaxWidthRamp maxWidthRamp = new MaxWidthRamp();
		// System.out.println(maxWidthRamp.maxWidthRamp(new int[] { 9, 8, 1, 0, 1, 9, 4,
		// 0, 4, 1 }));
		System.out.println(maxWidthRamp.maxWidthRampV1(new int[] { 9, 8, 1, 0, 1, 9, 4,0, 4, 1 }));
	}

	// Not optimal, But Still its good read
	public int maxWidthRampV1(int[] A) {
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();
		int dist = 0;
		for (int i = 0; i < A.length; i++) {
			if (stack1.isEmpty() || A[i] < A[stack1.peek()]) {
				stack1.push(i);
			} else {
				stack2.removeAllElements();
				while (!stack1.isEmpty() && A[i] >= A[stack1.peek()]) {
					int ind = stack1.pop();
					stack2.push(ind);
					dist = Math.max(dist, i - ind);
				}
				while (!stack2.isEmpty()) {
					stack1.add(stack2.pop());
				}
			}
		}
		return dist;
	}

	public int maxWidthRamp(int[] A) {
		TreeMap<Integer, Integer> y = new TreeMap<Integer, Integer>();
		List<Node> list = new ArrayList<Node>();
		for (int i = 0; i < A.length; i++) {
			list.add(new Node(A[i], i));
		}
		Collections.sort(list);

		int slwPtr = 0;
		int res = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).idx >= list.get(slwPtr).idx) {
				res = Math.max(res, list.get(i).idx - list.get(slwPtr).idx);
			} else {
				slwPtr = i;
			}
		}
		return res;
	}

}
