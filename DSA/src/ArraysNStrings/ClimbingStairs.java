package ArraysNStrings;
//https://leetcode.com/problems/climbing-stairs/submissions/
public class ClimbingStairs {
	public static void main(String args[]) {
		ClimbingStairs climbingStairs = new ClimbingStairs();
		System.out.println(climbingStairs.climbStairs(5));
		System.out.println(climbingStairs.climbStairsV1(5));
	}

	public int climbStairs(int n) {
		if (n <= 0) {
			return 0;
		} else if (n == 1) {
			return 1;

		} else if (n == 2) {
			return 2;

		}
		int arr[] = new int[n];
		arr[0] = 1;
		arr[1] = 2;
		for (int i = 2; i < n; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}
		return arr[n - 1];
	}

	public int climbStairsV1(int n) {
		if (n <= 0) {
			return 0;
		} else if (n == 1) {
			return 1;

		} else if (n == 2) {
			return 2;

		}
		int p1 = 1;
		int p2 = 2;
		int p3 = p2;
		for (int i = 2; i < n; i++) {
			p3 = p2 + p1;
			p1 = p2;
			p2 = p3;
		}
		return p3;
	}
}
