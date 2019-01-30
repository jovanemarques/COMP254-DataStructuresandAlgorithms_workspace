package assignment1;

public class Test {

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.printList();
		ll.add(8);
		ll.printList();
		ll.add(17);
		ll.add(5);
		ll.add(10);
		ll.printList();
		ll.swapNodes(ll.find(10), ll.find(8));
		ll.printList();
		ll.remove(5);
		ll.printList();
	}
}
