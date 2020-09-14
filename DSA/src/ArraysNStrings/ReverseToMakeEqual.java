//Given two arrays A and B of length N, determine if there is a way to make A equal to B by reversing any subarrays from array B any number of times.
//Signature
//bool areTheyEqual(int[] arr_a, int[] arr_b)
//Input
//All integers in array are in the range [0, 1,000,000,000].
//Output
//Return true if B can be made equal to A, return false otherwise.
//Example
//A = [1, 2, 3, 4]
//B = [1, 4, 3, 2]
//output = true
//After reversing the subarray of B from indices 1 to 3, array B will equal array A.
package ArraysNStrings;

public class ReverseToMakeEqual {

	public static void main(String[] args) {
		ReverseToMakeEqual reverseToMakeEqual = new ReverseToMakeEqual();
		System.out.println(reverseToMakeEqual.areTheyEqual(new int[] { 1, 2, 3, 4 }, new int[] { 1, 4, 3, 3 }));
	}

	boolean areTheyEqual(int[] array_a, int[] array_b) {
		if (array_a == null || array_b == null || array_a.length != array_b.length) {
			return false;
		}
		for (int i = 0; i < array_a.length; i++) {
			if (array_a[i] == array_b[i]) {

			} else {
				int j = findIndex(array_b, array_a[i], i);
				if(j==-1) {
					return false;
				}
				int tempi = i;
				int tempj = j;
				while (tempi <= j && tempj >= i) {
					if (array_a[tempi] == array_b[tempj]) {
						tempi++;
						tempj--;
					}
				}
				tempi--;
				tempj++;
				if (tempi <= j && tempj >= i) {
					i = j;
				} else {
					return false;
				}
			}
		}
		return true;
	}

	private int findIndex(int[] arr, int val, int st) {
		for (int i = st + 1; i < arr.length; i++) {
			if (arr[i] == val) {
				return i;
			}
		}
		return -1;
	}
}
