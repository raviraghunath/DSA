package ArraysNStrings;

public class MinFlips {

	public static void main(String[] args) {
		MinFlips minFlips = new MinFlips();
		System.out.println(minFlips.minFlipsV1("1010"));
		System.out.println(minFlips.minFlips("1010"));
	}

	public int minFlipsV1(String target) {
		char prev = target.charAt(target.length() - 1);
		int res = 0;
		for (int i = target.length() - 2; i >= 0; i--) {
			char curr = target.charAt(i);
			if (curr == target.charAt(i + 1)) {
			} else if (curr != prev) {
				if (curr == '1' && prev == '0') {
					res += 2;
				} else {
					res += 1;
				}
				prev = '0';
			}
			if (i == 0 && curr == prev) {
				res += curr == '0' ? 0 : 1;
			}

		}

		return res;
	}

	public int minFlips(String target) {
		char[] str = target.toCharArray();
		int result = 0;
		char prev = '0';

		for (int i = 0; i < str.length; i++) {
			if (str[i] != prev) {
				prev = str[i];
				result++;
			}
		}
		return result;
	}
}
