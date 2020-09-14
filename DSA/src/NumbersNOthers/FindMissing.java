package NumbersNOthers;

import java.util.ArrayList;
import java.util.List;

public class FindMissing {

	public static void main(String[] args) {
		FindMissing findMissing = new FindMissing();
		System.out.println(findMissing.findMissingOne(new int[] { 1, 2, 4, 5 }));
		System.out.println(findMissing.findMissingTwo(new int[] { 1, 2, 4, 5 }));
	}

	private int findMissingOne(int arr[]) {
		if (arr == null || arr.length == 0) {
			return -1;
		}
		int totalXOR = 0;
		int currXOR = 0;
		for (int i = 1; i <= arr.length + 1; i++) {
			totalXOR ^= i;
		}
		for (int i = 0; i < arr.length; i++) {
			currXOR ^= arr[i];
		}
		return totalXOR ^ currXOR;
	}

	private List<Integer> findMissingTwo(int arr[]) {
		if (arr == null || arr.length == 0) {
			return null;
		}
		int currSum = 0;
		for (int i = 0; i < arr.length; i++) {
			currSum += arr[i];
		}
		int totalSum = ((arr.length + 2) * (arr.length + 3)) / 2;
		int diff = (totalSum - currSum) / 2;

		int totalLeftXOR = 0;
		int currLeftXOR = 0;
		List<Integer> res = new ArrayList<Integer>();
		for (int i = 1; i <= diff; i++) {
			totalLeftXOR ^= i;
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] <= diff) {
				currLeftXOR ^= arr[i];
			}
		}
		res.add(totalLeftXOR ^ currLeftXOR);
		int totalRightXOR = 0;
		int currRightXOR = 0;
		for (int i = diff + 1; i <= arr.length + 2; i++) {
			totalRightXOR ^= i;
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > diff) {
				currRightXOR ^= arr[i];
			}
		}
		res.add(totalRightXOR ^ currRightXOR);
		return res;
	}

}
