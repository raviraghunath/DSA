package TreesAndGraphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BalancedBracketSequence {

	public static void main(String[] args) {
		BalancedBracketSequence balancedBracketSequence = new BalancedBracketSequence();
		System.out.println(balancedBracketSequence.getMinNumRemovableBracketCnt("(a)()))()", 0));
		System.out.println(balancedBracketSequence.res);
	}

	Set<String> res = new HashSet<String>();


	private int getMinNumRemovableBracketCnt(String s, int cnt) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		if (isBalanced(s)) {
			res.add(s);
			return cnt;
		}
		int minCnt = Integer.MAX_VALUE;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == ')') {
				int currCnt = getMinNumRemovableBracketCnt(s.substring(0, i) + s.substring(i + 1, s.length()), cnt + 1);
				if (currCnt != -1 && minCnt > currCnt) {
					minCnt = currCnt;
				}
			}
		}
		return minCnt == Integer.MAX_VALUE ? -1 : minCnt;
	}

	private boolean isBalanced(String s) {
		int cnt = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				cnt++;
			} else if (s.charAt(i) == ')') {
				cnt--;
			}
			if (cnt < 0)
				return false;
		}
		return cnt == 0;
	}

}
