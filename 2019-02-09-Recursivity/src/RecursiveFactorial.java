
public class RecursiveFactorial {

	public static void main(String[] args) {
		System.out.println(factorial(15));

	}

	private static long factorial(long num) {
		if (num > 2) {
			return num * factorial(num - 1);
		}
		return num;
	}

}
