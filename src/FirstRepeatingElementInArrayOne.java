
public class FirstRepeatingElementInArrayOne {

	public static void main(String[] args) {
		int[] arr = {5,4,5,6,0,1,6,1};
repeat(arr);
	}
	public static void repeat(int[]arr){
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				if(arr[i]==arr[j])
					
					System.out.println(arr[i]);
					
				}
			break;
			}
		}
		
	}


