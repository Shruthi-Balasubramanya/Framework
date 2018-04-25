public class FirstNonRepeatedElements {

	public static int nonRepeatingElement(int[] arr) {

		int n = arr.length;
		int j=0;
		for (int i = 0; i < n; i++) {
			for ( j = 0; j < n; j++) {
				if (i != j && arr[i] == arr[j]) {
					break;
				}
			}
			if (j == n) {
				return arr[i];
			}

		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 2, 5, 8, 8, 9, 4, 3 };
		System.out.println(nonRepeatingElement(arr));
	}
}