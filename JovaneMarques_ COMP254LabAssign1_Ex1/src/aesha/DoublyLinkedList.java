package aesha;

public class DoublyLinkedList {
	private DoublyLinkedNode head = null;
	private DoublyLinkedNode tail = null;

	public void insertAtHead(int data) {
		DoublyLinkedNode newNode = new DoublyLinkedNode(data);
		newNode.setNextNode(this.head);
		if (this.head != null) {
			this.head.setPreviousNode(newNode);
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

	public void Show() {
		DoublyLinkedNode current = head;
		while (current != null) {
			System.out.println(current.getData());
			current = current.nextNode;
		}
	}

	public DoublyLinkedList Concate(DoublyLinkedList nextList) {
		// this.head= null;
		if (this.head == null)
			System.out.println("There is no list to concatnate");
		this.tail = this.getTail();
		this.tail.setNextNode(nextList.head);
		nextList.head.setPreviousNode(this.tail);

		// newTail.

		return this;
	}

	public DoublyLinkedNode getTail() {
		DoublyLinkedNode current = head;
		DoublyLinkedNode result = null;
		while (current != null) {
			if (current.nextNode == null) {
				result = current;
			}
			current = current.nextNode;
		}
		return result;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		DoublyLinkedNode n = this.head;
		while (n != null) {
			sb.append("Node data--> ");
			sb.append(n);
			sb.append("\n");

			n = n.getNextNode();
		}
		return sb.toString();
	}
}