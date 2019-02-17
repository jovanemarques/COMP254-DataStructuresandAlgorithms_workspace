public class StackArray {

	private int CAPACITY = 10;

	private int[] stack = null;
	private int size = 0;

	public StackArray() {
		stack = new int[CAPACITY];
	}

	public void push(int value) {
		if (size == stack.length) {
			reSize(CAPACITY);
		}
		stack[size] = value;
		size++;
	}

	public int pop() {
		if (size == 0) {
			throw new ArrayIndexOutOfBoundsException();
		}
		int result = stack[size - 1];
		stack[size - 1] = 0;
		size--;

		return result;
	}

	public int size() {
		return size;
	}

	public int capacity() {
		return stack.length;
	}

	public int capacityRemaining() {
		return stack.length - size;
	}

	public void empty() {
		for (int i = 0; i < stack.length; i++) {
			stack[i] = 0;
		}
		size = 0;
	}

	public int peek() {
		if (size == 0) {
			throw new ArrayIndexOutOfBoundsException();
		}
		int result = stack[size - 1];

		return result;
	}

	public void compress() {
		if (stack.length > size) {
			int newCapacity = size;
			int[] newStack = new int[newCapacity];
			for (int i = 0; i < stack.length; i++) {
				newStack[i] = stack[i];
			}
			stack = newStack;
		}
	}

	public void add(int item) {
		if (size == stack.length) {
			reSize(CAPACITY);
		}
		stack[size] = item;
		size++;
	}

	public void reSize(int quantity) {
		int[] newStack = new int[stack.length < 1 ? quantity : stack.length + quantity];

		for (int i = 0; i < stack.length; i++) {
			newStack[i] = stack[i];
		}
		stack = newStack;
	}

	public static void main(String[] args) {

		StackArray sa = new StackArray();
		sa.push(5);
		sa.push(22);
		sa.push(02);

		System.out.println(sa.pop());
	}

}
