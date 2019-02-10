
public class RecursiveFibonatti {

	public static void main(String[] args) {
		System.out.println(fibonatti(6));
	}

	// 0 1 2 3 5 8 11
	private static long fibonatti(long num) {
		if (num == 0) {
			return 0;
		} else if (num == 1) {
			return 1;
		} else {
			return fibonatti(num - 1) + fibonatti(num - 2);
		}
	}
}
