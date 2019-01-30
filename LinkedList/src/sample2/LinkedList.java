package sample2;

public class LinkedList {
	Node root;
	int size;

	public LinkedList() {
		root = null;
		size = 0;
	}

// Test code - main function
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		System.out.println(ll.getSize());
		ll.add(8);
		System.out.println(ll.getSize());
		ll.add(17);
		ll.add(5);
		ll.add(10);
		System.out.println(ll.find(17).getData());
		ll.remove(5);
		System.out.println(ll.getSize());
		System.out.println(ll.find(5));
	}

	public void setSize(int s) {
		this.size = s;
	}

	public int getSize() {
		return this.size;
	}

	// adding a item for the list
	public Node add(int data) {
		Node newNode = new Node(data, root);
		this.root = newNode;
		this.size++;
		return newNode;
	}

	// finding a node
	public Node find(int data) {
		Node thisNode = this.root;

		while (thisNode != null) {
			if (thisNode.getData() == data)
				return thisNode;
			thisNode = thisNode.getNextNode();
		}
		return null;
	}

	// removing the item from the list
	public boolean remove(int data) {
		Node thisNode = this.root;
		Node prevNode = null;

		while (thisNode != null) {
			if (thisNode.getData() == data) {
				if (prevNode != null)
					prevNode.setNextNode(thisNode.getNextNode());
				else
					this.root = thisNode.getNextNode();
				this.setSize(this.getSize() - 1);
				return true;
			}
			prevNode = thisNode;
			thisNode = thisNode.getNextNode();
		}
		return false;
	}

// Node class
	private class Node {
		private Node nextNode;
		private int data;

// 0-arg constructor, 1-arg constructor, 2-arg constructor
		private Node() {
		}

		private Node(int val) {
			data = val;
		}

		private Node(int val, Node next) {
			data = val;
			nextNode = next;
		}

		private void setData(int val) {
			this.data = val;
		}

		private int getData() {
			return this.data;
		}

		private void setNextNode(Node n) {
			this.nextNode = n;
		}

		private Node getNextNode() {
			return this.nextNode;
		}
	}
}
