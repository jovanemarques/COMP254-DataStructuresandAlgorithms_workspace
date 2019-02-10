
public class LinearPower {

	public static void main(String[] args) {
		System.out.println(power(8, 7));
	}

	private static long power(long x, long n) {
		long result = 1;
		for (int i = 0; i < n; i++) {
			result *= x;
		}
		return result;
	}

}
