package ArraysNStrings;

public class RotatedSortedArrMin {

	public static void main(String[] args) {
		RotatedSortedArrMin arrMin = new RotatedSortedArrMin();
		System.out.println(arrMin.findMin(new int[] { 3, 4, 5, 6, 7, 8, 9, 1, 2 }));
		System.out.println(arrMin.findMinV1(new int[] { 10, 10, 10, 1, 10 }));
	}

	public int findMin(int[] nums) {
		return doProcess(nums, 0, nums.length - 1);
	}

	public int findMinV1(int[] nums) {
		return doProcessV1(nums, 0, nums.length - 1);
	}

	private int doProcess(int[] arr, int st, int ed) {
		int len = (ed - st + 1);
		if (len == 1) {
			return arr[st];
		}
		int mid = st + (len / 2);
		if (arr[st] < arr[mid]) {
			if (arr[st] < arr[ed]) {
				return arr[st];
			} else {
				return doProcess(arr, mid + 1, ed);
			}
		} else {
			if (arr[mid - 1] < arr[mid]) {
				return doProcess(arr, st + 1, mid - 1);
			} else {
				return doProcess(arr, mid, ed);
			}

		}
	}

	private int doProcessV1(int[] arr, int st, int ed) {
		int len = (ed - st + 1);
		if (st > ed) {
			return -1;
		}
		if (len == 1) {
			return arr[st];
		}
		int mid = st + (len / 2);
		if (arr[mid] > arr[st]) {
			if (arr[ed] <= arr[st]) {
				return doProcessV1(arr, mid + 1, ed);
			} else {
				return arr[st];
			}
		} else if (arr[mid] < arr[st]) {
			return doProcessV1(arr, st + 1, mid);
		} else {
			if (arr[mid] < arr[ed]) {
				return doProcessV1(arr, st + 1, mid);
			} else if (arr[mid] > arr[ed]) {
				return doProcessV1(arr, mid + 1, ed);
			} else {
				return doProcessV1(arr, st + 1, ed);
			}
		}

	}

}
