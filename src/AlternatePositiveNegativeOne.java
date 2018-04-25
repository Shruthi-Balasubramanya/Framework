import java.util.Arrays;

public class AlternatePositiveNegativeOne {

	public static void main(String[] args) {
		int[] arr = { 2, 3, -1, 3, -5, -4, -5 };
		dup(arr);
	}

	public static void dup(int[] arr) {
		int temp = 0;
		int n = arr.length;
		int iValue = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {

				if (arr[j] < 0) {
					temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
					iValue = i;
				}

			}

		}
		int pos = iValue + 1;
		int neg = 0;
		int tempValue = 0;
		while (pos < n && neg < pos && arr[neg] < 0) {
			temp = arr[neg];
			arr[neg] = arr[pos];
			arr[pos] = temp;
			pos++;
			neg += 2;
		}
		int[] arrCopy = Arrays.copyOf(arr, n);
		for (int i = 0; i < arrCopy.length; i++) {
			System.out.print(arr[i] + " ");
		}

	}
}
