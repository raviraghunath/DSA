package Revision;

import java.util.ArrayList;
import java.util.List;

public class DuplicatesInArray1_N {

	public static void main(String[] args) {
		DuplicatesInArray1_N array1_N = new DuplicatesInArray1_N();
		System.out.println(array1_N.findDuplicates(new int[] { 2, 1, 2, 1 }));
	}

	private List<Integer> findDuplicates(int arr[]) {
		List<Integer> res = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			int ele = Math.abs(arr[i]);
			if (arr[ele - 1] < 0) {
				res.add(Math.abs(arr[ele - 1]));
			}
			arr[ele - 1] = -Math.abs(arr[ele - 1]);
		}
		return res;
	}
}
