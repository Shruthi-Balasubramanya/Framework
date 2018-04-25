import java.util.Arrays;

public class AlternatePositiveNegative {
	public static void main(String[] args) {
		int[] arr = { -2, 4, 5, -2, -4, 1 };
		alternate(arr);
	}

	public static void alternate(int[] arr) {
		int n = arr.length;
		int i = -1;
		int temp = 0;
		for (int j = 0; j < n; j++) {
			if (arr[j] < 0) {
				i++;
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
int pos = i+1;int neg = 0;
while(pos<n && neg<pos && arr[neg]<0){
	temp=arr[neg];
	arr[neg]=arr[pos];
	arr[pos]=temp;
	pos++;
	neg+=2;
}
int[]arrCopy = Arrays.copyOf(arr, n);
for (int j = 0; j < arrCopy.length; j++) {
	System.out.print(arr[j]+",");
}
	}
}