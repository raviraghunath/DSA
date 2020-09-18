package ArraysNStrings;

import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentSkipListMap;

public class MakeArrayUnique {

	public static void main(String[] args) {
		MakeArrayUnique makeArrayUnique = new MakeArrayUnique();
		System.out.println(makeArrayUnique.minIncrementForUnique(new int[] { 2, 2, 2, 1 }));

	}

	public int minIncrementForUnique(int[] A) {
		if (A == null || A.length==0) {
			return 0;
		}
		int min = A[0];
		int max = A[0];
		for (int i = 1; i < A.length; i++) {
			if (A[i] < min) {
				min = A[i];
			} else if (A[i] > max) {
				max = A[i];
			}
		}

		int len = max - min + 1;
		int tab[] = new int[len];
		int remSizeNeeded = 0;
		for (int i = 0; i < A.length; i++) {
			if (tab[A[i] - min] != 0) {
				remSizeNeeded++;
			}
			tab[A[i] - min] = tab[A[i] - min] + 1;
		}

		int fTab[] = new int[len + remSizeNeeded];
		for (int i = 0; i < tab.length; i++) {
			fTab[i] = tab[i];
		}
		int res = 0;
		for (int i = 0; i < fTab.length; i++) {
			int count = fTab[i];
			int val = i + min;
			if (count > 1) {
				while (count != 1) {
					int newVal = val + 1;
					while (fTab[newVal - min] > 0) {
						newVal++;
					}
					fTab[i] = fTab[i] - 1;
					fTab[newVal - min] = 1;
					res += (newVal - val);
					count--;
				}
			}
		}
		return res;
	}

	public int minIncrementForUniqueV1(int[] A) {
		Map<Integer, Integer> treeMap = new ConcurrentSkipListMap<Integer, Integer>();
		for (int i = 0; i < A.length; i++) {
			if (treeMap.containsKey(A[i])) {
				treeMap.put(A[i], treeMap.get(A[i]) + 1);
			} else {
				treeMap.put(A[i], 1);
			}
		}
		int res = 0;
		for (Entry<Integer, Integer> entry : treeMap.entrySet()) {
			int val = entry.getKey();
			int count = entry.getValue();
			if (count > 1) {
				while (count != 1) {
					int newVal = val + 1;
					while (treeMap.containsKey(newVal)) {
						newVal++;
					}
					treeMap.put(newVal, 1);
					treeMap.put(val, treeMap.get(A[val]) - 1);
					res += (newVal - val);
					count--;
				}
			}
		}
		return res;
	}

}
