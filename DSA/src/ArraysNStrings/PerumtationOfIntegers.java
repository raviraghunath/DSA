package ArraysNStrings;

import java.util.ArrayList;
import java.util.List;

public class PerumtationOfIntegers {

	public static void main(String[] args) {
		PerumtationOfIntegers integers = new PerumtationOfIntegers();
		System.out.println(integers.permute(new int[] { 1, 2, 3 }));
	}
 
	public List<List<Integer>> permute(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		permute(nums, 0);
		return list;
	}

	List<List<Integer>> list = new ArrayList<List<Integer>>();

	public void permute(int[] nums, int pos) {
		if (pos == nums.length - 1) {
			List<Integer> list2 = new ArrayList<Integer>();
			for (int num : nums) {
				list2.add(num);
			}
			list.add(list2);
			return;
		}
		for (int i = pos; i < nums.length; i++) {
			permute(swap(nums, pos, i), pos + 1);
		}
	}

	private int[] swap(int[] nums, int i, int j) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
		return nums.clone();
	}

}
