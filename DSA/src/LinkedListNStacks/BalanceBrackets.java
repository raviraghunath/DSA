package LinkedListNStacks;

import java.util.Stack;

public class BalanceBrackets {

	public static void main(String[] args) {
		BalanceBrackets balanceBrackets = new BalanceBrackets();
		System.out.println(balanceBrackets.isBalanced("{[()]}"));
		System.out.println(balanceBrackets.isBalanced("{}()"));
		System.out.println(balanceBrackets.isBalanced("{(})"));
		System.out.println(balanceBrackets.isBalanced(")"));
	}

	private boolean isBalanced(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char ele = s.charAt(i);
			if (ele == '(' || ele == '{' || ele == '[') {
				stack.push(ele);
			} else {
				if(stack.isEmpty()) {
					return false;
				}
				char t = stack.pop();
				if (ele == ')') {
					if (t != '(') {
						return false;
					}
				} else if (ele == '}') {
					if (t != '{') {
						return false;
					}
				} else if (ele == ']') {
					if (t != '[') {
						return false;
					}
				}
			}
		}
		return stack.isEmpty();
	}
}
