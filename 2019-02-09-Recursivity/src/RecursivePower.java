
public class RecursivePower {

	public static void main(String[] args) {
		System.out.println(power(8, 7));
	}

	private static long power(long x, long n) {
		if (n > 1) {
			return x * power(x, n - 1);
		}
		return x;
	}

}
