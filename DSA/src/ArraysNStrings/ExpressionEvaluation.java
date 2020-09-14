package ArraysNStrings;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ExpressionEvaluation {

	public static void main(String[] args) {
		ExpressionEvaluation expressionEvaluation = new ExpressionEvaluation();
		System.out.println(expressionEvaluation.getRes("15-20+67-17"));

	}

	public int getRes(String s) {
		if(s==null||s.length()==0) {
			return -1;
		}
		Map<Character, Integer> operatorMap = new HashMap<Character, Integer>();
		operatorMap.put('-', 1);
		operatorMap.put('+', 1);
		operatorMap.put('*', 3);
		operatorMap.put('/', 3);
		Stack<Integer> operands = new Stack<Integer>();
		Stack<Character> operator = new Stack<Character>();
		int i = 0;
		while (i < s.length()) {
			char c = s.charAt(i);
			if (operatorMap.containsKey(c)) {
				while (!operator.isEmpty() && operatorMap.get(operator.peek()) >= operatorMap.get(c)) {
					int res = getRes(operands.pop(), operands.pop(), operator.pop());
					operands.push(res);
				}
				operator.push(c);
			} else {
				// this is a number
				String num = "";
				while (i < s.length()) {
					if (operatorMap.containsKey(s.charAt(i))) {
						i--;
						break;
					}
					num += s.charAt(i);
					i++;
				}
				if (num.startsWith("0") && num.length() > 1) {
					return -1;
				}
				try {
					operands.push(Integer.parseInt(num));
				} catch (Exception e) {
					return -1;
				}
			}
			i++;
		}
		while (!operator.isEmpty()) {
			int res = getRes(operands.pop(), operands.pop(), operator.pop());
			operands.push(res);
		}
		return operands.pop();
	}

	private int getRes(int b, int a, char operator) {
		if (operator == '+') {
			return a + b;
		} else if (operator == '-') {
			return a - b;
		} else if (operator == '*') {
			return a * b;
		} else if (operator == '/') {
			return a / b;
		} else {
			return -1;
		}
	}

}
