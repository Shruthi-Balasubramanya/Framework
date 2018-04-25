import java.util.Arrays;

public class MergeTwoArrays {

	public static void main(String[] args) {
		int[] arr1 = { 1, 3, 4 };
		int[] arr2 = { 2, 5, 6 };
		int[] arr3 = new int[arr1.length + arr2.length];
		merge(arr1, arr2, arr3);
	}

	public static void merge(int[] arr1, int[] arr2, int[] arr3) {
		int n1 = arr1.length;
		int n2 = arr2.length;
		int n3 = arr3.length;
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < arr1.length && j < arr2.length) {

			// -----------------------------
			if (arr1[i] < arr2[j]) {
				arr3[k] = arr1[i];
				i++;
			}

			// -----------------------------
			else {
				arr3[k] = arr2[j];
				j++;
			}

			k++;

		}
		
		//copy remaining elements of array1 to array3
		if(i<arr1.length){
			System.arraycopy(arr1, i, arr3, k, (arr1.length-1));
		}
		
		//copy remaining elements of array1 to array3
		if(j<arr2.length){
			System.arraycopy(arr2, j, arr3, k, (arr2.length-1));
		}
		
		int[]arrCopy = Arrays.copyOf(arr3, arr3.length);
		for (int l = 0; l < arrCopy.length; l++) {
			System.out.print(arrCopy[l]+" ");
		}

	}

}
