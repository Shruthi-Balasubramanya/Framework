
public class IntersectionThreeLargestElements {

	public static void main(String[] args) {
		int[]arr1={1,2,3,5};
		int[]arr2={3,4,5};
		int[]arr3={3,5,6};
intersection(arr1, arr2, arr3);
	}
	public static void intersection(int[] arr1,int[] arr2,int[] arr3){
		int n1 = arr1.length;int n2 = arr2.length;int n3 = arr3.length;int count =0;
		System.out.println("Intersecting points are :");
		for (int i = 0; i < n1; i++) {
			for (int j = 0; j < n2; j++) {
				for (int k = 0; k < n3; k++) {
					if(arr1[i]==arr2[j]&&arr2[j]==arr3[k]){
						System.out.println(arr1[i]);
						count++;
					}
				}
			}
		}
		if(count==0)
			System.out.println("No intersection");
		
	}

}
