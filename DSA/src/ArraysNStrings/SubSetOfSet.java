package ArraysNStrings;

import java.util.ArrayList;
import java.util.List;

public class SubSetOfSet {

	public static void main(String[] args) {
		SubSetOfSet subSetOfSet = new SubSetOfSet();
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		subSetOfSet.getSubset(list, new ArrayList<Integer>());
		System.out.println(subSetOfSet.res);
	}

	List<List<Integer>> res = new ArrayList<List<Integer>>();

	void getSubset(List<Integer> list, List<Integer> list1) {
		if (list == null || list.isEmpty()) {
			res.add(list1);
			return;
		}
		Integer i = list.get(0);
		list.remove(0);
		getSubset(new ArrayList<Integer>(list), new ArrayList<Integer>(list1));
		list1.add(i);
		getSubset(new ArrayList<Integer>(list), new ArrayList<Integer>(list1));
	}
}
