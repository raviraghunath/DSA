package ArraysNStrings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidParenthesis {

	public static void main(String[] args) {
		ValidParenthesis parenthesis = new ValidParenthesis();
		System.out.println(parenthesis.generateParenthesis(3));

	}

	public List<String> generateParenthesis(int n) {
		Set<String> set = getValidParenthesises(n);
		List<String> mainList = new ArrayList<String>();
		mainList.addAll(set);
		return mainList;
	}

	private Set<String> getValidParenthesises(int n) {
		if (n == 0) { 
			return null;
		}
		if (n == 1) {
			Set<String> list = new HashSet<String>();
			list.add("()");
			return list;
		}
		Set<String> list = new HashSet<String>();
		for (String s : getValidParenthesises(n - 1)) {
			list.add("()" + s);
			int currLPCnt = 0;
			for (int j = 0; j < s.length(); j++) {
				if (currLPCnt < n && s.charAt(j) == '(') {
					list.add(s.substring(0, j + 1) + "()" + s.substring(j + 1));
					currLPCnt++;
				}

			}
//			int lF = getFirstLftParenIndex(s, 1);
//			if (lF != -1) {
//				list.add(s.substring(0, lF + 1) + "()" + s.substring(lF + 1));
//			}
//			lF = getFirstLftParenIndex(s, 2);
//			if (lF != -1) {
//				list.add(s.substring(0, lF + 1) + "()" + s.substring(lF + 1));
//			}
		}
		return list;
	}

	private int getFirstLftParenIndex(String s, int n) {
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				n--;
				if (n == 0) {
					return i;
				}
			}
		}
		return -1;
	}

}
