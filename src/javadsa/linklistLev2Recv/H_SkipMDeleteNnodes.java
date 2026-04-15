package javadsa.linklistLev2Recv;

import javadsa.linklistLev1.Node;

//You have been given a singly linked list of integers along with two integers, 'M,' and 'N.' Traverse the 
//linked list such that you retain the 'M' nodes, then delete the next 'N' nodes. Continue the same until 
//the end of the linked list. Indexing starts from 1.
//
//To put it in other words, in the given linked list, you need to delete N nodes after every M nodes.
//
//Note :
//No need to print the list, it has already been taken care. Only return the new head to the list. You can 
//		return null in case where all nodes will be deleted.
public class H_SkipMDeleteNnodes {

	public static void main(String[] args) {
		
		int[] a = {1, 2, 3, 4, 5, 6, 7 ,8 ,9,10, 11};
		Node<Integer> head = createNodeList(a);
		printRec(head);
		System.out.println("\n==================");
		Node<Integer> ans = skipMremoveN(head, 2, 3);
		printRec(ans);
	}

	private static Node<Integer> skipMremoveN(Node<Integer> head, int M, int N) {
		//Edge cases: if head is null or if M is 0 or N is 0;
		if(head==null || M==0 && N > 0) return null;
		
		if(N==0) return head;
		
		//Declared current for traversing every node
		Node<Integer> current = head;
		
		while(current!=null) {
			//SKip M nodes to reach M-1 so that M-1 to connect next part
			for(int i=0; i < M-1 && current!=null ; i++)
				current = current.next;
			
			if(current==null) break;
			
			Node<Integer> deleteNode =current.next;
			//removing N nodes
			for(int i=0; i < N && deleteNode != null; i++)
				deleteNode = deleteNode.next;
			
			current.next = deleteNode;
			current = deleteNode;
		}
		
		return head;
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
