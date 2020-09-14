package ArraysNStrings;

public class TrappingRainWater {

	public static void main(String[] args) {
		TrappingRainWater rainWater = new TrappingRainWater();
		System.out.println(rainWater.getTrappedRainWaterQty(
				new int[] { 6, 4, 2, 0, 3, 2, 0, 3, 1, 4, 5, 3, 2, 7, 5, 3, 0, 1, 2, 1, 3, 4, 6, 8, 1, 3 }));
	}

	private int getTrappedRainWaterQty(int a[]) {
		if (a == null || a.length < 3) {
			return 0;
		}
		int left = 0;
		int right = a.length - 1;
		int lMax = 0;
		int rMax = 0;
		int wtrCnt = 0;

		while (left < right) {
			lMax = lMax > a[left] ? lMax : a[left];
			rMax = rMax > a[right] ? rMax : a[right];
			if (lMax > rMax) {
				wtrCnt = wtrCnt + (rMax - a[right]);
				right--;
			} else {
				wtrCnt = wtrCnt + (lMax - a[left]);
				left++;
			}
		}
		return wtrCnt;
	}

//	if (a == null || a.length <= 2) {
//		return 0;
//	}
//	Stack<Integer> st = new Stack<Integer>();
//	int wtrCnt = 0;
//	for (int ind = 0; ind < a.length; ind++) {
//		if (st.isEmpty()) {
//			st.push(a[ind]);
//		} else if (st.size() == 1 && st.peek() <= a[ind]) {
//			st.pop();
//			st.push(a[ind]);
//		} else if (st.peek() >= a[ind]) {
//			st.add(a[ind]);
//		} else { // st.peek() < a[ind]
//			int rtWl = a[ind];
//			int i = st.peek();
//			int x = 0;
//			while (!st.isEmpty() && i == st.peek()) {
//				st.pop();
//				x++;
//			}
//			int ltWl = st.isEmpty() ? 0 : st.peek();
//			int currwtrCnt = x * ((ltWl > rtWl) ? Math.abs(i - rtWl) : Math.abs(i - ltWl));
//			int j = 1;
//			while (j <= x) {
//				st.add(ltWl > rtWl ? rtWl : ltWl);
//				j++;
//			}
//			st.add(a[ind]);
//			wtrCnt += currwtrCnt;
//		}
//	}
//	if (!st.isEmpty()) {
//		int lEle = st.pop();
//		while (!st.isEmpty() && st.peek() >= lEle) {
//			lEle = st.pop();
//		}
//		st.push(lEle);
//		int i1 = 0;
//		Integer nArr[] = new Integer[st.size()];
//		nArr = st.toArray(nArr);
//		int nA[] = new int[nArr.length];
//		for(Integer ik : nArr) {
//			nA[i1++] = ik;
//		}
//		wtrCnt += getTrappedRainWaterQty(nA);
//	}
//
//	return wtrCnt;
}
