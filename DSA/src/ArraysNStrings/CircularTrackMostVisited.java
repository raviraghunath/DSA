package ArraysNStrings;

import java.util.ArrayList;
import java.util.List;

public class CircularTrackMostVisited {

	public static void main(String[] args) {
		CircularTrackMostVisited circularTrackMostVisited = new CircularTrackMostVisited();
		System.out.println(circularTrackMostVisited.mostVisited(2, new int[] { 2, 1, 2, 1, 2, 1, 2, 1, 2 }));
	}

	public List<Integer> mostVisited(int n, int[] rounds) {
		int res[] = new int[n + 1];
		int ptr = rounds[0];
		res[rounds[0]] = 1;
		int max = 1;
		for (int i = 1; i < rounds.length; i++) {
			int steps = 0;
			if (rounds[i] < ptr) {
				steps = rounds[i] + (n - ptr);
			} else {
				steps = rounds[i] - ptr;
			}
			int k = 1;
			while (k <= steps) {
				int index = ptr + k;
				if (index > res.length - 1) {
					index = index - res.length + 1;
				}
				res[index] = res[index] + 1;
				max = Math.max(max, res[index]);
				k++;
			}
			ptr = rounds[i];
		}
		List<Integer> ret = new ArrayList<Integer>();
		for (int i = 1; i < res.length; i++) {
			if (res[i] == max) {
				ret.add(i);
			}
		}
		return ret;
	}

}
