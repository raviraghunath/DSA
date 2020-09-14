//https://leetcode.com/problems/reverse-words-in-a-string-ii/ 
package ArraysNStrings;

import java.util.Stack;

public class ReverseWordsInString {

	public static void main(String[] args) {
		ReverseWordsInString reverseWordsInString = new ReverseWordsInString();
		System.out.println(reverseWordsInString.reverseWords("a good   example"));

	}

	public String reverseWords(String s) {
		s = s.trim();
		Stack<String> stack = new Stack<String>();
		StringBuilder t = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c != ' ') {
				t.append(c);
			} else {
				String t1 = t.toString().trim();
				if (t1.length() > 0) {
					stack.push(t1);
				}
				t = new StringBuilder();
			}
		}
		stack.push(t.toString());
		StringBuilder stringBuilder = new StringBuilder();
		while (!stack.isEmpty()) {
			stringBuilder.append(stack.pop());
			if (!stack.isEmpty()) {
				stringBuilder.append(" ");
			}
		}
		return stringBuilder.toString();
	}
}
