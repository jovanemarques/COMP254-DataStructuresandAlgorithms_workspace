package assignment1;

public class LinkedList {
	Node root;
	int size;

	public LinkedList() {
		root = null;
		size = 0;
	}

	public void swapNodes(Node n1, Node n2) {

		Node previousNode = null;
		Node currentNode = root;
		Node savedPreviousN1Node = null;
		Node savedN1Node = null;
		Node savedPreviousN2Node = null;
		Node savedN2Node = null;
		Node tempNode = null;
//		if (currentNode != null && currentNode.getNextNode() != null && n1 != null && n2 != null && n1 != n2) {
		while (currentNode != null) {
			// if found the N1
			if (currentNode.getData() == n1.getData()) {
				savedPreviousN1Node = previousNode;
				savedN1Node = currentNode;
				// if found the N2
			} else if (currentNode.getData() == n2.getData()) {
				savedPreviousN2Node = previousNode;
				savedN2Node = currentNode;
			}
			// if found both, stop the searching
			if (savedN1Node != null && savedN2Node != null) {
				// swapping N1 previous 
				if (savedPreviousN1Node == null) {
					root = n2;//if root
				} else {
					savedPreviousN1Node.setNextNode(n2);
				}
				// swapping N2 previous
				if (savedPreviousN2Node == null) {
					root = n1;//if root
				} else {
					savedPreviousN2Node.setNextNode(n1);
				}
				// swapping N1 and N2 next
				tempNode = n1.getNextNode();
				n1.setNextNode(n2.getNextNode());
				n2.setNextNode(tempNode);
				break;
			}
			previousNode = currentNode;
			currentNode = currentNode.getNextNode();
		}

	}

	public void setSize(int s) {
		this.size = s;
	}

	public int getSize() {
		return this.size;
	}

	public Node add(int data) {
		Node newNode = new Node(data, root);
		this.root = newNode;
		this.size++;
		return newNode;
	}

	public Node find(int data) {
		Node thisNode = this.root;

		while (thisNode != null) {
			if (thisNode.getData() == data)
				return thisNode;
			thisNode = thisNode.getNextNode();
		}
		return null;
	}

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

	public void printList() {
		Node node = root;
		StringBuffer s = new StringBuffer();
		while (node != null) {
			s.append("[").append(node.getData()).append("] -> ");
			node = node.getNextNode();
		}
		if (this.getSize() > 0) {
			s.append("[null]");
		}
		System.out.println(s);
	}
}
