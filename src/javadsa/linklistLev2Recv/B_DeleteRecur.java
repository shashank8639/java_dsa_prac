package javadsa.linklistLev2Recv;

import javadsa.linklistLev1.Node;

public class B_DeleteRecur {

	// create LinkedList Nodes with hardCoded data
		private static Node<Integer> createNodeList() {

			Node<Integer> node1 = new Node<>(10);
			Node<Integer> node2 = new Node<>(20);
			Node<Integer> node3 = new Node<>(30);
			Node<Integer> node4 = new Node<>(20);
			Node<Integer> node5 = new Node<>(25);
			Node<Integer> node6 = new Node<>(10);
			node1.next = node2;
			node2.next = node3;
			node3.next = node4;
			node4.next = node5;
			node5.next = node6;

			return node1;
		}

		public static void main(String[] args) {

			Node<Integer> head = createNodeList();
			printRec(head);
			System.out.println("\n==============================");
			
			head = removeRec(head, 2);
			printRec(head);
			System.out.println("\n==============================");
			
			head = removeRec(head,0);
			printRec(head);
			System.out.println("\n==============================");
			
		}


		private static Node<Integer> removeRec(Node<Integer> head, int pos) {
			if(head==null)
				return head;
			
			if(pos==0)
				return head.next;
			
			head.next = removeRec(head.next, pos-1);
			
			return head;
		}

		private static void printRec(Node<Integer> head) {
			if(head==null) return;
			
			System.out.print(head.data+" ");
			printRec(head.next);
		}

}
