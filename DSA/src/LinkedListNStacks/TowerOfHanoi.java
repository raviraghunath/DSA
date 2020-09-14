package LinkedListNStacks;

import java.util.Stack;

public class TowerOfHanoi {
	public static void main(String[] args) {
		TowerOfHanoi hanoi = new TowerOfHanoi();
		Stack<Integer> origin = new Stack<Integer>();
		origin.push(5);
		origin.push(4);
		origin.push(3);
		origin.push(2);
		origin.push(1);
		Stack<Integer> buffer = new Stack<Integer>();
		Stack<Integer> destination = new Stack<Integer>();
		hanoi.move(5, origin, buffer, destination);
	}

	private void move(int n, Stack<Integer> origin, Stack<Integer> buffer, Stack<Integer> destination) {
		if (origin.isEmpty() || n <= 0) {
			return;
		}
		move(n - 1, origin, destination, buffer);
		destination.push(origin.pop());
		move(n - 1, buffer, origin, destination);
	}

}
