package javadsa.linklistLev1;

//You have been given a singly linked list of integers where the elements are sorted in ascending
//order. Write a function that removes the consecutive duplicate values such that the given list 
//only contains unique elements and returns the head to the updated list.
public class D_RemoveDuplicates {

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
			Node<Integer> t1 = insertNodeAtIth(head, 20, 2);
			t1 = insertNodeAtIth(head, 30, 4);
			t1 = insertNodeAtIth(head, 40, 6);
			t1 = insertNodeAtIth(head, 50, 8);
			t1 = insertNodeAtIth(head, 60, 9);
			t1 = insertNodeAtIth(head, 60, 10);
			t1 = insertNodeAtIth(head, 62, 11);
			print(t1);
			System.out.println("\n====================");
			head = removeDuplicates(head);
			print(head);
			
		}

		private static Node<Integer> removeDuplicates(Node<Integer> head) {
			
			if(head==null) return head;
			
			Node<Integer> temp = head;
			while(temp.next!=null) {
				if(temp.data.equals(temp.next.data)) {
					temp.next = temp.next.next;
				} else
					temp = temp.next;
				
			}
			return head;
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
