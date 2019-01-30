package doubly_link_list;

public class DoublyLinkedListDemo {

	public static void main(String[] args) {
		DoublyLinkedList integer = new DoublyLinkedList();
		integer.insertAtHead(5);
		integer.insertAtHead(10);
		integer.insertAtHead(2);
		integer.insertAtHead(12);
		integer.insertAtHead(19);
		integer.insertAtHead(20);

		int x = integer.length();
		System.out.println("The length of our linked list is: " + x);
		System.out.println("The list is: " + integer);
	}

}
