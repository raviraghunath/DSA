package ArraysNStrings;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class KMostFrequentElementsArray {

	public static void main(String[] args) {
		KMostFrequentElementsArray kMostFrequentElementsArray = new KMostFrequentElementsArray();
		// Solution.printArr(kMostFrequentElementsArray.topKFrequent(new int[] { 1, 1,
		// 1, 2, 2, 3 }, 2));
		System.out.println(kMostFrequentElementsArray.findKthLargest(new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 }, 4));

	}

	public int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			freq.put(nums[i], freq.containsKey(nums[i]) ? freq.get(nums[i]) + 1 : 1);
		}
		System.out.println("freq: " + freq);
		Map<Integer, Set<Integer>> res = new TreeMap<Integer, Set<Integer>>(Collections.reverseOrder());

		for (Entry<Integer, Integer> entry : freq.entrySet()) {
			int nK = entry.getValue();
			if (res.containsKey(nK)) {
				res.get(nK).add(entry.getKey());
			} else {
				Set<Integer> set = new HashSet<Integer>();
				set.add(entry.getKey());
				res.put(nK, set);
			}
		}
		int[] topK = new int[k];
		int i = 0;
		for (Entry<Integer, Set<Integer>> entry : res.entrySet()) {
			for (int inte : entry.getValue()) {
				if (i >= k) {
					break;
				}
				topK[i] = inte;
				i++;
			}
		}

		return topK;
	}

	public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int cnt = 1;
        for(int i = nums.length-1;i>=0;i--){
            if(cnt==k){
                return nums[i];
            }else{
                cnt++;
            }
        }
        return -1;
    }
}
