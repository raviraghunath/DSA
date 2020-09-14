package ArraysNStrings;

public class LocalMinimum {

	public static void main(String[] args) {
		LocalMinimum localMinimum = new LocalMinimum();
		System.out.println(localMinimum.getLocal(new int[] { 21, 13, 12, 10, 11 }));
		System.out.println(localMinimum.getLocalV1(new int[] { 5, 6, 8, 10, 12 }, 0, 4));
	}

	private int getLocalV1(int[] arr, int st, int ed) {
		int len = ed - st + 1;

		if (len == 1) {
			return arr[st];
		}
		if (len == 2) {
			return arr[st] > arr[ed] ? arr[ed] : arr[st];
		}
		int i = st + len / 2;

		if (arr[i] <= arr[i + 1] && arr[i - 1] >= arr[i]) {
			return arr[i];
		} else if (arr[i] > arr[i + 1]) {
			return getLocalV1(arr, i + 1, ed);
		} else {
			return getLocalV1(arr, st, i - 1);
		}
	}

	private int getLocal(int[] arr) {
		if (arr == null || arr.length == 0) {
			return -1;
		}
		if (arr.length == 1) {
			return arr[0];
		}
		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {
				if (arr[i] <= arr[i + 1]) { // 5<9
					return arr[i];
				}
			} else if (i == arr.length - 1) {
				if (arr[i] <= arr[i - 1]) {
					return arr[i];
				}
			} else {
				if (arr[i] <= arr[i + 1] && arr[i - 1] >= arr[i]) {
					return arr[i];
				}
			}
		}
		return -1;
	}
}
