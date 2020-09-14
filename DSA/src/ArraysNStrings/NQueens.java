package ArraysNStrings;

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
		List<List<String>> reess= nQueens.solveNQueens(8);
		System.out.println(reess.size());
		System.out.println(reess);
	}

	public static final String Q = "Q";
	public static final String NQ = ".";

	public List<List<String>> solveNQueens(int n) {
		List<List<Point>> res = queen(n);
		List<List<String>> strs = new ArrayList<List<String>>();
		for(List<Point> lp : res) {
			List<String> subStrs = new ArrayList<String>();
			for(Point p:lp) {
				StringBuilder s = new StringBuilder();
				for(int j=0;j<n;j++) {
					if(j==p.j)s.append(Q);
					else s.append(NQ);
				}
				subStrs.add(s.toString());
			}
			strs.add(subStrs);
		}
		return strs;
	}

	private List<List<Point>> queen(int n) {
		List<List<Point>> ret = new ArrayList<List<Point>>();
		for (int j = 0; j < n; j++) {
			List<List<Point>> subRet = canBePlaced(n, new Point(0, j), new ArrayList<Point>());
			for (List<Point> sub : subRet) {
				ret.add(sub);
			}
		}
		return ret;
	}

	private List<List<Point>> canBePlaced(int n, Point p, List<Point> points) {
		for (Point point : points) {
			if (point.i == p.i || point.j == p.j || Math.abs(point.j - p.j) == Math.abs(point.i - p.i)) {
				List<List<Point>> l = new ArrayList<List<Point>>(1);
				return l;
			}
		}
		points.add(p);
		if (p.i == n - 1) {
			List<List<Point>> ret = new ArrayList<List<Point>>(1);
			ret.add(points);
			return ret;
		}
		List<List<Point>> ret = new ArrayList<List<Point>>();
		for (int j = 0; j < n; j++) {
			Point newP = new Point(p.i + 1, j);
			List<List<Point>> subRet = canBePlaced(n, newP, new ArrayList<Point>(points));
			if (subRet != null && subRet.size() > 0) {
				for (List<Point> sub : subRet) {
					ret.add(sub);
				}
			}
		}
		return ret;
	}

}
