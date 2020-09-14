package Revision;

public class MedianOfArrays {

	public static void main(String[] args) {
		MedianOfArrays medianTwoSortedArraysV1 = new MedianOfArrays();
		int nums1[] = new int[] { 1, 3, 7, }; // 3,7,2,4
		int nums2[] = new int[] { 2, 4, 10 };
		double f = medianTwoSortedArraysV1.getMedian(nums1, nums2);
		System.out.println(f);
		double f1 = medianTwoSortedArraysV1.getMedianV1(nums1, nums2, 0, nums1.length - 1, 0, nums2.length - 1);
		System.out.println(f1);

	}

	private double getMedianV1(int arr1[], int arr2[], int st1, int ed1, int st2, int ed2) {
		int len1 = ed1 - st1 + 1; 
		int len2 = ed2 - st2 + 1;

		if (len1 == 1 && len2 == 1) {
			return (arr1[st1] + arr2[st2]) / 2.0;
		}

		int mid1 = st1 + (len1 / 2);
		int mid2 = st2 + (len2 / 2);

		if (arr1[mid1] >= arr2[mid2]) {
			return getMedianV1(arr1, arr2, st1, mid1 - 1, mid2, ed2);
		} else {
			return getMedianV1(arr1, arr2, mid1, ed1, st2, mid2);
		}
	}

	private double getMedian(int arr1[], int arr2[]) {
		if (arr1.length > arr2.length) {
			return getMedian(arr2, arr1);
		}
		int len1 = arr1.length;
		int len2 = arr2.length;

		int low = 0;
		int high = len1;

		while (low <= high) {
			int partition1 = ((low + high) / 2);
			int partition2 = (len1 + len2 + 1) / 2 - partition1;

			int arr1LeftMax = partition1 == 0 ? Integer.MIN_VALUE : arr1[partition1 - 1];
			int arr1RightMin = partition1 == len1 ? Integer.MAX_VALUE : arr1[partition1];
			int arr2LeftMax = partition2 == 0 ? Integer.MIN_VALUE : arr2[partition2 - 1];
			int arr2RightMin = partition2 == len2 ? Integer.MAX_VALUE : arr2[partition2];

			if (arr1LeftMax <= arr2RightMin && arr2LeftMax <= arr1RightMin) {
				if ((len1 + len2) % 2 == 0) {
					return (Math.max(arr1LeftMax, arr2LeftMax) + Math.min(arr1RightMin, arr2RightMin)) / 2.0;
				} else {
					return Math.max(arr1LeftMax, arr2LeftMax);
				}
			} else if (arr1LeftMax > arr2RightMin) {
				high = partition1 - 1;
			} else {
				low = partition1 + 1;
			}
		}
		throw new IllegalArgumentException();
	}
}
