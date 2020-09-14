package Revision;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
	static class Point {
		int i;
		int j;

		Point(int i, int j) {
			this.i = i;
			this.j = j;
		}

		@Override
		public String toString() {
			return "Pt [i=" + i + ", j=" + j + "]";
		}

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

	public static void main(String[] args) {
		NQueens nQueens = new NQueens();
		System.out.println(nQueens.queen(8));
	}

	private int queen(int n) {
		int cnt = 0;
		for (int j = 0; j < n; j++) {
			int way = ways(n, new Point(0, j), new ArrayList<NQueens.Point>());
			cnt += way;
		}
		return cnt;
	}

	private int ways(int n, Point p, List<Point> points) {
		for (Point point : points) {
			if (p.i == point.i || p.j == point.j || Math.abs(p.j - point.j) == Math.abs(p.i - point.i)) {
				return 0;
			}
		}
		points.add(p);
		if (p.i == n - 1) {
			return 1;
		}
		int cnt = 0;
		for (int j = 0; j < n; j++) {
			int way = ways(n, new Point(p.i + 1, j), new ArrayList<Point>(points));
			cnt += way;
		}
		return cnt;
	}

}
