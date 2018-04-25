import java.util.Arrays;

public class FirstRepeatingElementsInArray {

	public static void main(String[] args) {
		int[] arr = { 5, 1, 5, 6, 2, 0, 1 };
		repeatingElements(arr);
	}

	public static void repeatingElements(int[] arr) {
		int n = arr.length;
		System.out.println("Repeating elements are:");
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (arr[i] == arr[j]) {
					System.out.print(arr[i]+" ");
				}
			}
		}
		System.out.println();
		int[] arrCopy = Arrays.copyOf(arr, n);
		for (int i = 0; i < 1; i++) {
			System.out.println("First repeating element is:");
			System.out.println(arr[i]);
		}
	}

}
