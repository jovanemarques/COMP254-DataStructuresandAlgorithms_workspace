package aesha;

public class DoublyLinkedListDemo {

	public static void main(String[] args) {
		DoublyLinkedList list1 = new DoublyLinkedList();
		DoublyLinkedList list2 = new DoublyLinkedList();
	    list1.insertAtHead(5);
		list1.insertAtHead(6);
		list1.insertAtHead(7);
		list2.insertAtHead(8);
		list2.insertAtHead(9);
		list2.insertAtHead(10);
		list1.Show();
		System.out.println("after concatenation:");
		list1.Concate(list2);
		list1.Show();
	//System.out.println(integer.toString().length());
	}

}