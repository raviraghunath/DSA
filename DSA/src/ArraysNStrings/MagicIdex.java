package ArraysNStrings;

public class MagicIdex {
	public static void main(String[] args) {
		MagicIdex magicIdex = new MagicIdex();
		int[] arr = new int[] { -10, -9, 2, 5, 7, 8 };
		System.out.println(magicIdex.getMagicIndex(arr, 0, arr.length - 1));
		int[] arr1 = new int[] { -10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13 };
		System.out.println(magicIdex.getMagicIndexForDup(arr1, 0, arr1.length - 1));
	}

	private int getMagicIndex(int[] arr, int st, int ed) {
		if (st >= arr.length || ed < 0 || st > ed) {
			return -1;
		}
		int len = ed - st + 1;
		int mid = st + (len / 2);
		if (arr[mid] == mid) {
			return mid;
		} else if (arr[mid] > mid) {
			return getMagicIndex(arr, st, mid - 1);
		} else {
			return getMagicIndex(arr, mid + 1, ed);
		}
	}

	private int getMagicIndexForDup(int[] arr, int st, int ed) {
		if (st >= arr.length || ed < 0 || st > ed) {
			return -1;
		}
		int len = ed - st + 1;
		int mid = st + (len / 2);
		if (arr[mid] == mid) {
			return mid;
		}
		int l = getMagicIndexForDup(arr, st, Math.min(mid - 1, arr[mid]));
		if (l > 0) {
			return l;
		}
		int r = getMagicIndexForDup(arr, Math.max(mid + 1, arr[mid]), 0);
		return r;
	}

}
