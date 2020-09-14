package ArraysNStrings;

import java.util.ArrayList;
import java.util.List;

public class KnapSack {

	private static class Bag {
		int weight;
		int val;

		public Bag(int weight, int val) {
			this.weight = weight;
			this.val = val;
		}
	}

	public static void main(String[] args) {
		KnapSack knapSack = new KnapSack();
		List<Bag> bags = new ArrayList<KnapSack.Bag>();
		bags.add(new Bag(1, 6));
		bags.add(new Bag(2, 10));
		bags.add(new Bag(3, 12));
		System.out.println(knapSack.getOptimal(bags, 0, 5));
	}

	private int getOptimal(List<Bag> bags, int pos, int x) {
		if (x == 0) {
			return 0;
		}
		if (pos >= bags.size() || x < 0) {
			return -1;
		}
		int res1 = getOptimal(bags, pos + 1, x);
		int res2 = getOptimal(bags, pos + 1, x - bags.get(pos).weight);
		if (res2 != -1) {
			res2 += bags.get(pos).val;
		}
		return Math.max(res1, res2);
	}

}
