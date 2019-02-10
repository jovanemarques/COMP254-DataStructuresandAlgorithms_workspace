
public class LinearFibonatti {

	public static void main(String[] args) {
		System.out.println(fibonatti(4));
	}
	// 0 1 2 3 5 8 11
	private static long fibonatti(long num) {
		long prev = 0;
		long curr = 1;
		long next = 0;
		for (int i = 1; i < num; i++) {
			next = curr + next;
			prev = curr;
			curr = next;
			
		}
		return next;
	}
}
