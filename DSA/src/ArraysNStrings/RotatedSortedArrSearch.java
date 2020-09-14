package ArraysNStrings;

public class RotatedSortedArrSearch {
	public static void main(String[] args) {
		RotatedSortedArrSearch rotatedSortedArrSearch = new RotatedSortedArrSearch();
		int[] arr = new int[] { 4, 5, 6, 7, 0, 1, 2 };
		System.out.println(rotatedSortedArrSearch.doProcess(arr, 0, 0, arr.length - 1));

	}

	private int doProcess(int[] arr, int ele, int st, int ed) {
		if (st > ed) {
			return -1;
		}
		int mid = st + ((ed - st + 1) / 2);
		if (arr[mid] == ele) {
			return mid;
		} else if (arr[mid] > arr[st]) {
			if (arr[st] <= ele && arr[mid] > ele) {
				return doProcess(arr, ele, st, mid - 1);
			} else {
				return doProcess(arr, ele, mid + 1, ed);
			}
		} else {
			if (arr[mid]<ele && arr[ed] >= ele) {
				return doProcess(arr, ele, mid + 1, ed);
			} else {
				return doProcess(arr, ele, st, mid - 1);
			}
		}
	}
}
