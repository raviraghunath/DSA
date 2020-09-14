package LinkedListNStacks;

import java.util.Stack;

public class SortStacks {

	public static void main(String[] args) {
		Stack<Integer> st = new Stack<Integer>();
		st.push(1);
		st.push(3);
		st.push(2);
		st.push(4);
		SortStacks sortStacks = new SortStacks();
		sortStacks.print(st);
		System.out.println();
		sortStacks.sortStack(st);
		sortStacks.print(st);
	}

	private void sortStack(Stack<Integer> s1) {
		if (s1 == null || s1.isEmpty()) {
			return;
		}
		Stack<Integer> s2 = new Stack<Integer>();
		while (!s1.isEmpty()) {
			int ele = s1.pop();
			if (s2.isEmpty()) {
				s2.push(ele);
			} else {
				if (s2.peek() > ele) {
					s2.push(ele);
				} else {
					while (!s2.isEmpty() && s2.peek() < ele) {
						s1.push(s2.pop());
					}
					s2.push(ele);
				}
			}
		}
		while (!s2.isEmpty()) {
			s1.push(s2.pop());
		}
	}

	private void print(Stack<Integer> st) {
		if (st.isEmpty()) {
			return;
		}
		int ele = st.pop();
		System.out.print(ele + ",");
		print(st);
		st.push(ele);
	}

}
