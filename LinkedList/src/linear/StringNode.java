
package linear;

public class StringNode {
	public String data;
	public StringNode next;

	public StringNode(String _data, StringNode _next) {
		this.data = _data;
		this.next = _next;
	}

	public String toString() {
		return this.data;
	}
}
