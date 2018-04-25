import java.util.Arrays;
import java.util.Collections;

public class kthLargestElement {

	public static void main(String[] args) {
		Integer[] arr = {8,256,1000,1,-6};
		sorting(arr, 3);
	}

	public static void sorting(Integer[]arr,int k){
		Arrays.sort(arr,Collections.reverseOrder());
		for (int i = 0; i < 3; i++) {
			System.out.println(arr[i]);
			
		}
	}
}
