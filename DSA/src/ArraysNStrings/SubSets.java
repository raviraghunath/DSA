package ArraysNStrings;

import java.util.ArrayList;
import java.util.List;

public class SubSets {

	public static void main(String[] args) {
		SubSets subSets = new SubSets();
		System.out.println(subSets.subsets(new int[] { 1, 2, 3 }));

	}

	public List<List<Integer>> subsets(int[] nums) {
		return subsets(nums, 0, new ArrayList<Integer>());
	}

	public List<List<Integer>> subsets(int[] nums, int pos, List<Integer> list) {
		if (pos == nums.length) {
			List<List<Integer>> res = new ArrayList<List<Integer>>();
			res.add(list);
			return res;
		}
		List<List<Integer>> res = new ArrayList<List<Integer>>();

		List<Integer> res1 = new ArrayList<Integer>();
		res1.addAll(list);
		res1.add(nums[pos]);
		res.addAll(subsets(nums, pos + 1, res1));

		List<Integer> res2 = new ArrayList<Integer>();
		res2.addAll(list);
		res.addAll(subsets(nums, pos + 1, res2));

		return res;

	}

}
