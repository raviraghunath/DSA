package ArraysNStrings;

public class MedianTwoSortedArraysV1 {

	public static void main(String[] args) {
		MedianTwoSortedArraysV1 medianTwoSortedArraysV1 = new MedianTwoSortedArraysV1();
		int nums1[] = new int[] { 1,3};
		int nums2[] = new int[] { 2,  };
		double f = medianTwoSortedArraysV1.findMedian(nums1, nums2);
		System.out.println(f);
	}

	private double findMedian(int[] arr1, int[] arr2) {
		if (arr1.length > arr2.length) {
			return findMedian(arr2, arr1);
		}
		int len1 = arr1.length;
		int len2 = arr2.length;

		int low = 0;
		int high = len1 ;

		while (low <= high) {
			int px = (low + high) / 2;
			int py = ((len1 + len2 + 1) / 2) - px;

			int xLeftMax = px == 0 ? Integer.MIN_VALUE : arr1[px - 1];
			int xRightMin = px == len1 ? Integer.MAX_VALUE : arr1[px];

			int yLeftMax = py == 0 ? Integer.MIN_VALUE : arr2[py - 1];
			int yRightMin = py == len2 ? Integer.MAX_VALUE : arr2[py];

			if (xLeftMax <= yRightMin && yLeftMax <= xRightMin) {
				if ((len1 + len2) % 2 == 0) {
					return (Math.max(xLeftMax, yLeftMax) + Math.min(xRightMin, yRightMin)) / 2.0;
				} else {
					return (double) Math.max(xLeftMax, yLeftMax);
				}
			} else if (xLeftMax > yRightMin) {
				high = px - 1;
			} else {
				low = px + 1;
			}
		}
		return -1;
	}

}
