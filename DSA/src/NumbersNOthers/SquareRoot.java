package NumbersNOthers;

public class SquareRoot {

	public static void main(String[] args) {
		SquareRoot squareRoot = new SquareRoot();
		System.out.println(squareRoot.getSqrt(2));
	}

	private double getSqrt(double n) {
		double i = 1;
		while (true) {
			double m = i * i;
			if (m == n) {
				break;
			}
			if (m > n) {
				i = getSquare(n, i - 1, i);
				break;
			}
			i++;
		}
		return i;
	}

	private double getSquare(double n, double i, double j) {
		double mid = (i + j) / 2;
		double m = mid * mid;
		if (m == n || (Math.abs(m - n) <= 0.001)) {
			return mid;
		} else if (m < n) {
			return getSquare(n, mid, j);
		} else {
			return getSquare(n, i, mid);
		}
	}
}
