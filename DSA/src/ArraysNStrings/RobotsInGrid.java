package ArraysNStrings;

import java.util.HashMap;
import java.util.Map;

public class RobotsInGrid {
	public static void main(String[] args) {
		RobotsInGrid grid = new RobotsInGrid();
		// System.out.println(grid.uniquePaths(23, 12));
		int arr[][] = new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		Map<Point, Boolean> cache = new HashMap<Point, Boolean>();
		int[][] path = new int[arr.length][arr.length];
		System.out.println(grid.findPath(arr, 0, 0, cache, path));
		for (int i = 0; i < path.length; i++) {
			for (int j = 0; j < path[i].length; j++) {
				System.out.print(path[i][j] + " ");
			}
			System.out.println();
		}
	}

	private boolean findPath(int[][] tab, int st, int ed, Map<Point, Boolean> cache, int[][] path) {
		if (st >= tab.length || ed >= tab[tab.length - 1].length) {
			return false;
		}
		if (tab[st][ed] == 1) {
			return false;
		}
		if (st == tab.length - 1 && ed == tab[tab.length - 1].length - 1) {
			return true;
		}
		Point cP = new Point(st, ed);
		if (cache.containsKey(cP)) {
			return cache.get(cP);
		}
		boolean res1 = findPath(tab, st, ed + 1, cache, path);
		boolean res2 = findPath(tab, st + 1, ed, cache, path);
		if (res1) {
			path[st][ed + 1] = 1;
		}
		if (res2) {
			path[st + 1][ed] = 1;
		}
		boolean res = res1 || res2;
		cache.put(cP, res);
		return res;
	}

	public int uniquePaths(int m, int n) {
		int[][] cache = new int[n + 1][m + 1];
		for (int i = 0; i < cache.length; i++) {
			for (int j = 0; j < cache[i].length; j++) {
				cache[i][j] = -1;
			}
		}
		int res = uniquePaths(m, n, cache);
		return res;
	}

	public int uniquePaths(int m, int n, int[][] cache) {
		if (m == 1 && n == 1) {
			return 1;
		}
		if (m < 1 || n < 1) {
			return 0;
		}
		if (cache[n][m] != -1) {
			return cache[n][m];
		}
		int res = uniquePaths(m, n - 1, cache) + uniquePaths(m - 1, n, cache);
		cache[n][m] = res;
		return res;
	}

	static class Point {
		Point(int i, int j) {
			this.i = i;
			this.j = j;
		}

		int i;

		int j;

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + i;
			result = prime * result + j;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (i != other.i)
				return false;
			if (j != other.j)
				return false;
			return true;
		}
	}

}
