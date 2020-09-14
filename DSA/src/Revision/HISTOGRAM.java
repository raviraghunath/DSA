package Revision;

import java.util.Stack;

public class HISTOGRAM {

	public static void main(String[] args) {
		HISTOGRAM histogram = new HISTOGRAM();
		System.out.println(histogram.getMaxArea(new int[] {  5,  3,4, 2 }));
	}

	private int getMaxArea(int arr[]) {
		Stack<Integer> stack = new Stack<Integer>();
		int maxArea = 0;
		for (int i = 0; i < arr.length; i++) {
			if (stack.isEmpty() || arr[stack.peek()] <= arr[i]) {
				stack.push(i);
			} else {
				while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
					int j = stack.pop();
					int currArea = arr[j] * (stack.isEmpty() ? i : i - stack.peek() - 1);
					maxArea = Math.max(maxArea, currArea);
				}
				stack.push(i);
			}
		}
		while (!stack.isEmpty()) {
			int j = stack.pop();
			int currArea = arr[j] * (stack.isEmpty() ? arr.length : arr.length - stack.peek() - 1);
			maxArea = Math.max(maxArea, currArea);
		}
		return maxArea;
	}

}
