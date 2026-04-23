package javadsa.linklist_TEST;

class Dequeue {
	
	int capacity;
	int size;
	Node head;
	Node tail;
	private class Node {
		int data;
		Node next;
		public Node(int data) {
			this.data = data;
		}
	}
	public Dequeue(int capacity) {
		this.capacity = capacity;
	}
	
	public void insertFront(int data) {
		if(size==capacity) {
			System.out.println(-1);
			return;
		}
		Node node = new Node(data);
		if(head==null) {
			head = node;
			tail = node;
		} else {
			node.next = head;
			head = node;
			tail = getTail(head);
		}
		size++;
	}
	
	public void insertRear(int data) {
		
		if(size==capacity) {
			System.out.println(-1);
			return;
		}
		Node node = new Node(data);
		if(head==null) {
			head = node;
			tail = node;
		} else {
			tail.next = node;
			tail = tail.next;
		}
		size++;
	}
	
	public void deleteFront(int data) {
		if(size==capacity) {
			System.out.println(-1);
			return;
		}
		head = head.next;
		size--;
	}
	
	public void deleteRear(int data) {
		
		if(size==capacity) {
			System.out.println(-1);
			return;
		}
		Node temp = head;
		while(temp.next != null && temp.next.next!=null) {
			temp = temp.next;
		}
		temp.next = null;
		size--;
	}
	
	private Node getTail(Node head) {
		
		Node temp = head;
		while(temp.next != null) {
			temp = temp.next;
		}
		return temp;
	}
	
	public int getFront() {
		return head.data;
	}
	
	public int getRear() {
		return tail.data;
	}
	
	public boolean isEmpty() {
		return size()==0;
	}
	private int size() {
		return size;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append("[");
		Node current = head;
		while(current != null) {
			sb.append(" "+current.data);
			if(current.next!=null)
				sb.append(",");
			current = current.next;
		}
		sb.append(" ]");
		
		return sb.toString();
	}
	
}
public class UseDequeue {

	public static void main(String[] args) {

		System.out.println("====================================================================");
		
		Dequeue deq = new Dequeue(10);
		
		deq.insertFront(11);
		deq.insertFront(1);
		deq.insertFront(6);
		deq.insertFront(8);
		deq.insertFront(2);
		deq.insertRear(10);
		System.out.println(deq);
		System.out.println("==================Start operation==============");
		
		while(!deq.isEmpty()) {
			System.out.println(deq.getFront());
			if(!deq.isEmpty())
				System.out.println(deq.getRear());
			deq.deleteFront(deq.getFront());
		}
		System.out.println(deq);
		System.out.println("==================================END===============================");
	}

}
