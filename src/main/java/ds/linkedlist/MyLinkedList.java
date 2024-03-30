package ds.linkedlist;

public class MyLinkedList<E> {
	
	private MyNode<E> head ;
	private int size = 0;
	
	
	/**
	 * @author Ayan Saha
	 * <p>This utility method traverse the list to reach pos node of the list</p>
	 * @return
	 */
	private MyNode<E> travarse(MyNode<E> temp, int pos) {
			
		int count = 1;
		while(count < pos) {
			temp = temp.next;
			count++;
		}
		return temp;
	}
	
	public boolean isEmpty() {
		return (head == null);
	}
	
	public int size() {
		return size;
	}
	
	public void revere() {
		
		MyNode<E> current = head;
		MyNode<E> prev = null;
		MyNode<E> next;
		
		while(current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
	}
	
	/**
	 * @author Ayan Saha
	 * <p>This method deletes the node from tail end
	 * It uses traverse method reach the 2nd last element of the list. </p>
	 * @return
	 */	
	public E remove() {
		
		if (isEmpty()) 
			return null;
		
		MyNode<E> temp = head;
		temp = travarse(temp, size-1);
		E removedData = temp.next.data;
		temp.next = null;
		size--;
		return removedData;
	}
	
	public E remove(int pos) {
	
		if (isEmpty() || (pos > size)) {
			return null;
		}

		E removedData = null;
		
		if (pos == 1) {
			removedData = removeFirst();
		} else if (pos == size) {
			removedData = remove();
		} else {
			MyNode<E> temp = head;
			MyNode<E> temp1 ;
			MyNode<E> temp2 ;
			
			temp1 = travarse(temp, pos-1);
			temp2 = travarse(temp, pos);
			removedData = temp2.data;
			temp1.next = temp2.next;
			size--;
		}
		
		return removedData;
	}
	
	public E removeFirst() {
		E removedData = head.data;
		head = head.next;
		size--;
		return removedData;
	}

	public void addFirst(E data) {

		MyNode<E> temp = head;
		final MyNode<E> newNode = new MyNode<E>(data, temp);
		newNode.data = data;
		newNode.next = head;
		head = newNode;
		size++;
	}
	
	public void add(E data) {
		
		if (isEmpty()) {
			addFirst(data);
		} else {
			addLast(data);
		}
	}
	
	public void addLast(E data) {

		MyNode<E> temp = head;
		temp = travarse(temp, size);
		
		MyNode<E> newNode = new MyNode<>(data, null);
		temp.next = newNode;
		size++;
	}

	public void addAt(E data, int pos) {
		
		if (pos == 1) {
			addFirst(data);
		} else if (pos == size) {
			addLast(data);
		} else {
			MyNode<E> temp = head;
			temp = travarse(temp, pos-1);
			MyNode<E> newNode = new MyNode<E>(data, temp.next);
			temp.next = newNode;
			size++;
		}
	}

	public void printList() {
		
		MyNode<E> temp = head;
		while(temp != null) {
			System.out.print(temp.data + ", " );
			temp = temp.next;
		}
		
		System.out.println();
	}
	
	private static final class MyNode<E> {
		
		private E data;
		private MyNode<E> next;
		
		public MyNode(E data, MyNode<E> next) {
			this.data = data;
			this.next = next;
		}
	}
	
	
	public static void main(String[] args) {
		
		MyLinkedList<Integer> mylist = new MyLinkedList<>();
		System.out.println("--------------Start Processing------------");
		
		mylist.add(10);
		mylist.add(11);
		mylist.printList();
		
		System.out.println("------------Add First start-----------");
		mylist.addFirst(9);
		mylist.printList();
		
		System.out.println("-----------Add at method start------------");
		mylist.addAt(6, 1); 
		mylist.addAt(7, 5); 
		mylist.printList();
		
		/*System.out.println("-----------Removal Start------------------");
		System.out.println("Removed last: " + mylist.remove());
		mylist.printList();
		
		System.out.println("-----------Remoce At start----------------");
		System.out.println("Removed pos=1: " + mylist.remove(1));
		mylist.printList();
		System.out.println("Removed pos=1: " + mylist.remove(1));
		mylist.printList();*/
		
		mylist.revere();
		mylist.printList();
		
		mylist.remove();
		mylist.printList();
	}

}
