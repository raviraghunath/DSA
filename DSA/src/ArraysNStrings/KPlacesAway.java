//https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away/
package ArraysNStrings;

public class KPlacesAway {

	public static void main(String[] args) {
		KPlacesAway kPlacesAway = new KPlacesAway();
		System.out.println(kPlacesAway.kLengthApart(new int[] { 1, 0, 0, 1, 0, 1 }, 2));

	}

	public boolean kLengthApart(int[] nums, int k) {
//		Set<Integer> set = new HashSet<Integer>();
		int i = 0;
		int gapEd = -1;
		while (i < nums.length) {
			if (nums[i] == 1) {
				if (gapEd == -1) {
					gapEd = i + k;
				} else {
					if (i <= gapEd) {
						return false;
					} else {
						gapEd = i + k;
					}
				}
			}
			i++;
		}
		return true;
	}
}
