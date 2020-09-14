package ArraysNStrings;

public class LargestPlusSign {

	public static void main(String[] args) {
		LargestPlusSign largestPlusSign = new LargestPlusSign();
		System.out.println(largestPlusSign.orderOfLargestPlusSign(5,
				new int[][] { { 1, 0 }, { 1, 4 }, { 2, 4 }, { 3, 2 }, { 4, 0 }, { 4, 3 } }));
	}

	public int orderOfLargestPlusSign(int N, int[][] mines) {
		int[][] ip = new int[N][N];
		for (int i = 0; i < ip.length; i++) {
			for (int j = 0; j < ip[i].length; j++) {
				ip[i][j] = 1;
			}
		}
		for (int i = 0; i < mines.length; i++) {
			ip[mines[i][0]][mines[i][1]] = 0;
		}
		for (int i = 1; i < N - 1; i++) {
			for (int j = 1; j < N - 1; j++) {
				if (ip[i][j] > 0) {
					if (ip[i - 1][j] > 0 && ip[i][j - 1] > 0 && ip[i + 1][j] > 0 && ip[i][j + 1] > 0) {
						ip[i][j] = 2;
					}
				}
			}
		}
		for (int i = 0; i < ip.length; i++) {
			for (int j = 0; j < ip[i].length; j++) {
				System.out.print(ip[i][j]+" "); 
			}
			System.out.println();
		}
		int mLen = 0;
		boolean hack = false;
		boolean isThere1 = false;
		for (int i = 0; i < ip.length; i++) {
			for (int j = 0; j < ip[i].length; j++) {
				if (ip[i][j] == 1) {
					isThere1 = true;
				}
				if (ip[i][j] == 2) {
					hack = true;
					int cLen = getPlusLen(ip, i, j);
					if (cLen > mLen) {
						mLen = cLen;
					}
				}
			}
		}
		if (!hack) {
			if (isThere1) {
				mLen = 1;
			}
		}
		getPlusLen(ip, 1, 2);
		return mLen;
	}

	private int getPlusLen(int[][] arr, int i, int j) {
		int size = 0;
		int i1 = i;
		int j1 = j;
		while (i >= 0) {
			if (arr[i][j] > 0) {
				size++;
			} else {
				break;
			}
			i--;
		}
		int tP = 0;
		i = i1;
		j = j1;
		while (tP < size && j < arr[i1].length) {
			if (arr[i][j] > 0) {
				tP++;
			} else {
				break;
			}
			j++;
		}
		size = tP;
		tP = 0;
		i = i1;
		j = j1;
		while (tP < size && i < arr.length) {
			if (arr[i][j] > 0) {
				tP++;
			} else {
				break;
			}
			i++;
		}
		size = tP;
		tP = 0;
		i = i1;
		j = j1;
		while (tP < size && j >= 0) {
			if (arr[i][j] > 0) {
				tP++;
			} else {
				break;
			}
			j--;
		}
		size = tP;
		return size;
	}

}
