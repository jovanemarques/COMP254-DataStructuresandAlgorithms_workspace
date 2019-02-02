package assignment1exercise2;

public class DoublyLinkedNode {
	private int data;
	private DoublyLinkedNode nextNode;
	private DoublyLinkedNode previousNode;

	public DoublyLinkedNode(int _data) {
		this.data = _data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public DoublyLinkedNode getNextNode() {
		return nextNode;
	}

	public void setNextNode(DoublyLinkedNode nextNode) {
		this.nextNode = nextNode;
	}

	public DoublyLinkedNode getPreviousNode() {
		return previousNode;
	}

	public void setPreviousNode(DoublyLinkedNode previousNode) {
		this.previousNode = previousNode;
	}

}
