package javadsa.linklistLev2Recv;

import javadsa.linklistLev1.Node;

public class C_ReverseLLRecursive {

	// create LinkedList Nodes with hardCoded data
	private static Node<Integer> createNodeList() {

		Node<Integer> node1 = new Node<>(6);
		Node<Integer> node2 = new Node<>(8);
		Node<Integer> node3 = new Node<>(9);
		Node<Integer> node4 = new Node<>(15);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;

		return node1;
	}

	private static class DoubleNode<T> {
		Node<T> head;
		Node<T> tail;
	}
	public static void main(String[] args) {

		Node<Integer> head = createNodeList();
		printRec(head);
		System.out.println("\n==============================");
		Node<Integer> reverse = reverseRec(head);
		printRec(reverse);
		System.out.println("\n=========Recursive with Class DoublNode===============");
		
		DoubleNode<Integer> dn = reverseDNodeRec(reverse);
		printRec(dn.head);

		System.out.println("\n====================");
	}

	private static DoubleNode<Integer> reverseDNodeRec(Node<Integer> head) {
		if(head==null || head.next==null) {
			DoubleNode<Integer> dn = new DoubleNode<>();
			dn.head = head;
			dn.tail = head;
			return dn;
		}
		
		DoubleNode<Integer> ans = reverseDNodeRec(head.next);
		DoubleNode<Integer> d = new DoubleNode<>();
		d.head = ans.head;
		
		ans.tail.next = head;
		head.next = null;
		
		d.tail = ans.tail.next;
		
		return d;
	}

	private static Node<Integer> reverseRec(Node<Integer> head) {
		
		if(head==null || head.next==null) return head;
			
		Node<Integer> revHead = head;
		Node<Integer> prev = head,current = head.next;

		revHead = reverseRec(head.next);
		current.next = head;
		head.next = null;
		
		return revHead;
	}

	private static void printRec(Node<Integer> head) {
		if (head == null)
			return;

		System.out.print(head.data + " ");
		printRec(head.next);
	}

}
