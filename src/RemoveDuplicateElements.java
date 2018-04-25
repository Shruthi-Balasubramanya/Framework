import java.util.Arrays;

public class RemoveDuplicateElements{
	public static void main(String[] args) {
		int[] arr = {4,4,5,6,1,7,5,5,5};
		dupElements(arr);
	}
	
	public static void dupElements(int[]arr){
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				if(arr[i]==arr[j]){
					arr[j]=arr[n-1];
					n--;
					j--;
				}
			}
		}
		int[] arr1= Arrays.copyOf(arr, n);
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr[i]+" ");
			
		}
		
	}
}