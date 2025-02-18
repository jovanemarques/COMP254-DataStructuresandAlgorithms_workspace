package doubly_link_list;

public class DoublyLinkedList {
	private DoublyLinkedNode head;

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

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		DoublyLinkedNode n = this.head;
		while (n != null) {
			sb.append("|");
			sb.append(n.getData());
			sb.append("| -> ");

			n = n.getNextNode();
		}
		return sb.toString();
	}
}
