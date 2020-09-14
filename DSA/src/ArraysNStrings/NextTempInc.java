//https://www.geeksforgeeks.org/count-of-days-remaining-for-the-next-day-with-higher-temperature/?ref=leftbar-rightbar
package ArraysNStrings;

import java.util.Stack;

public class NextTempInc {

	public static void main(String[] args) {
		NextTempInc nextTempInc = new NextTempInc();
		int res[] = nextTempInc.nextDayInc(new int[] { 89, 62, 70, 58, 47, 47, 46, 76, 100, 70 });
		Solution.printArr(res);
	}

	private int[] nextDayInc(int arr[]) {
		Stack<Integer> valStack = new Stack<Integer>();
		Stack<Integer> indStack = new Stack<Integer>();
		int i = 0;
		int res[] = new int[arr.length];
		while (i < arr.length) {
			if (valStack.isEmpty() || arr[i] <= valStack.peek()) {
				valStack.push(arr[i]);
				indStack.push(i);
				i++;
			} else {
				valStack.pop();
				int j = indStack.pop();
				res[j] = i - j;
			}
		}
		while (!indStack.isEmpty()) {
			res[indStack.pop()] = -1;
		}
		return res;
	}

}
