package javadsa.linklistLev2Recv;

import javadsa.linklistLev1.Node;

public class E_MergeSortLL_Medium {

	public static void main(String[] args) {

		int a[] = {3, 8, 5, 6, 1, 4, 2, 7};
		Node<Integer> head = createNodeList(a); 
		printRec(head);
		System.out.println("\n=========================");
		Node<Integer> sorted = mergeSort(head);
		printRec(sorted);
		System.out.println("\n=========================");
	}

	private static Node<Integer> mergeSort(Node<Integer> head) {
		if(head==null || head.next==null) return head;
		
		Node<Integer> mid = getMid(head);
		Node<Integer> n1 = head;
		Node<Integer> n2 = mid.next;
		mid.next = null;
		Node<Integer> left = mergeSort(n1);
		Node<Integer> right = mergeSort(n2);
		Node<Integer> mergeHead = merge(left,right);
		return mergeHead;
	}

	private static Node<Integer> merge(Node<Integer> left, Node<Integer> right) {
		if(left==null) return right;
		if(right==null) return left;
		
		Node<Integer> mergeHead = left.data < right.data ? left : right;
		Node<Integer> n1 = mergeHead.next, n2 = mergeHead==left ? right : left;
		Node<Integer> prev = mergeHead;
		
		while(n1!=null && n2!=null) {
			if(n1.data < n2.data) {
				prev.next = n1;
				prev = n1;
				n1 = n1.next;
			} else {
				prev.next = n2;
				prev = n2;
				n2 = n2.next;
			}
		}
		
		if(n1!=null)
			prev.next = n1;
		
		if(n2!=null)
			prev.next = n2;
		
		return mergeHead;
	}

	private static Node<Integer> getMid(Node<Integer> head) {
		Node<Integer> slow = head,fast = head;
		while(fast.next!=null && fast.next.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
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
