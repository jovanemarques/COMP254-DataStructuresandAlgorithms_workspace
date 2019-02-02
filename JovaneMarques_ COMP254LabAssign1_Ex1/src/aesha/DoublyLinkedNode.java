package aesha;

public class DoublyLinkedNode {
	public int data;
	public DoublyLinkedNode nextNode;
	public DoublyLinkedNode previousNode;
	
	public DoublyLinkedNode(int _data) {
		this.data= _data;
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

	public void setPreviousNode(DoublyLinkedNode prevNode) {
		this.previousNode = prevNode;
	}
}