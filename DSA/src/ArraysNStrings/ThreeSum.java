package ArraysNStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	public static void main(String[] args) {
		ThreeSum threeSum = new ThreeSum();
		System.out.println(threeSum.threeSum(new int[] { -1, 0, 1, 2, -1, -4 })); // [-4, -1, -1, 0, 1, 2]
	}

	public List<List<Integer>> threeSum(int[] arr) {
		Arrays.sort(arr);
		List<List<Integer>> res = new ArrayList<List<Integer>>();

		for (int i = 0; i <= arr.length - 3; i++) {
			if (i == 0 || arr[i] > arr[i - 1]) {
				int p2 = i + 1;
				int p3 = arr.length - 1;

				while (p2 < p3) {
					if (arr[i] == -(arr[p2] + arr[p3])) {
						List<Integer> list = new ArrayList<Integer>();
						list.add(arr[i]);
						list.add(arr[p2]);
						list.add(arr[p3]);
						res.add(list);
					}
					if (Math.abs(arr[i]) > Math.abs(arr[p2] + arr[p3])) {
						int currSt = p2;
						//For duplicates
						while (arr[currSt] == arr[p2] && p3 > p2) {
							p2++;
						}
					} else {
						int currEd = p3;
						//For duplicates
						while (arr[currEd] == arr[p3] && p3 > p2) {
							p3--;
						}
					}
				}
			}
		}
		return res;
	}

}
