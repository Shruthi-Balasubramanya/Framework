import java.util.HashSet;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		int[] arr = { 1, 9, 3, 10, 4, 20, 2 };
		longest(arr);
	}

	public static void longest(int[] arr) {
		HashSet<Integer>hs = new HashSet<>();
		int n = arr.length; int j =0;int res=0;
		//Add elements to hashset
		for(Integer num:arr)
			hs.add(num);
		
		//find least possible number in array
		for (int i = 0; i < n; i++) {
			if(!hs.contains(arr[i]-1)){
				j=arr[i];
				while(hs.contains(j))
					j++;
				if(res<j-arr[i])
					res = j-arr[i];
			}
		}
		System.out.println(res);
	}

}
