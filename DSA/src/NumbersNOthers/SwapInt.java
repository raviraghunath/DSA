package NumbersNOthers;

public class SwapInt {

	public static void main(String[] args) {
		SwapInt swapInt = new SwapInt();
		swapInt.swap(1, 2);
		swapInt.swap(1, 2, 3);
	}

	private void swap(int a, int b) {
		System.out.println(a + "-" + b);
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println(a + "-" + b);
	}

	private void swap(int a, int b, int c) {
		System.out.println(a + "-" + b + "-" + c);
		a = a + b + c;
		b = a - (b + c);
		c = a - (b + c);
		a = a - (b + c);
		System.out.println(a + "-" + b + "-" + c);
	}

}
