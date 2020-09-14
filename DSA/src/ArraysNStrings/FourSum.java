package ArraysNStrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FourSum {

	static class pair {
		int first, second;

		public pair(int first, int second) {
			this.first = first;
			this.second = second;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + first;
			result = prime * result + second;
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
			pair other = (pair) obj;
			if (first != other.first)
				return false;
			if (second != other.second)
				return false;
			return true;
		}

	}

	public static void main(String[] args) {
		FourSum fourSum = new FourSum();
		System.out.println(fourSum.find4Sum(new int[] { 10, 20, 30, 40, 1, 2 }, 91));
	}

	private List<List<Integer>> find4Sum(int arr[], int n) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Map<Integer, pair> mp = new HashMap<Integer, pair>();
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				mp.put(arr[i] + arr[j], new pair(i, j));
			}
		}
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int sum = arr[i] + arr[j];
				if (mp.containsKey(n - sum)) {
					pair p = mp.get(n - sum);
					if (p.first != i && p.first != j && p.second != i && p.second != j) {
						List<Integer> list = new ArrayList<Integer>();
						list.add(arr[i]);
						list.add(arr[j]);
						list.add(arr[p.first]);
						list.add(arr[p.second]);
						res.add(list);
					}
				}
			}
		}
		return res;

	}

}
