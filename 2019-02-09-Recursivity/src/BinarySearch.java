
public class BinarySearch {

	private static int[] num = { 1, 3, 4, 6, 9, 10, 11, 12, 14, 16, 17, 19, 20, 21, 22, 30, 31, 33, 34, 45, 46, 47 };

	public static void main(String[] args) {
		System.out.println(find(12));
	}

	private static int find(int n) {
		for (int i = 0; i < num.length; i++) {
			if (num[i] == n) {
				return i;
			}
		}
		return -1;
	}
}
