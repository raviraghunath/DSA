package ArraysNStrings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class TopKMostFrequentWords {

	static class StringCnt implements Comparable<StringCnt> {
		String s;
		int cnt;

		public StringCnt(String s) {
			this.s = s;
		}

		public void setS(String s) {
			this.s = s;
		}

		@Override
		public int compareTo(StringCnt o) {
			Integer i1 = new Integer(cnt);
			Integer i2 = new Integer(o.cnt);
			if (i1.equals(i2)) {
				return o.s.compareTo(s);
			} else {
				return i1.compareTo(i2);
			}
		}

		@Override
		public String toString() {
			return "[s=" + s + ", cnt=" + cnt + "]";
		}

	}

	public static void main(String[] args) {
		TopKMostFrequentWords kMostFrequentWords = new TopKMostFrequentWords();
		System.out.println(
				kMostFrequentWords.topKFrequent(new String[] { "i", "love", "leetcode", "i", "love", "coding" }, 2));

	}

	public List<String> topKFrequent(String[] words, int k) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String s : words) {
			if (map.containsKey(s)) {
				map.put(s, map.get(s) + 1);
			} else {
				map.put(s, 1);
			}
		}
		System.out.println(map);
		PriorityQueue<StringCnt> priorityQueue = new PriorityQueue<TopKMostFrequentWords.StringCnt>(
				Collections.reverseOrder());
		for (Entry<String, Integer> entry : map.entrySet()) {
			StringCnt stringCnt = new StringCnt(entry.getKey());
			stringCnt.cnt = entry.getValue();
			priorityQueue.add(stringCnt);
		}
		List<String> res = new ArrayList<String>();
		for (int i = 1; i <= k; i++) {
			res.add(priorityQueue.poll().s);
		}
		return res;
	}

}
