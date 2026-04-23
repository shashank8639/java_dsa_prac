package javadsa.linklistLev2Recv;

import javadsa.linklistLev1.Node;

//Given a singly linked list of integers, reverse the nodes of the linked list 'k' at a time and return its modified list.
//
//'k' is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a 
//multiple of 'k,' then left-out nodes, in the end, should be reversed as well.
//
//		Example :
//		Given this linked list: 1 -> 2 -> 3 -> 4 -> 5
//		For k = 2, you should return: 2 -> 1 -> 4 -> 3 -> 5
//		For k = 3, you should return: 3 -> 2 -> 1 -> 5 -> 4
public class J_KReverseNodes {

	public static void main(String[] args) {

		int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		Node<Integer> head = createNodeList(a); 
		printRec(head);
		System.out.println("\n=========================");
		
		Node<Integer> t1 = head;
			t1=	kReverse(t1, 3);
		printRec(t1);
		System.out.println("\n=========================");
		
		Node<Integer> t2 = createNodeList(a);
		t2 = kReverse(t2, 2);
		printRec(t2);
		System.out.println("\n=========================");
		 
		
	}

	private static Node<Integer> kReverse(Node<Integer> head, int k) {
		if(head==null || k <= 1) return head;
		
		Node<Integer> current = head,prev=null,next = null;
		int index = 0;
		
		while(index < k && current!=null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			index++;
		}
		
		if(next!=null)
			head.next = kReverse(next, k);
		
		return prev;
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
