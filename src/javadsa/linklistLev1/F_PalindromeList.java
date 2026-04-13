package javadsa.linklistLev1;

import java.util.Stack;

public class F_PalindromeList {

	// create LinkedList Nodes with hardCoded data
	private static Node<Integer> createNodeList() {

		Node<Integer> node1 = new Node<>(10);
		Node<Integer> node2 = new Node<>(20);
		Node<Integer> node3 = new Node<>(30);
		Node<Integer> node4 = new Node<>(20);
		Node<Integer> node5 = new Node<>(10);
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
		boolean ans = checkPalindromeList(head);
		if(ans) System.out.println("Yes it is palindrome list");
		
		else System.out.println("No, it is not palindrome list");

		head = createNodeList();
		Node<Integer> t1 = insertNodeAtIth(head, 23, 2);
		print(t1);
		System.out.println("\n====================");
		ans = checkPalindromeList(head);
		if(ans) System.out.println("Yes it is palindrome list");
		
		else System.out.println("No, it is not palindrome list");

	}

	private static boolean checkPalindromeList(Node<Integer> head) {
		if(head==null) return true;
		
		Node<Integer> mid = getMid(head);
		Node<Integer> reverseList = reverseList(mid);
		
		while(reverseList!=null && head!=null) {
			if(!reverseList.data.equals(head.data))
				return false;
			
			head = head.next;
			reverseList = reverseList.next;
		}
		
		return true;
	}

	private static Node<Integer> reverseList(Node<Integer> head) {

		if(head==null) return head;
		
		Node<Integer> prev = null,current = head, next = head;
		while(current!=null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}

	private static Node<Integer> getMid(Node<Integer> head) {
		Node<Integer> slow = head, fast = head;
		while(fast.next!=null && fast.next.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
	}

	private static Node<Integer> insertNodeAtIth(Node<Integer> head, int data, int pos) {

		if (pos < 0) {
			System.out.println("At give index Node insertion not possible: " + pos);
			return head;
		}
		Node<Integer> node = new Node<>(data);
		Node<Integer> current = head;
		int index = 0;
		if (pos == 0) {
			node.next = head;
			return node;
		}
		while (index < pos - 1) {
			index++;
			if (current == null) {
				System.out.println("Given index " + pos + " is out of bounds");
				return head;
			}
			current = current.next;
		}
		if (current == null) {
			System.out.println("Given index " + pos + " is out of bounds");
			return head;
		}
		node.next = current.next;
		current.next = node;

		return head;
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
