package javadsa.linklistLev1;

import java.util.Stack;

//You have been given a singly linked list of integers. Write a function to print the list in a reverse order.

//To explain it further, you need to start printing the data from the tail and move towards the head of the list, 
//printing the head data at the end.
//Note :
//You can’t change any of the pointers in the linked list, just print the linked list in the reverse order.

public class E_PrintLListinReverse {

	// create LinkedList Nodes with hardCoded data
	private static Node<Integer> createNodeList() {

		Node<Integer> node1 = new Node<>(10);
		Node<Integer> node2 = new Node<>(20);
		Node<Integer> node3 = new Node<>(30);
		Node<Integer> node4 = new Node<>(40);
		Node<Integer> node5 = new Node<>(50);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;

		return node1;
	}

	public static void main(String[] args) {

		Node<Integer> head = createNodeList();
		print(head);
		System.out.println("\n==============================");
		printReverse(head);
		
	}

	private static void printReverse(Node<Integer> head) {
		if(head==null) return;
		
		Stack<Integer> stack = new Stack<>();
		Node<Integer> temp = head;
		while(temp!=null) {
			stack.push(temp.data);
			temp = temp.next;
		}
		
		while(!stack.isEmpty())
			System.out.print(stack.pop()+" ");
	}

	// printing the LinkedList nodes
	private static void print(Node<Integer> head) {
		if (head == null)
			return;

		Node<Integer> temp = head;
		while (temp != null) {
			System.out.print(temp.data + ", ");
			temp = temp.next;
		}
	}
}
