package ArraysNStrings;

import java.util.ArrayList;
import java.util.List;

public class AddOpertaorInExpression {

	public static void main(String[] args) {
		AddOpertaorInExpression addOpertaorInExpression = new AddOpertaorInExpression();
		System.out.println(addOpertaorInExpression.addOperators("", 5));
//		System.out.println(addOpertaorInExpression.getRes("1-4*5*6"));
	}

	public List<String> addOperators(String ip, int target) {
		return addOperators(ip, target, 0, "");
	}

	ExpressionEvaluation expressionEvaluation = new ExpressionEvaluation();

	public List<String> addOperators(String ip, int target, int pos, String s) {
		if (pos == ip.length()) {
			if (target == expressionEvaluation.getRes(s)) {
				List<String> res = new ArrayList<String>(1);
				res.add(s);
				return res;
			}
			return new ArrayList<String>();
		}
		if (pos == 0) {
			return addOperators(ip, target, pos + 1, s + ip.charAt(pos));
		} else {
			List<String> res = new ArrayList<String>();
			List<String> res1 = addOperators(ip, target, pos + 1, s + "+" + ip.charAt(pos));
			List<String> res2 = addOperators(ip, target, pos + 1, s + "-" + ip.charAt(pos));
			List<String> res3 = addOperators(ip, target, pos + 1, s + "*" + ip.charAt(pos));

			List<String> res4 = addOperators(ip, target, pos + 1, s + ip.charAt(pos));
			if (res1 != null) {
				res.addAll(res1);
			}
			if (res2 != null) {
				res.addAll(res2);
			}
			if (res3 != null) {
				res.addAll(res3);
			}
			if (res4 != null) {
				res.addAll(res4);
			}
			return res;
		}
	}

	private int getRes(String s) {// 1-4*5*6
		if (s == null || s.equals("")) {
			return -1;
		}
		int res = -1;
		String t = "";
		char prevOperator = ' ';
		char currentOperator = ' ';
		int prevValue = -1;
		int currVal = -1;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != '+' && s.charAt(i) != '-' && s.charAt(i) != '*') {
				t += s.charAt(i);
			} else {
				if (currVal != -1) {
					prevValue = currVal;
				}
				if (t.startsWith("0") && t.length() > 1) {
					return -1;
				}
				currVal = Integer.parseInt(t);
				if (res == -1) {
					res = currVal;
				} else {
					if (currentOperator == '+') {
						res += currVal;
					} else if (currentOperator == '-') {
						res -= currVal;
					} else {
						if (prevOperator == '+') {
							res -= prevValue;
							res += prevValue * currVal;
						} else if (prevOperator == '-') {
							res += prevValue;
							res -= prevValue * currVal;
						} else {
							res *= currVal;
						}
					}
				}
				if (prevOperator == ' ' && currentOperator != ' ') {
					prevOperator = currentOperator;
				}
				currentOperator = s.charAt(i);
				t = "";
			}
		}
		if (currVal != -1) {
			prevValue = currVal;
		}
		if (t.startsWith("0") && t.length() > 1) {
			return -1;
		}
		try {
			currVal = Integer.parseInt(t);
		} catch (Exception e) {
			return -1;
		}
		if (currentOperator == '+') {
			res += currVal;
		} else if (currentOperator == '-') {
			res -= currVal;
		} else {
			if (prevOperator == '+') {
				res -= prevValue;
				res += prevValue * currVal;
			} else if (prevOperator == '-') {
				res += prevValue;
				res -= prevValue * currVal;
			} else {
				res *= currVal;
			}
		}

		return res;

	}

	public List<String> addOperatorsV1(String ip, int target) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < ip.length(); i++) {
			list.add(ip.charAt(i) + "");
		}
		List<String> res = addOperatorsV1(list, 0, target, 0, new ArrayList<String>());
		return res;
	}

	public List<String> addOperatorsV1(List<String> num, int currTarget, int iniTarget, int pos, List<String> strs) {
		if (currTarget == iniTarget && pos == num.size()) {
			List<String> res = new ArrayList<String>(1);
			String listString = "";
			for (String s : strs) {
				listString += s;
			}
			res.add(listString);
			return res;
		}
		if (pos == num.size()) {
			return null;
		}

		if (pos == 0) {
			int ele1 = Integer.parseInt(num.get(pos));
			strs.add(ele1 + "");
			return addOperatorsV1(num, ele1, iniTarget, pos + 1, strs);
		} else {
			int ele1 = Integer.parseInt(num.get(pos));
			List<String> res = new ArrayList<String>();
			List<String> l1 = new ArrayList<String>();
			l1.addAll(strs);
			l1.add("+");
			l1.add("" + ele1);
			List<String> res1 = addOperatorsV1(num, currTarget + ele1, iniTarget, pos + 1, l1);
			if (res1 != null) {
				res.addAll(res1);
			}
			List<String> l2 = new ArrayList<String>();
			l2.addAll(strs);
			int ele0 = Integer.parseInt(num.get(pos - 1));
			int c1 = currTarget;
			int lastOpIndex = l2.size() - 1 - 1;
			if (l2.size() > 1 && l2.get(lastOpIndex) == "+") {
				c1 = c1 - ele0;
				c1 = c1 + ele0 * ele1;
			} else if (l2.size() > 1 && l2.get(lastOpIndex) == "-") {
				c1 = c1 + ele0;
				c1 = c1 - ele0 * ele1;
			} else {
				c1 = c1 * ele1;
			}
			l2.add("*");
			l2.add("" + ele1);
			List<String> res2 = addOperatorsV1(num, c1, iniTarget, pos + 1, l2);
			if (res2 != null) {
				res.addAll(res2);
			}
			List<String> l3 = new ArrayList<String>();
			l3.addAll(strs);
			l3.add("-");
			l3.add("" + ele1);
			List<String> res3 = addOperatorsV1(num, currTarget - ele1, iniTarget, pos + 1, l3);
			if (res3 != null) {
				res.addAll(res3);
			}

			int ele2 = Integer.parseInt(ele0 + "" + ele1);
			if (ele0 != 0) {
				List<String> l4 = new ArrayList<String>();
				l4.addAll(strs);
				lastOpIndex = l4.size() - 1;
				if (l4.size() > 0) {
					l4.remove(lastOpIndex);
				}
				l4.add("" + ele2);
				List<String> res4 = addOperatorsV1(num, ele2, iniTarget, pos + 1, l4);
				if (res4 != null) {
					res.addAll(res4);
				}
			}

			return res;
		}
	}

}
