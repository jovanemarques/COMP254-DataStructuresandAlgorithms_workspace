
package linear;

public class IntNode {
	public int data;
	public IntNode next;

	public IntNode(int _data, IntNode _next) {
		this.data = _data;
		this.next = _next;
	}

	public String toString() {
		return Integer.toString(this.data);
	}
}
