import java.util.Arrays;
//One element is not repeated twice, while all other elements are repeated twice

public class ElementNotRepeated {
	public static void main(String[] args) {
		int[] arr = { 1, 1, 2, 3, 3, 4, 4 };
		element(arr);
	}

	public static void element(int[] arr) {
		int n = arr.length; int sumWithoutDups =0;int sumOfArray =0; int notRepeated =0;
		
		//Calculate sum of array with duplicates
		for (int i = 0; i < n; i++) {
			sumOfArray+=arr[i];
		}
		System.out.println(sumOfArray);
		
		// array without duplicates 
		for (int i = 0; i <n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (arr[i] == arr[j]) {
					arr[j] = arr[n - 1];
					n--;
					j--;
				}
			}
		}
		
		//Copying array without duplicate to arrCopy
		int[] arrCopy = Arrays.copyOf(arr, n);
		for (int i = 0; i < arrCopy.length; i++) {
			System.out.println(arr[i]);
			//Calculate sum of array without duplicates
			sumWithoutDups += arr[i];
		}
		notRepeated = 2*sumWithoutDups-sumOfArray;
		System.out.println("Num is: "+notRepeated);
	}
}