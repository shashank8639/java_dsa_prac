package javadsa.linklistLev1;

public class C_AppendLastNnodes {

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
		System.out.println("\n==========================");
		Node<Integer> t1 = insertNodeAtIth(head, 23, 2);
		t1 = insertNodeAtIth(head, 33, 4);
		t1 = insertNodeAtIth(head, 42, 6);
		t1 = insertNodeAtIth(head, 55, 8);
		t1 = insertNodeAtIth(head, 60, 9);
		t1 = insertNodeAtIth(head, 61, 10);
		t1 = insertNodeAtIth(head, 62, 11);
		print(t1);
		System.out.println("\n====================");
		head = appendLastNnodes(head, 7);
		print(head);
	}

	private static Node<Integer> appendLastNnodes(Node<Integer> head, int n) {
		
		Node<Integer> temp = head;
		int len = 0;
		while(temp!=null) {
			len++;
			temp = temp.next;
		}
		n = n%len;
		if(n==0) return head;
		
		Node<Integer> slow = head, fast = head;
		for(int i=0; i < n; i++)
			fast = fast.next;
		
		while(fast.next!=null) {
			slow = slow.next;
			fast = fast.next;
		}
		Node<Integer> newHead = slow.next;
		fast.next = head;
		slow.next = null;
		
		return newHead;
	}

	private static Node<Integer> insertNodeAtIth(Node<Integer> head, int data, int pos) {

		if(pos < 0) {
			System.out.println("At give index Node insertion not possible: "+pos);
			return head;
		}
		Node<Integer> node = new Node<>(data);
		Node<Integer> current = head;
		int index = 0;
		if(pos==0) {
			node.next = head;
			return node;
		}
		while(index < pos-1) {
			index++;
			if(current==null) {
				System.out.println("Given index "+pos+" is out of bounds");
				return head;
			}
			current = current.next;
		}
		if(current==null) {
			System.out.println("Given index "+pos+" is out of bounds");
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
