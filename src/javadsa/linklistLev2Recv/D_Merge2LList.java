package javadsa.linklistLev2Recv;

import javadsa.linklistLev1.Node;

public class D_Merge2LList {

	
	public static void main(String[] args) {

		Node<Integer> head1 = createNodeList();
		Node<Integer> head2 = createNodeList2();
		Node<Integer> ans = mergeLList(head1, head2);
		printRec(ans);
		System.out.println("\n================");
	}

	private static void printRec(Node<Integer> ans) {
		if(ans==null) return;
		
		System.out.print(ans.data+" ");
		printRec(ans.next);
	}

	private static Node<Integer> mergeLList(Node<Integer> head1, Node<Integer> head2) {

		Node<Integer> mergeHead = head1.data < head2.data ? head1 : head2;
		Node<Integer> currNode1 = mergeHead.next;
		Node<Integer> currNode2 = mergeHead == head1 ? head2 : head1;
		Node<Integer> prev = mergeHead;
		
		while(currNode1 !=null && currNode2 !=null) {
			if(currNode1.data < currNode2.data) {
				prev.next =currNode1; //connecting ll1 to ll2 node
				
				prev = currNode1;
				currNode1 = currNode1.next.next; //updating l1
			} else {
				prev.next = currNode2;
				prev = currNode2;
				currNode2 = currNode2.next;
			}
		}
		
		if(currNode1 != null)
			prev.next = currNode1;
		
		if(currNode2 !=null)
			prev.next = currNode2;
		
		return mergeHead;
	}

	// create LinkedList Nodes with hardCoded data
	private static Node<Integer> createNodeList() {

		Node<Integer> node1 = new Node<>(1);
		Node<Integer> node2 = new Node<>(3);
		Node<Integer> node3 = new Node<>(5);
		node1.next = node2;
		node2.next = node3;

		return node1;
	}

	private static Node<Integer> createNodeList2() {

		Node<Integer> node1 = new Node<>(2);
		Node<Integer> node2 = new Node<>(4);
		Node<Integer> node3 = new Node<>(6);
		Node<Integer> node4 = new Node<>(8);
		Node<Integer> node5 = new Node<>(12);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;

		return node1;
	}

}
