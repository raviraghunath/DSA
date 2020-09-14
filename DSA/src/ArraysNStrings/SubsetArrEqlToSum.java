package ArraysNStrings;

public class SubsetArrEqlToSum {
	public static void main(String[] args) {
		SubsetArrEqlToSum arrEqlToSum = new SubsetArrEqlToSum();
		System.out.println(arrEqlToSum.isSubset(new int[] { 3, 4, 5, 2 }, 11, 0));
		System.out.println(arrEqlToSum.isSubsetDp(new int[] { 3, 4, 5, 2 }, 6));
	}

	private boolean isSubset(int[] arr, int sum, int st) {
		if (sum == 0) {
			return true;
		}
		if (st >= arr.length || sum < 0) {
			return false;
		}
		return isSubset(arr, sum, st + 1) || isSubset(arr, sum - arr[st], st + 1);
	}

	private boolean isSubsetDp(int[] arr, int sum) {
		boolean tab[][] = new boolean[arr.length + 1][sum + 1];

		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[i].length; j++) {
				if (j == 0) {
					tab[i][j] = true;
				} else if (i == 0) {
					tab[i][j] = false;
				} else {
					if (j < arr[i - 1]) {
						tab[i][j] = tab[i - 1][j];
					} else {
						tab[i][j] = tab[i - 1][j] || tab[i - 1][j - arr[i - 1]];
					}
				}
			}
		}
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[i].length; j++) {
				System.out.print((tab[i][j] ? "T" : "F") + " ");
			}
			System.out.println();
		}
		return tab[arr.length][sum];
	}

}
