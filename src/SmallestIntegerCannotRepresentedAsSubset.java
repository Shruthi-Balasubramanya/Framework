public class SmallestIntegerCannotRepresentedAsSubset {
	public static void main(String[] args) {

		int[] arr = { 1, 2, 6, 7 };
		smallest(arr);
	}
	
	public static void smallest(int[]arr){
		int res =1;
		int n = arr.length;
		for (int i = 0; i < n&&arr[i]<=res; i++) {
			res+=arr[i];
		}
		System.out.println(res);
	}
}