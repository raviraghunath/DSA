package NumbersNOthers;
//Incomplete
public class Divide2Integer {

	public static void main(String[] args) {
		Divide2Integer divide2Integer = new Divide2Integer();
		System.out.println(divide2Integer.divide(-2147483648, 1));

	}

	public int divide(int dividend, int divisor) {
		if (divisor == 0) {
			throw new IllegalArgumentException();
		}
		if (dividend == 0) {
			return 0;
		}
		boolean isResPositive = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0) ? true : false;
		dividend =  Math.abs(dividend);
		divisor = Math.abs(divisor);
		if (divisor == 1) {
			return isResPositive ? dividend : 0 - dividend;
		}
		int pdt = divisor;
		int cnt = 1;
		while (pdt <= dividend) {
			pdt += divisor;
			cnt++;
		}
		if (pdt > dividend) {
			cnt--;
		}
		return isResPositive ? cnt : 0 - cnt;
	}

}
