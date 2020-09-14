//https://leetcode.com/problems/reveal-cards-in-increasing-order/solution/
package NumbersNOthers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import ArraysNStrings.Solution;

public class CardsInIncreasingOrder {
	public static void main(String[] args) {
		CardsInIncreasingOrder cardsInIncreasingOrder = new CardsInIncreasingOrder();
		Solution.printArr(cardsInIncreasingOrder.deckRevealedIncreasing(new int[] { 17, 13, 11, 2, 3, 5, 7 }));
	}

	public int[] deckRevealedIncreasing(int[] deck) {
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < deck.length; i++) {
			queue.add(i);
		}
		int[] res = new int[deck.length];
		Arrays.sort(deck);
		for (int i : deck) {
			res[queue.poll()] = i;
			if (!queue.isEmpty()) {
				queue.add(queue.poll());
			}
		}
		return res;
	}
}