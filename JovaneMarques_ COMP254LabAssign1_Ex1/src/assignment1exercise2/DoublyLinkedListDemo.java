package assignment1exercise2;

public class DoublyLinkedListDemo {

	public static void main(String[] args) {
		DoublyLinkedList L = new DoublyLinkedList();
		L.insertAtHead(5);
		L.insertAtHead(15);
		L.insertAtHead(22);
		L.insertAtHead(51);
		
		DoublyLinkedList M = new DoublyLinkedList();
		M.insertAtHead(3);
		M.insertAtHead(0);
		M.insertAtHead(18);
		M.insertAtHead(500);

		DoublyLinkedList L_ = L.concatenateWith(M);
		System.out.println(L_);
		
		L = new DoublyLinkedList();
		L.insertAtHead(2);
		
		M = new DoublyLinkedList();
		M.insertAtHead(27);

		L_ = L.concatenateWith(M);
		System.out.println(L_);
		
		L = new DoublyLinkedList();
		
		M = new DoublyLinkedList();

		L_ = L.concatenateWith(M);
		System.out.println(L_);
		
		L = new DoublyLinkedList();
		L.insertAtHead(1);
		L.insertAtHead(2);
		
		M = new DoublyLinkedList();
		M.insertAtHead(5);
		M.insertAtHead(4);

		L_ = L.concatenateWith(M);
		System.out.println(L_);
	}

}
