package BitManupilation;

public class FindFirstNonRep {
	public static void main(String[] args) {
		FindFirstNonRep findFirstNonRep = new FindFirstNonRep();
		System.out.println(findFirstNonRep.findDupIndex(new int[] { 2, 3, 2, 3, 4, 5, 6, 6, 5 }));

	}

	private int findDupIndex(int[] arr) {
		int tot = 0;
		for (int i = 0; i < arr.length; i++) {
			tot = tot ^ arr[i];
		}
		return tot;
	}

}
