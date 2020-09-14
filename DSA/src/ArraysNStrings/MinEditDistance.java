//https://www.geeksforgeeks.org/edit-distance-dp-5/
package ArraysNStrings;

import java.util.HashMap;
import java.util.Map;

public class MinEditDistance {

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
		MinEditDistance minEditDistance = new MinEditDistance();
		System.out.println(minEditDistance.minDistance("horse", "ros"));
	}

	public int minDistance(String word1, String word2) {
		Map<Point, Integer> map = new HashMap<MinEditDistance.Point, Integer>();
		return getMinEditDistance(word1, word2, word1.length() - 1, word2.length() - 1, map);
	}

	private int getMinEditDistance(String str1, String str2, int i1, int i2, Map<Point, Integer> map) {
		if (i1 == -1) {
			return i2 + 1;
		}
		if (i2 == -1) {
			return i1 + 1;
		}
		Point p = new Point(i1, i2);
		Integer cVal = map.get(p);
		if (cVal != null) {
			return cVal; 
		}
		int res = 0;
		if (str1.charAt(i1) == str2.charAt(i2)) {
			res = getMinEditDistance(str1, str2, i1 - 1, i2 - 1, map);
		} else {
			res = 1 + Math.min(getMinEditDistance(str1, str2, i1, i2 - 1, map),
					Math.min(getMinEditDistance(str1, str2, i1 - 1, i2, map),
							getMinEditDistance(str1, str2, i1 - 1, i2 - 1, map)));
		}
		map.put(p, res);
		return res;

	}

}
