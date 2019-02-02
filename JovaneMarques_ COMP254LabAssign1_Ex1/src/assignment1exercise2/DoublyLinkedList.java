package assignment1exercise2;

public class DoublyLinkedList {
	private DoublyLinkedNode head;
	// field to control the tail
	private DoublyLinkedNode tail;

	public void insertAtHead(int data) {
		DoublyLinkedNode newNode = new DoublyLinkedNode(data);
		newNode.setNextNode(this.head);
		if (this.head != null) {
			this.head.setPreviousNode(newNode);
		} else {
			//setting the tail on the first insert
			this.tail = newNode;
		}
		this.head = newNode;
	}

	public int length() {
		if (head == null)
			return 0;
		int length = 0;
		DoublyLinkedNode current = this.head;

		while (current != null) {
			length += 1;
			current = current.getNextNode();
		}
		return length;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		DoublyLinkedNode n = this.head;
		sb.append("null");
		sb.append(" <-> ");
		while (n != null) {
			sb.append("|");
			sb.append(n.getData());
			sb.append("| <-> ");

			n = n.getNextNode();
		}
		sb.append("null");
		return sb.toString();
	}

	public DoublyLinkedList concatenateWith(DoublyLinkedList l) {
		// if there are no heads so the lists are empty 
		if (this.head == null || l.head == null) {
			System.out.println("Both lists should have at least one item.");
			//exit the process
			return null;
		}
		// tail 1 link to the head 2
		tail.setNextNode(l.head);
		// head 2 link to the tail 1
		l.head.setPreviousNode(tail);
		// tail 2 is the new tail
		tail = l.tail;

		//  return the new list
		return this;
	}
}
