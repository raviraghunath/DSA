package ArraysNStrings;

import java.util.Collections;
import java.util.PriorityQueue;

public class MagicalCandy {

	public static void main(String[] args) {
		MagicalCandy magicalCandy =new MagicalCandy();
		System.out.println(magicalCandy.maxCandies(new int[] {19, 78, 76, 72, 48, 8, 24, 74, 29}, 3));
	}

	int maxCandies(int[] arr, int k) {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
		for (int i = 0; i < arr.length; i++) {
			priorityQueue.add(arr[i]);
		}
		int i = 0;
		int cnt = 0;
		while (i < k) {
			int t = priorityQueue.poll();
			cnt += t;
			priorityQueue.add(t / 2);
			i++;
		}
		return cnt;
	}
}
