public class IntersetionTwoArrays {
	public static void main(String[] args) {
		int[] arr1 = { 1, 2,3 };
		int[] arr2 = { 3, 4, 5 };
		intersetionOfArray(arr1, arr2);
	}

	public static void intersetionOfArray(int[] arr1, int[] arr2) {
		int count = 0;
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				if (arr1[i] == arr2[j]){
					System.out.println(arr1[i] + " ");
				count++;}
			}

		}
		
		if(count ==0)
			System.out.println("Not intersected");
	}
}
