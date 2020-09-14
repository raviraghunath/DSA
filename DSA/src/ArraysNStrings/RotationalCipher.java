package ArraysNStrings;

public class RotationalCipher {

	public static void main(String[] args) {
		RotationalCipher rotationalCipher = new RotationalCipher();
		String s = rotationalCipher.rotationalCipher("abcdZXYzxy-999.@", 200);
		System.out.println(s);
	}

	String rotationalCipher(String input, int rotationFactor) {
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c >= 48 && c <= 57) {
				c = (char) (c + (rotationFactor % 10));
				if (c > 57) {
					int diff = (c - 57) % 10;
					c = (char) (47 + diff);
				}
			} else if (c >= 65 && c <= 90) {
				c = (char) (c + (rotationFactor % 26));
				if (c > 90) {
					int diff = (c - 90) % 26;
					c = (char) (64 + diff);
				}
			} else if (c >= 97 && c <= 122) {
				c = (char) (c + (rotationFactor % 26));
				if (c > 122) {
					int diff = (c - 122) % 26;
					c = (char) (96 + diff);
				}
			}
			res.append(c);
		}
		return res.toString();
	}

}
