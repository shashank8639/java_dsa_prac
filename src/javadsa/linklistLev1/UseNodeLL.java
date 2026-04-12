package javadsa.linklistLev1;

import java.util.Scanner;

public class UseNodeLL {

	public static void main(String[] args) {

		Node<Integer> head = createNodeList();
		print(head);
		System.out.println("\n=================");
		
		head = takeInput();
		print(head);
		System.out.println("\n======================");
		
	}

	private static Node<Integer> takeInput() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the data");
		
		int data = sc.nextInt();
		
		Node<Integer> head = null, tail = null;
		
		while(data != -1) {
			Node<Integer> current = new Node<>(data);
			if(head==null) {
				head = current;
				tail = current;
			} else {
				tail.next = current;
				tail = tail.next;
			}
			System.out.println("enter next node");
			data = sc.nextInt();
		}
		return head;
	}

	//printing the LinkedList nodes
	private static void print(Node<Integer> head) {
		if(head==null) return;
		
		Node<Integer> temp = head;
		while(temp!=null) {
			System.out.print(temp.data+", ");
			temp = temp.next;
		}
	}

	//create LinkedList Nodes with hardCoded data
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

}
