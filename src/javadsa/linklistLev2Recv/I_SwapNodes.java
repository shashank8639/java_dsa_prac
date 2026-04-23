package javadsa.linklistLev2Recv;

import javadsa.linklistLev1.Node;

//You have been given a singly linked list of integers along with two integers, 'i,' and 'j.' Swap the nodes
//that are present at the 'i-th' and 'j-th' positions and return the new head to the list.
//
//Note :
//1. Remember, You need to swap the nodes, not only the data.
//2. Indexing starts from 0.
//3. No need to print the list, it has already been taken care.
public class I_SwapNodes {

	public static void main(String[] args) {

		int[] a = {3, 4, 5, 2, 6, 1, 9};
		Node<Integer> head = createNodeList(a); 
		printRec(head);
		System.out.println("\n=========================");
		
		head = swapTwoNodes(head, 2, 4);
		printRec(head);
		System.out.println("\n=========================");
		
		int[] b = {70, 80, 90, 25, 65, 85, 90};
		Node<Integer> head2 = createNodeList(b); 
		head2 = swapTwoNodes(head2, 0, 6);
		printRec(head2);
		System.out.println("\n===ajsdjd======= ");
	}

	private static Node<Integer> swapTwoNodes(Node<Integer> head, int i, int j) {
		if(i==j) return head;
		if(i>j) {
			int temp = i;
			i=j;
			j= temp;
		}
		
		Node<Integer> current = head;
		Node<Integer> node1=null,node2=null;
		Node<Integer> prev1=null,prev2=null;
		int index = 0;
		
		while(current!=null) {
			if(index==i) node1 = current; //accessing node of targeted index of first one
			
			if(index==j) {
				node2 = current; //accessing node of targeted index of second one
				break;
			}
			
			if(index==i-1)
				prev1 = current; //accessing prev node of selected first node
			
			if(index==j-1)
				prev2 = current; //accessing prev node of selected second node
			
			current = current.next;
			index++;
		}
		if(node1==null || node2==null)
			return head;
		
		if(prev1!=null)             //p1 will be checked in case when i=0 then p1 is null (edge case
			prev1.next = node2;
		else
			head = node2;
		
		prev2.next = node1;           //p2 will never be null because j!=0 always even if i>j handled on top
		
		Node<Integer> fix = node1.next;
		node1.next = node2.next;
		node2.next = fix;
		
		return head;
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
