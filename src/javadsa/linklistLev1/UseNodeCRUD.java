package javadsa.linklistLev1;

public class UseNodeCRUD {

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
		print(t1);
		System.out.println("\n====================");
		t1 = insertNodeAtIth2(head, 33, 4);
		print(t1);
		System.out.println("\n=================Insert with EdgeCases===========");
		t1 = insert(t1, 5, 25);
		print(t1);
		System.out.println("\n==================Delete operation==============");
		Node<Integer> n1 = removeNode(head, 3);
		print(n1);
		System.out.println("\n===============delete 3rd value=============");
		n1 = removeNode(head, 2);
		print(n1);
		System.out.println("\n============== delete node at 0th pos===============");
		n1 = removeNode(head, 0);
		print(n1);
		System.out.println("\n============= search node return index pos=============");
		int ans = searchNodePos(head, 33);
		System.out.println("30 is at index: "+ans);
		ans = searchNodePos(head, 40);
		System.out.println("40 is at index: "+ans); 
		ans = searchNodePos(null, 20);
		System.out.println("20 is at index: "+ans);
	}

	private static int searchNodePos(Node<Integer> head, int data) {
		if(head==null) return -1;
		if(head.data==data) return 0;
		
		Node<Integer> current = head;
		int currentPos = 0;
		while(current!=null) {
			if(current.data==data)
				return currentPos;
			currentPos++;
			current = current.next;
			if(current==null)
				return -1;
		}
		
		return -1;
	}

	private static Node<Integer> removeNode(Node<Integer> head, int pos) {
		//validating the position
		if(pos < 0) throw new IndexOutOfBoundsException("The position can't be negative");
		
		if(pos==0)
			return head.next;
		
		Node<Integer> current = head;
		int currentPos = 0;
		
		//traverse to the position
		while(current!=null && currentPos < pos-1) {
			currentPos++;
			current = current.next;
		}
		if(current==null) throw new IndexOutOfBoundsException("The position exceeds list length: "+pos);
		
		//Removing the node at given position
		if(current.next!=null)
			current.next = current.next.next;
		
		return head;
	}

	public static Node<Integer> insert(Node<Integer> head, int pos, int data) {
	    // Validate position
	    if (pos < 0) {
	        throw new IndexOutOfBoundsException("Position cannot be negative: " + pos);
	    }
	    
	    Node<Integer> newNode = new Node<>(data);
	    
	    // Insert at head
	    if (pos == 0) {
	        newNode.next = head;
	        return newNode;
	    }
	    
	    // Traverse to position
	    Node<Integer> current = head;
	    for (int i = 0; i < pos - 1; i++) {
	        if (current == null) {
	            throw new IndexOutOfBoundsException("Position " + pos + " exceeds list length");
	        }
	        current = current.next;
	    }
	    
	    // Insert at position
	    newNode.next = current.next;
	    current.next = newNode;
	    
	    return head;
	}
	
	private static Node<Integer> insertNodeAtIth2(Node<Integer> head, int data, int pos) {
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
		node.next = current.next;
		current.next = node;
		
		return head;
	}

	private static Node<Integer> insertNodeAtIth(Node<Integer> head, int data, int index) {
		
		if(head==null) {
			System.out.println("Given LList is null so New Node created");
			Node<Integer> node = new Node<>(data);
			return node;
		}
		
		Node<Integer> prev = head, next = null;
		int c = 0;
		while(c < index-1) {
			c++;
			if(prev==null) break;
			prev = prev.next;
		}
		next = prev.next;
		prev.next = new Node<Integer>(data);
		prev.next.next = next;
		
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
