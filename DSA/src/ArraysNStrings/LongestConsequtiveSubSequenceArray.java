package ArraysNStrings;

import java.util.HashSet;
import java.util.Set;

public class LongestConsequtiveSubSequenceArray {
	public static void main(String[] args) {
		LongestConsequtiveSubSequenceArray longestConsequtiveSubSequenceArray = new LongestConsequtiveSubSequenceArray();
		System.out.println(longestConsequtiveSubSequenceArray.getLongestConsequtiveSubSequence(new int[] { 2, 1, 6, 9, 4, 3 }));
	}

	private int getLongestConsequtiveSubSequence(int arr[]) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < arr.length; i++) { 
			set.add(arr[i]);
		}
		int mxCnt = 0;
		for (int ele : set) {
			int currSt = ele;
			while (set.contains(currSt - 1)) {
				currSt = currSt - 1;
			}
			int cnt = 0; 
			while (set.contains(currSt)) {
				cnt++;
//				set.remove(currSt);
				currSt++;
			}
			if (mxCnt < cnt) {
				mxCnt = cnt;
			}
		}
		return mxCnt;
	}
}
