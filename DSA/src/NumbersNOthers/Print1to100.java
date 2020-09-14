//https://medium.com/@bhprtk/print-1-100-without-a-loop-2e56cdd7d05c
package NumbersNOthers;

public class Print1to100 {
	public static void main(String[] args) {
		Print1to100 print1to100 = new Print1to100();
		print1to100.print(1, 20);
		System.out.println();
	}

	private void print(int n, int limit) {
		if (n > limit) {
			return;
		}
		System.out.print(n);
		print(n + 1, limit);
	}
}
