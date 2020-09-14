package LinkedListNStacks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class ReverseStack {

	public static void main(String[] args) {
		ReverseStack reverseStack = new ReverseStack();
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		reverseStack.print(stack);
		System.out.println();
		reverseStack.reverserStack(stack);
		reverseStack.print(stack);
		System.out.println();
		reverseStack.reverserStackV1(stack);
		reverseStack.print(stack);
		System.out.println();
	}

	private void reverserStackV1(Stack<Integer> stack) {
		if (stack.isEmpty()) {
			return;
		}
		int ele = stack.pop();
		reverserStackV1(stack);
		insertAtLast(stack, ele);
	}

	private void insertAtLast(Stack<Integer> stack, int X) {
		if (stack.isEmpty()) {
			stack.push(X);
			return;
		}
		int ele = stack.pop();
		insertAtLast(stack, X);
		stack.push(ele);
		return;
	}

	private void reverserStack(Stack<Integer> stack) {
		List<Integer> list = reverserStackUtil(stack);
		Collections.sort(list, Collections.reverseOrder());
		for (Integer i : list) {
			stack.push(i);
		}
	}

	private List<Integer> reverserStackUtil(Stack<Integer> stack) {
		if (stack.isEmpty()) {
			return new ArrayList<Integer>();
		}
		int ele = stack.pop();
		List<Integer> list = reverserStackUtil(stack);
		list.add(ele);
		return list;
	}

	private void print(Stack<Integer> st) {
		if(st.isEmpty()) {
			return;
		}
		int ele = st.pop();
		System.out.print(ele + ",");
		print(st);
		st.push(ele);
	}

}
