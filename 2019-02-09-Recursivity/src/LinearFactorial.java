
public class LinearFactorial {

	public static void main(String[] args) {
		System.out.println(factorial(5));
	}

	private static int factorial(int num) {
		int result = num;
		for (int i = num; i > 1; i--) {
			result *= (i - 1);
		}
		return result;
	}

}
