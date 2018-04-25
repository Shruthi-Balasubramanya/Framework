public class SubArrayWithSumEqualToZero {
	public static void main(String[] args) {
		int[] arr = { 2, -3, 1, -5, 4, 1 };
		subarray(arr, 0);
	}

	public static void subarray(int[] arr, int inputNumber) {
		int n = arr.length;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum = arr[i];
			for (int j = i + 1; j < n; j++) {
				sum += arr[j];
				if (sum == inputNumber) {
					System.out.println("subarray is:");
					for (int k = i; k <= j; k++) {
						System.out.print(arr[k] + " ");
					}
					System.out.println();
				}

				else if (sum < inputNumber) {
					continue;
				} else if (sum > inputNumber) {
					break;
				}
				
			}
		}
		if(sum!=inputNumber)
			System.out.println("No more subarrays");
	}

}