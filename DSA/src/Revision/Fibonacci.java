package Revision;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

	public static void main(String[] args) {
		Fibonacci fibonacci = new Fibonacci();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		System.out.println(fibonacci.getFib(90, map));
	}

	private int getFib(int n, Map<Integer, Integer> map) {
		if (n == 0 || n == 1) {
			return n;
		}
		Integer cacheValue = map.get(n);
		if (cacheValue != null) {
			return cacheValue;
		}
		int res = getFib(n - 1, map) + getFib(n - 2, map);
		map.put(n, res);
		return res;
	}

}
