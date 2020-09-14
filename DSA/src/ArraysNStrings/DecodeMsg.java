package ArraysNStrings;

import java.util.HashMap;
import java.util.Map;

public class DecodeMsg {

	public static void main(String[] args) {
		DecodeMsg decodeMsg = new DecodeMsg();
		System.out.println(decodeMsg.countWays("1234"));
	}

	private int countWays(String data) {
		Map<String, Integer> cache = new HashMap<String, Integer>();
		int res =  countWays(data, cache);
		return res;
	}

	private int countWays(String data, Map<String, Integer> cache) {
		Integer cacheval = cache.get(data);
		if (cacheval != null) {
			return cacheval;
		}
		if (data == null || data.length() == 0) {
			return 1;
		}
		int i = 0;
		int maxCnt = 0;
		while (i < data.length()) {
			String s1 = data.substring(0, i + 1);
			int val = Integer.parseInt(s1);
			if (val >= 1 && val <= 26) {
				String s2 = data.substring(i + 1);
				int currCnt = countWays(s2,cache);
				maxCnt += currCnt;
			} else {
				break;
			}
			i++;

		}
		cache.put(data, maxCnt);
		return maxCnt;
	}

}
