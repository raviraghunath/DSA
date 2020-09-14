package LinkedListNStacks;
import java.util.Stack;

public class LLPalindromeCheck {

	public static void main(String[] args) {
		LLPalindromeCheck check = new LLPalindromeCheck();
		Node n1 = new Node(0);
		Node n2 = new Node(1);
		Node n2_1 = new Node(100);
		Node n3 = new Node(1);
		Node n4 = new Node(0);
		n1.setNextNode(n2);
//		n2.setNextNode(n3);
		n2.setNextNode(n2_1);
		n2_1.setNextNode(n3);
		n3.setNextNode(n4);

		boolean isPalindrome = check.isPalindrome(n1);
		System.out.println(isPalindrome);

	}

	private boolean isPalindrome(Node n) {
		Node node = n;
		if (node == null) {
			return false;
		}
		Stack<Node> stack = new Stack<Node>();
		Node slwPtr = node;
		Node fstPtr = node;
		stack.push(slwPtr);

		boolean isEven = false;

		while (fstPtr.getNextNode() != null) {
			if (fstPtr.getNextNode().getNextNode() != null) {
				fstPtr = fstPtr.getNextNode().getNextNode();
				slwPtr = slwPtr.getNextNode();
				stack.push(slwPtr);
			} else {
				isEven = true;
				break;
			}
		}
		slwPtr = slwPtr.getNextNode();
		if (!isEven) {
			stack.pop();
		}
		while (slwPtr != null) {
			if (slwPtr.getData() != stack.pop().getData()) {
				return false;
			}
			slwPtr = slwPtr.getNextNode();
		}
		return true;
	}
}
