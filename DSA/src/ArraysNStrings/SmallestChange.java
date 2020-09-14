//https://www.youtube.com/watch?time_continue=4&v=qH7fVuYlOOc&feature=emb_logo
package ArraysNStrings;

public class SmallestChange {

	public static void main(String[] args) {
		SmallestChange change = new SmallestChange();
		int[] coins = new int[] { 1, 2, 5, 10 };
		int amount = 18;
		int[][] cache = new int[amount + 1][coins.length];
		System.out.println(change.getSmallestChange(coins, 0, 0, amount, cache));

	}

	private int getSmallestChange(int arr[], int index, int cnt, int N, int[][] cache) {
		if (N == 0) {
			return cnt;
		}
		if (N < 0 || index >= arr.length) {
			return -1;
		}
		int cVal = cache[N][index];
		if (cVal != 0) {
//			return cVal;
		}
		int minCnt = Integer.MAX_VALUE;
		for (int i = 0; i <= N / arr[index]; i++) {
			int currRes = getSmallestChange(arr, index + 1, cnt + i, N - (i * arr[index]), cache);
			if (currRes != -1 && currRes < minCnt) {
				minCnt = currRes;
			}
		}
		int res = minCnt == Integer.MAX_VALUE ? -1 : minCnt;
		cache[N][index] = res;
		return res;
	}

}
