package NumbersNOthers;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

	public static void main(String[] args) {
		Fibonacci fibonacci = new Fibonacci();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		System.out.println(fibonacci.fib(10, map));
		System.out.println(fibonacci.fib(90, map));
	}

	private int fib(int n, Map<Integer, Integer> map) {
		if (n == 0 || n == 1) { 
			return n;
		}
		Integer cacheValue = map.get(n);
		int res = 0;
		if (cacheValue != null) {
			res = cacheValue;
		} else {
			res = fib(n - 1, map) + fib(n - 2, map);
			map.put(n, res);
		}
		return res;
	}
}
