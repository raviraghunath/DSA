package TreesAndGraphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RussianDollEnvelop {

	public static class Envelop implements Comparable<Envelop> {
		int w;
		int h;

		Envelop(int w, int h) {
			this.w = w;
			this.h = h;
		}

		@Override
		public int compareTo(Envelop o) {
			int res = this.w - o.w;
			if (res == 0)
				res = this.h - o.h;
			return res;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + h;
			result = prime * result + w;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Envelop other = (Envelop) obj;
			if (h != other.h)
				return false;
			if (w != other.w)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "[w=" + w + ", h=" + h + "]";
		}

	}

	public static void main(String[] args) {
		RussianDollEnvelop russianDollEnvelop = new RussianDollEnvelop();
		System.out.println(russianDollEnvelop.maxEnvelopes(new int[][] { { 5, 4 }, { 6, 4 }, { 6, 7 }, { 2, 3 } }));
//		System.out.println(russianDollEnvelop.maxEnvelopes(new int[][] { { 8, 8 }, { 19, 18 }, { 14, 14 }, { 18, 8 },
//			{ 20, 14 }, { 14, 6 }, { 3, 4 }, { 14, 1 } }));
	}

	public int maxEnvelopes(int[][] envelopes) {
		List<Envelop> envelops = new ArrayList<Envelop>();
		for (int i = 0; i < envelopes.length; i++) {
			Envelop envelop = new Envelop(envelopes[i][0], envelopes[i][1]);
			envelops.add(envelop);
		}
		Collections.sort(envelops);
		Map<Integer, Map<Envelop, Integer>> map = new HashMap<Integer, Map<Envelop, Integer>>();
		System.out.println(maxEnvelopes(envelops, 0, null, map));
		return maxEnvelopesV1(envelops);
	}

	public int maxEnvelopesV1(List<Envelop> envelops) {
		if(envelops.size()==0) {
			return 0;
		}
		int[] dp = new int[envelops.size()];
		Arrays.fill(dp, 1);
		int ans = 1;
		for (int i = 0; i < dp.length; i++) {
			for (int j = i + 1; j < dp.length; j++) {
				if (envelops.get(i).w < envelops.get(j).w && envelops.get(i).h < envelops.get(j).h) {
					dp[j] = Math.max(dp[i] + 1, dp[j]);
					ans = Math.max(ans, dp[j]);
				}
			}
		}
		return ans;
	}

	public int maxEnvelopes(List<Envelop> envelops, int pos, Envelop prev, Map<Integer, Map<Envelop, Integer>> cache) {

		Map<Envelop, Integer> prevMap = cache.get(pos);
		if (prevMap != null) {
			Integer cVal = prevMap.get(prev);
			if (cVal != null) {
				return cVal;
			}
		}
		int currMax = 0;
		for (int i = pos; i < envelops.size(); i++) {
			Envelop currEnvelop = envelops.get(i);
			if (prev == null || (currEnvelop.w > prev.w && currEnvelop.h > prev.h)) {
				currMax = Math.max(currMax, 1 + maxEnvelopes(envelops, i + 1, currEnvelop, cache));
			}
		}
		if (prevMap == null) {
			prevMap = new HashMap<Envelop, Integer>();
			cache.put(pos, prevMap);
		}
		int res = currMax;
		prevMap.put(prev, res);
		return res;
	}

}
