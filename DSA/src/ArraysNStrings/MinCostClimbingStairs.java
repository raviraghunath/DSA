package ArraysNStrings;
//https://leetcode.com/problems/min-cost-climbing-stairs/
public class MinCostClimbingStairs {

	public static void main(String args[]) {
		MinCostClimbingStairs climbingStairs = new MinCostClimbingStairs();
		int cost = climbingStairs.minCostClimbingStairs(new int[] { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 });
		System.out.println(cost);
	}

	public int minCostClimbingStairs(int[] cost) {
		if (cost == null) {
			return 0;
		} else if (cost.length == 1) {
			return cost[0];
		} else if (cost.length == 2) {
			return cost[1];
		} else {
			int c1 = cost[0];
			int c2 = cost[1];
			int c3 = c2;
			for (int i = 2; i < cost.length; i++) {
				c2 = c3;
				int t1 = c2 + cost[i];
				int t2 = c1 + cost[i];
				c3 = t1 < t2 ? t1 : t2;
				c1 = c2;
			}
			return c3 < c2 ? c3 : c2;
		}
	}

}
