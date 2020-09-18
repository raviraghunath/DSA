package ArraysNStrings;

public class Kandane {

	public static void main(String[] args) {
		Kandane kandane = new Kandane();
		kandane.findLargestSubArrSum(new int[] { -8, 7, -2, 2, 6 });
	}

	private void findLargestSubArrSum(int[] arr) {
		int currMax = arr[0], maxGlobal = arr[0];
		for (int i = 1; i < arr.length; i++) {
			currMax = Math.max(arr[i], currMax + arr[i]);
			maxGlobal = Math.max(currMax, maxGlobal);
		}
		System.out.println(maxGlobal);
	}

}
