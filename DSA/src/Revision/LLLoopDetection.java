package Revision;

import LinkedListNStacks.Node;

public class LLLoopDetection {

	public static void main(String[] args) {
		LLLoopDetection llLoopDetection = new LLLoopDetection();
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node nC1 = new Node(4);
		Node nC2 = new Node(5);
		Node nC3 = new Node(6);
		Node nC4 = new Node(7);
		Node nC5 = new Node(8);
		Node nC6 = new Node(9);
		Node nC7 = new Node(10);
		Node nC8 = new Node(11);

		n1.setNextNode(n2);
		n2.setNextNode(n3);
		n3.setNextNode(nC1);
		nC1.setNextNode(nC2);
		nC2.setNextNode(nC3);
		nC3.setNextNode(nC4);
		nC4.setNextNode(nC5);
		nC5.setNextNode(nC6);
		nC6.setNextNode(nC7);
		nC7.setNextNode(nC8);
		nC8.setNextNode(nC1);
		
		System.out.println(llLoopDetection.getLoopStartingNode(n1).getData());
	}

	private Node getLoopStartingNode(Node n) {
		if (n == null) {
			return null;
		}
		Node slwPtr = n;
		Node fstPtr = n;
		boolean isLoopFound = false;
		while (true) {
			if (fstPtr == null || fstPtr.getNextNode() == null) {
				break;
			}
			fstPtr = fstPtr.getNextNode().getNextNode();
			slwPtr = slwPtr.getNextNode();
			if (slwPtr == fstPtr) {
				System.out.println("Collision point : " + fstPtr.getData());
				isLoopFound=true;
				break;
			}
		}
		if(isLoopFound){
			slwPtr=n;
			while(true) {
				if(slwPtr==fstPtr) {
					break;
				}
				slwPtr=slwPtr.getNextNode();
				fstPtr=fstPtr.getNextNode();
			}
		}
		return slwPtr;
	}

}
