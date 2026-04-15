package javadsa.linklistLev2Recv;

import javadsa.linklistLev1.Node;

//For a given singly linked list of integers, arrange the nodes such that all the even number nodes are 
//placed after the all odd number nodes. The relative order of the odd and even terms should remain unchanged.
//
//Note :
//1. No need to print the linked list, it has already been taken care. Only return the new head to the list.
//2. Don't create a new linked list.
//3.  Just change the data, instead rearrange the provided list.
public class G_EvenOrOddList {

	public static void main(String[] args) {

		int[] a = {1, 11, 3, 6, 8, 0, 9};
		Node<Integer> head = createNodeList(a); //creates NodeList with an array
		printRec(head);
		System.out.println("\n======================");
		Node<Integer> oddHead = evenOrOddList(head);
		printRec(oddHead);
		
	}
	
	private static Node<Integer> evenOrOddList(Node<Integer> head) {
		//Handle edge case with single node or where head is null
		if(head==null || head.next==null) return head;
		
		//Declaring head and tail for both even and odd lists
		Node<Integer> current=head,evenHead=null,evenTail=null,oddHead=null,oddTail=null;
		
		while(current!=null) {
			//saving Next nodes
			Node<Integer> nextNode = current.next;
			//Breaking cycle  to avoid infinite loop
			current.next = null;
			
			if(current.data%2==0) {//validating value as even
				if(evenHead==null) { //even head starts for even no list
					evenHead = current;
					evenTail = current;
				} else {
					evenTail.next = current; //even list is extended
					evenTail = evenTail.next;
				}
			} else {//odd head starts here for odd no list
				if(oddHead==null) {
					oddHead = current;
					oddTail = current;
				} else {
					oddTail.next = current; //odd list is extended
					oddTail = oddTail.next;
				}
			}
			current = nextNode;
		}
		
		//connecting oddTail to evenHead
		if(oddHead!=null && evenHead!=null)
			oddTail.next = evenHead;  
		
		return (oddHead==null) ? evenHead : oddHead;
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
	
	private static void printRec(Node<Integer> head) {
		if(head==null) return;
		
		System.out.print(head.data+" ");
		printRec(head.next);
	}

}
