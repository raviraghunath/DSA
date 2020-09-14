//https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/
package ArraysNStrings;

import java.util.Arrays;

public class CakeMaxArea {

	public static void main(String[] args) {
		CakeMaxArea cakeMaxArea = new CakeMaxArea();
		System.out.println(cakeMaxArea.maxArea(5, 4, new int[] { 3, 1 }, new int[] { 1 }));

	}

	public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
		Arrays.sort(horizontalCuts);
		Arrays.sort(verticalCuts);

		long maxH = Math.max(horizontalCuts[0], h - horizontalCuts[horizontalCuts.length - 1]);
		long maxW = Math.max(verticalCuts[0], w - verticalCuts[verticalCuts.length - 1]);
		long mod = 1000000007;
				
		for (int i = 1; i < horizontalCuts.length; i++) {
			maxH = Math.max(maxH, horizontalCuts[i] - horizontalCuts[i - 1]);
		}

		for (int i = 1; i < verticalCuts.length; i++) {
			maxW = Math.max(maxW, verticalCuts[i] - verticalCuts[i - 1]);
		}

		return (int) (((maxH % mod) * (maxW % mod))%mod);

	}

}
