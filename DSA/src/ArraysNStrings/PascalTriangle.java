package ArraysNStrings;

public class PascalTriangle {
	public static void main(String[] args) {
		PascalTriangle pascalTriangle = new PascalTriangle();
		pascalTriangle.printPT(7);
	}

	private void printPT(int n) {
		int st = n / 2;
		int ed = st;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (st <= j && j <= ed) {
					System.out.print("* ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
			st = (i + 1) > n / 2 ? st + 1 : st - 1;
			ed = (i + 1) > n / 2 ? ed - 1 : ed + 1;
		}
		System.out.println("-------------------------");
	}

	private void print(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		System.out.println("-------------------------");
		int k = n - 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (k <= j) {
					System.out.print("* ");
				} else {
					System.out.print("  ");
				}
			}
			k--;
			System.out.println();
		}
		System.out.println("-------------------------");
		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		System.out.println("-------------------------");
		k = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j >= k) {
					System.out.print("* ");
				} else {
					System.out.print("  ");
				}
			}
			k++;
			System.out.println();
		}
	}

}
