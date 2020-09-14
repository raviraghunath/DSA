//https://leetcode.com/problems/compare-version-numbers/
package NumbersNOthers;

public class CompareVersionNumbers {

	public static void main(String[] args) {
		CompareVersionNumbers compareVersionNumbers = new CompareVersionNumbers();
		System.out.println(compareVersionNumbers.compareVersion("7.5.2.4", "7.5.3"));
	}

	public int compareVersion(String version1, String version2) {
		double i1 = getValue(version1);
		double i2 = getValue(version2);

		return i1 > i2 ? 1 : i1 < i2 ? -1 : 0;
	}

	private double getValue(String version) {
		double val = 0.0;
		String t = "";
		double stg = 1.0;
		for (int i = 0; i < version.length(); i++) {
			char c = version.charAt(i);
			if (c != '.') {
				t += c;
			} else {
				int cVal = Integer.parseInt(t);
				val += (cVal / stg);
				stg *= 10;
				t = "";
			}
		}
		if (!t.equals("")) {
			int cVal = Integer.parseInt(t);
			val += (cVal / stg);
			stg *= 10;
			t = "";
		}
		return val;
	}

}
