package ArraysNStrings;

public class BeautifulArrangement {

	public static void main(String[] args) {
		BeautifulArrangement beautifulArrangement = new BeautifulArrangement();
		Solution.printArr(beautifulArrangement.constructArray(3, 2));

	}

	public int[] constructArray(int n, int k) {
		if (k >= n) {
			return null;
		}
		int res[] = new int[n];
		int mid = n - (k + 1);

		for (int i = 0; i < mid; i++) {
			res[i] = i + 1;
		}
		int j = 0;
		int nn = n;
		int nm = mid;
		for (int i = mid; i < res.length; i++) {
			if (j % 2 == 0) {
				res[i] = nm + 1;
				nm++;
			} else {
				res[i] = nn--;
			}
			j++;
		}
		return res;
	}

}
