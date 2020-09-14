package ArraysNStrings;
// https://leetcode.com/problems/median-of-two-sorted-arrays/
public class MedianTwoSortedArrays {

	public static void main(String args[]) {
		MedianTwoSortedArrays medianTwoSortedArrays = new MedianTwoSortedArrays();
		int nums1[] = new int[] { 1, 6, 7 };
		int nums2[] = new int[] { 2, 3, 4, 5, 8, 9 };
		double f = medianTwoSortedArrays.findMedianSortedArraysV0(nums1, nums2);
		System.out.println(f);
		f = medianTwoSortedArrays.findMedianSortedArraysV1(nums1, nums2);
		System.out.println(f);
	}

	public double findMedianSortedArraysV1(int[] nums1, int[] nums2) {
		int[] shortAr = nums1.length > nums2.length ? nums2 : nums1;
		int[] longAr = nums1.length > nums2.length ? nums1 : nums2;
		return findMedianSortedArraysV0(shortAr, 0, shortAr.length - 1, longAr, 0, longAr.length - 1);
	}
 
	public double findMedianSortedArraysV0(int[] nums1, int st1, int ed1, int[] nums2, int st2, int ed2) {
		int size1 = ed1 - st1 + 1;  
		int size2 = ed2 - st2 + 1;
		if (size1 == 0 && size2 == 0) {
			return 0;
		} else if (size1 == 0) {
			return getMedian(nums2, st2, ed2);
		} else if (size1 == 1) {
			if (size2 == 1) {
				return (nums1[st1] + nums2[st2]) / 2.0;
			}
			if (size2 % 2 != 0) { // odd
				return getMedian(nums1[st1], nums2[st2 + size2 / 2 - 1], nums2[st2 + size2 / 2],
						nums2[st2 + size2 / 2 + 1]);
			} else {
				return getMedian(nums1[st1], nums2[st2 + size2 / 2 - 1], nums2[st2 + size2 / 2]);
			}
		} else if (size1 == 2) {
			if (size2 == 2) {
				return getMedian(nums1[st1], nums1[ed1], nums2[st2], nums2[ed2]);
			} else {
				if (size2 % 2 != 0) { // odd
					return getMedian(nums2[st2 + size2 / 2], Math.max(nums1[st1], nums2[st2 + size2 / 2 - 1]),
							Math.min(nums1[ed1], nums2[st2 + size2 / 2 + 1]));
				} else {
					return getMedian(nums2[st2 + size2 / 2], nums2[st2 + size2 / 2 - 1],
							Math.max(nums1[st1], nums2[st2 + size2 / 2 - 2]),
							Math.min(nums1[ed1], nums2[st2 + size2 / 2 + 1]));
				}
			}
		} else {
			boolean isOdd1 = size1 % 2 != 0;
			boolean isOdd2 = size2 % 2 != 0;
			double med1 = getMedian(nums1, st1, ed1);
			double med2 = getMedian(nums2, st2, ed2);
			if (med1 == med2) {
				return med1;
			} else if (med1 > med2) {
				int start1 = st1;
				int end1 = st1 + (size1 / 2);
				int start2 = st2 + (size2 / 2);
				int end2 = ed2;
				if (nums1[end1] < nums2[end2]) {
					for (int i = end1 + 1; i <= ed1; i++) {
						if (nums1[i] < nums2[end2]) {
							end1++;
						}
					}
				}
				if (nums1[start1] < nums2[start2]) {
					for (int i = st2; i < start2; i++) {
						if (nums2[i] < nums1[start1]) {
							start2--;
						}
					}
				}
				int leftCnt1 = ed1 - end1;
				int leftCnt2 = start2 - st2;
				if (leftCnt1 > leftCnt2) {
					end1 = end1 + (leftCnt1 - leftCnt2);
				} else if (leftCnt1 < leftCnt2) {
					start2 = start2 - (leftCnt2 - leftCnt1);
				}
				if (st1 == start1 && ed1 == end1 && st2 == start2 && ed2 == end2) {
					if (nums1[start1] < nums2[start2]) {
						start1++;
					} else {
						start2++;
					}
					if (nums1[end1] < nums2[end2]) {
						end2--;
					} else {
						end1--;
					}
				}
				int currsize1 = end1 - start1 + 1;
				int currsize2 = end2 - start2 + 1;
				if (currsize1 < currsize2) {
					return findMedianSortedArraysV0(nums1, start1, end1, nums2, start2, end2);
				} else {
					return findMedianSortedArraysV0(nums2, start2, end2, nums1, start1, end1);
				}
			} else {
				int start1 = st1 + (size1 / 2);
				int end1 = ed1;
				int start2 = st2;
				int end2 = (isOdd2 ? st2 + (size2 / 2) : st2 + (size2 / 2) - 1);
				if (nums2[end2] < nums1[end1]) {
					for (int i = end2 + 1; i < ed2; i++) {
						if (nums2[i] < nums1[end1]) {
							end2++;
						}
					}
				}
				if (nums2[start2] < nums1[start1]) {
					for (int i = st1; i < start1; i++) {
						if (nums1[i] > nums2[start2]) {
							start1--;
						}
					}
				}
				int leftCnt1 = start1 - st1;
				int leftCnt2 = ed2 - end2;
				if (leftCnt1 > leftCnt2) {
					start1 = start1 - (leftCnt1 - leftCnt2);
				} else if (leftCnt1 < leftCnt2) {
					end2 = end2 + (leftCnt2 - leftCnt1);
				}
				if (st1 == start1 && ed1 == end1 && st2 == start2 && ed2 == end2) {
					if (nums1[start1] < nums2[start2]) {
						start1++;
					} else {
						start2++;
					}
					if (nums1[end1] < nums2[end2]) {
						end2--;
					} else {
						end1--;
					}
				}
				int currsize1 = end1 - start1 + 1;
				int currsize2 = end2 - start2 + 1;
				if (currsize1 < currsize2) {
					return findMedianSortedArraysV0(nums1, start1, end1, nums2, start2, end2);
				} else {
					return findMedianSortedArraysV0(nums2, start2, end2, nums1, start1, end1);
				}
			}
		}
	}

	private double getMedian(int arr[], int st, int ed) {
		int size = ed - st + 1;
		if (size % 2 != 0) {
			return arr[st + (size / 2)];
		} else {
			return (arr[st + (size / 2)] + arr[st + (size / 2) - 1]) / 2.0;
		}
	}

	private double getMedian(int a1, int a2, int a3, int a4) {
		int max = Math.max(a1, Math.max(a2, Math.max(a3, a4)));
		int min = Math.min(a1, Math.min(a2, Math.min(a3, a4)));
		return (a1 + a2 + a3 + a4 - max - min) / 2.0;
	}

	private double getMedian(int a1, int a2, int a3) {
		int max = Math.max(a1, Math.max(a2, a3));
		int min = Math.min(a1, Math.min(a2, a3));
		return (a1 + a2 + a3 - max - min);
	}

	private double findMedianSortedArraysV0(int[] nums1, int[] nums2) {
		int i = 0, j = 0, k = 0;
		int arr[] = new int[nums1.length + nums2.length];
		for (; i < nums1.length && j < nums2.length;) {
			arr[k++] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
		}

		while (i < nums1.length) {
			arr[k++] = nums1[i++];
		}
		while (j < nums2.length) {
			arr[k++] = nums2[j++];
		}
		if (arr.length % 2 != 0) {
			return arr[arr.length / 2];
		} else {
			return (arr[arr.length / 2] + arr[(arr.length / 2) - 1]) / 2.0;
		}
	}

}
