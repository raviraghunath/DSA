package ArraysNStrings;

import java.util.HashMap;
import java.util.Map;

public class TripleSteps {

	public static void main(String[] args) {
		TripleSteps tripleSteps = new TripleSteps();
		System.out.println(tripleSteps.cnt(0, 5));
		System.out.println(tripleSteps.cnt(5));
	}

	Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

	private int cnt(int pos, int n) {
		if (pos == n) {
			return 1;
		}
		if (pos > n) {
			return 0;
		}
		if (hashMap.containsKey(pos)) {
			return hashMap.get(pos);
		}
		int res = cnt(pos + 1, n) + cnt(pos + 2, n) + cnt(pos + 3, n);
		hashMap.put(pos, res);
		return res;
	}

	private int cnt(int n) {
		if (n <= 0) {
			return 0;
		}
		if (n == 1 || n == 2) {
			return n;
		}
		if (n == 3) {
			return 4;
		}
		int p1 = 1;
		int p2 = 2;
		int p3 = 4;
		int p4 = 0;
		for (int i = 4; i <= n; i++) {
			p4 = p3 + p2 + p1;
			p1 = p2;
			p2 = p3;
			p3 = p4;
		}
		return p4;
	}
}
