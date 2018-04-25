import java.util.Arrays;

public class AlternateNegativePositive {

	public static void main(String[] args) {
		// public static void main(String[] args) {
		int[] arr = { -2, 4, 5, -2, -4, 1 };
		alternate(arr);

	}
	
	public static void alternate(int[]arr){
		int temp =0; int iValue =0;int n = arr.length;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if(arr[j]>0){
					temp=arr[j];
					arr[j]=arr[i];
					arr[i]=temp;
					iValue = i;
					
				}
			}
		}
		
		int neg = iValue +1; int pos =0; int tempValue=0;
		while(neg>pos&&neg<n&&arr[neg]<0){
			tempValue = arr[neg];
			arr[neg]=arr[pos];
			arr[pos]=tempValue;
			neg++;
			pos+=2;
		}
		
		
		int[]arrCopy= Arrays.copyOf(arr, arr.length);
		for (int i = 0; i < arrCopy.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}

}
