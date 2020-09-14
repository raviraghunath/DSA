//https://www.youtube.com/watch?v=TUl1AsOfKP4&t=8s
package LinkedListNStacks;

import java.util.Stack;

public class ScoreOfBalancedParathesis {

	public static void main(String[] args) {
		ScoreOfBalancedParathesis scoreOfBalancedParathesis = new ScoreOfBalancedParathesis();
		System.out.println(scoreOfBalancedParathesis.getScore("(()(()))"));
	}

	private int getScore(String s) {
		Stack<Integer> stack = new Stack<Integer>();
		int[] arr = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				stack.push(i);
				arr[i] = -1;
			} else if (c == ')') {
				int pos = stack.pop();
				arr[pos] = i;
			}
		}
		return getScore(arr, 0, arr.length - 1);
	}

	private int getScore(int[] arr, int st, int ed) {
		if (st + 1 == ed) {
			return 1;
		}
		int pos = arr[st];
		if (pos != ed) {
			return getScore(arr, st, pos) + getScore(arr, pos + 1, ed);
		} else {
			return 2 * getScore(arr, st + 1, ed - 1);
		}
	}

}
