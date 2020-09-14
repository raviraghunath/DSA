package Revision;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatrixProduct {
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

	private static class Val {
		int amt;
		String str;

		public Val(int amt, String str) {
			this.amt = amt;
			this.str = str;
		}

		@Override
		public String toString() {
			return "Val [amt=" + amt + ", str=" + str + "]";
		}
	}

	public static void main(String[] args) {
		MatrixProduct matrixProduct = new MatrixProduct();
		Val v = matrixProduct.getMaxPath(new int[][] { { -1, 2, 3 }, { 4, 5, -6 }, { 7, 8, 9 } });
		System.out.println("MaxPath : " + v.amt + ", Path:" + v.str);
	}

	private Val getMaxPath(int arr[][]) {
		Map<Point, List<Val>> cache = new HashMap<MatrixProduct.Point, List<Val>>();
		List<Val> list = getMaxPath(arr, 0, 0, cache);
		Val max = list.get(0);
		for (Val v : list) {
			if (v.amt > max.amt) {
				max = v;
			}
		}
		return max;
	}

	private List<Val> getMaxPath(int arr[][], int i, int j, Map<Point, List<Val>> cache) {
		if (i == arr.length - 1 && j == arr[i].length - 1) {
			List<Val> list = new ArrayList<MatrixProduct.Val>();
			list.add(new Val(arr[i][j], "i:" + i + ",j:" + j));
			return list;
		}
		Point point = new Point(i, j);
		List<Val> cacheRes = cache.get(point);
		if(cacheRes!=null) {
			System.out.println("CHT");
			return cacheRes;
		}
		List<Val> list = new ArrayList<MatrixProduct.Val>();
		if (j < arr[i].length - 1) {
			for (Val v : getMaxPath(arr, i, j + 1, cache)) {
				Val v1 = new Val(v.amt * arr[i][j], "i:" + i + ",j:" + j + "--" + v.str);
				list.add(v1);
			}
		}
		if (i < arr.length - 1) {
			for (Val v : getMaxPath(arr, i + 1, j, cache)) {
				Val v1 = new Val(v.amt * arr[i][j], "i:" + i + ",j:" + j + "--" + v.str);
				list.add(v1);
			}
		}
		cache.put(point, list);
		return list;

	}

}
