package ArraysNStrings;

public class DistinctSubsequences {

	public static void main(String[] args) {
		DistinctSubsequences distinctSubsequences = new DistinctSubsequences();
		System.out.println(distinctSubsequences.numDistinct("bccbcdcabadabddbccaddcbabbaaacdba", "bccbbdc"));
	}

	// ""
	// ""

	public int numDistinct(String s, String t) {
		numDistinct(s, t, "");
		return cnt;
	}

	int cnt;

	public void numDistinct(String s, String t, String ans) {
		if (s.length() < t.length()) {
			return;
		}
		if (s.length() == 0) {
			if (ans.equals(t)) {
				cnt++;
			}
			return;
		}
		numDistinct(s.substring(1), t, ans + s.charAt(0));
		numDistinct(s.substring(1), t, ans);
	}

}
