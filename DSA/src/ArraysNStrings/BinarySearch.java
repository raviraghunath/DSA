package ArraysNStrings;

public class BinarySearch {

	public static void main(String[] args) {
		BinarySearch binarySearch = new BinarySearch();
		int[] arr = new int[] { 1, 2, 3, 4, 5, 67, 89 };
		System.out.println(binarySearch.bs(arr, 89, 0, arr.length - 1));
	}

	private int bs(int[] arr, int ele, int st, int ed) {
		if (st > ed) {
			return -1;
		}
		int mid = st + ((ed - st + 1) / 2);
		if (ele == arr[mid]) {
			return mid;
		} else if (arr[mid] > ele) {
			return bs(arr, ele, st, mid - 1);
		} else {
			return bs(arr, ele, mid + 1, ed);
		}
	}
}
