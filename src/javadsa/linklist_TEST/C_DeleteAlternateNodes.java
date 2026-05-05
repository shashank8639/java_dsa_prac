package javadsa.linklist_TEST;

import javadsa.linklistLev1.Node;

public class C_DeleteAlternateNodes {

	public static void main(String[] args) {

		int a[] = {3, 8, 5, 6, 1, 4, 2, 7};
		Node<Integer> head = createNodeList(a); 
		printRec(head);
		
		System.out.println("\n==================================");
		
		deleteAlternateNodes(head);
		printRec(head);
	}

	private static void deleteAlternateNodes(Node<Integer> head) {
		if(head==null || head.next==null) return;
		
		Node<Integer> current = head;
		
		while(current.next!=null && current.next.next != null) {
			current.next = current.next.next;
			current = current.next;
		}
		
		current.next=null;
		
	}

	private static void printRec(Node<Integer> head) {
		if(head==null) return;
		
		System.out.print(head.data+" ");
		printRec(head.next);
	}

	private static Node<Integer> createNodeList(int[] a) {

		Node<Integer> node = new Node<Integer>(a[0]);
		Node<Integer> t = node;
		for(int i=1; i < a.length; i++) {
			Node<Integer> n1 = new Node<>(a[i]);
			t.next = n1;
			t = n1;
		}
		return node;
	}
}
