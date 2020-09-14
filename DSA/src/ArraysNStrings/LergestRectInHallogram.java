package ArraysNStrings;

import java.util.Stack;

//https://leetcode.com/problems/largest-rectangle-in-histogram/#:~:text=Largest%20Rectangle%20in%20Histogram%20%2D%20LeetCode&text=Given%20n%20non%2Dnegative%20integers,6%2C2%2C3%5D%20.
public class LergestRectInHallogram {

	public static void main(String[] args) {
		LergestRectInHallogram hallogram = new LergestRectInHallogram();
		int arr[] = new int[] { 5, 3, 4, 2 };
		int cst = hallogram.largestRectangleAreaV1(arr);
		System.out.println(cst);
		cst = hallogram.largestRectangleArea(arr);
		System.out.println(cst);
		cst = hallogram.largestRectangleAreaV3(arr);
		System.out.println(cst);
	}

	public int largestRectangleArea(int[] heights) {
		int i = 0;
		int maxLength = 0;
		int n = heights.length;
		Stack<Integer> stack = new Stack<Integer>();
		while (i < n) {
			if (stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
				stack.push(i);
				i++;
			} else {
				int j = stack.pop();
				// Focus
				int curLen = heights[j] * (stack.isEmpty() ? i : i - stack.peek() - 1);
				if (maxLength < curLen) {
					maxLength = curLen;
				}
			}
		}
		while (!stack.isEmpty()) {
			int j = stack.pop();
			int curLen = heights[j] * (stack.isEmpty() ? i : i - stack.peek() - 1);
			if (maxLength < curLen) {
				maxLength = curLen;
			}
		}
		return maxLength;
	}

	public int largestRectangleAreaV1(int[] heights) {
		int a[] = heights;
		if (a == null || a.length == 0) {
			return 0;
		}

		int st = 0, ed = 0, maxCst = 0;

		for (int i = 0; i < a.length; i++) {
			if (i < 0 && a[i] < a[i - 1]) {
			} else {
				st = i;
				ed = i;
			}
			ed = i;
			while (st >= 0) {
				if (a[i] <= a[st]) {
					st--;
				} else {
					break;
				}
			}
			st++;
			while (ed < a.length) {
				if (a[i] <= a[ed]) {
					ed++;
				} else {
					break;
				}
			}
			ed--;

			int cst = (ed - st + 1) * a[i];
			maxCst = maxCst < cst ? cst : maxCst;
		}
		return maxCst;
	}

	// wrong ans.. It is picking next min and not considering prev firt min
	public int largestRectangleAreaV2(int[] heights) { // 5, 3, 4, 2
		int max = 0;
		outer: for (int i = 0; i < heights.length; i++) {
			for (int j = i; j < heights.length; j++) {
				if (heights[j] >= heights[i]) {

				} else {
					int curr = heights[i] * (j - i);
					max = Math.max(max, curr);
					continue outer;
				}
			}
			int curr = heights[i] * (heights.length - i);
			max = Math.max(max, curr);
		}
		return max;
	}

	public int largestRectangleAreaV3(int[] heights) { // 5, 3, 4, 2
		Stack<Integer> stack = new Stack<Integer>();
		int i = 0;
		int mxx = 0;
		while (i < heights.length) {
			if (stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
				stack.push(i);
				i++;
			} else {
				int j = stack.pop();
				int curr = heights[j] * (stack.isEmpty() ? i : (i - stack.peek() - 1));
				mxx = Math.max(mxx, curr);
			}
		}
		while (!stack.isEmpty()) {
			int curr = heights[stack.pop()] * (stack.isEmpty() ? heights.length : (heights.length - stack.peek() - 1));
			mxx = Math.max(mxx, curr);
		}

		return mxx;
	}

}
