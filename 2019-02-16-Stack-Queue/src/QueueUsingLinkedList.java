class Node {
	int data;
	Node next;

	public Node(int key) {
		data = key;
		next = null;
	}

	public void displayNode() {
		System.out.println("item" + data);
	}
}

class LinkedList {
	Node first;

	public LinkedList() {
		first = null;
	}

	public void insert(int i) {
		Node newNode = new Node(i);

		if (first == null) {
			first = newNode;
			return;
		}

		Node tempNode = first;
		while (tempNode.next != null) {
			tempNode = tempNode.next;
		}
		tempNode.next = newNode;
	}

	public Node remove() {
		Node temp = first;
		first = first.next;
		return temp;
	}

	public void display() {
		Node tempNode = first;
		while (tempNode != null) {
			tempNode.displayNode();
			tempNode = tempNode.next;
		}
		System.out.println();
	}
}

class Queue {
	LinkedList llist = new LinkedList();

	public void insert(int i) {
		llist.insert(i);
	}

	public void remove() {
		llist.remove();
	}

	public void display() {
		llist.display();
	}
}

public class QueueUsingLinkedList {

	public static void main(String[] args) {
		Queue QqObj = new Queue();
		QqObj.insert(1);
		QqObj.insert(2);
		QqObj.insert(3);
		QqObj.insert(4);
		QqObj.remove();
		QqObj.remove();
		QqObj.display();
	}

}
