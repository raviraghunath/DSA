package ArraysNStrings;

public class PermutationsOfString {
	public static void main(String[] args) {
		PermutationsOfString permutationsOfString = new PermutationsOfString();
		permutationsOfString.printPerumtationOfString("manoj", 0);

	} 

	private void printPerumtationOfString(String s, int pos) {
		if (s == null || s.length() == 0) {
			return;
		}
		if (pos == s.length() - 1) {
			System.out.print(s+",");
			return;
		}
		for (int i = pos; i < s.length(); i++) {
			printPerumtationOfString(swapChar(s, pos, i), pos + 1);
		}
	}

	private String swapChar(String s, int i, int j) {
		if(i==j) {
			return s;
		}
		char[] charArr = s.toCharArray();
		char t = charArr[i];
		charArr[i] = charArr[j];
		charArr[j] = t;
		return new String(charArr);
	}
}
