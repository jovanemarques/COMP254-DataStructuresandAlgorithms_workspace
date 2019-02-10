import java.util.Arrays;

public class ReverseArray {

	private static int[] num = { 1, 3, 4, 6, 9, 11, 12, 14, 16, 17, 19, 20 };

	public static void main(String[] args) {
		System.out.println(Arrays.toString(num));
		System.out.println(Arrays.toString(linearReverse(num)));
		//System.out.println(recursiveReverse(num));
	}

	private static int[] linearReverse(int[] arr) {
		int j[] = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			j[arr.length - 1 - i] = arr[i];
		}
		return j;
	}

	private static int[] recursiveReverse(int[] arr) {
		int j[] = new int[arr.length];
		for (int i = 0; i < arr.length - 1; i++) {
			j[(arr.length - 1) - i] = arr[i];
		}
		return j;
	}

}
