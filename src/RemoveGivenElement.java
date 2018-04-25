import java.util.ArrayList;
import java.util.Arrays;

public class RemoveGivenElement {

	public static void main(String[] args) {
		int[] arr = { 1,5,6,5,1};
		dup(arr,6);
	}

	public static void dup(int[] arr,int actualnum) {
		int n = arr.length; 
		ArrayList<Integer> al = new ArrayList<>();
		for(Integer number:arr){
			al.add(number);
			if(number==actualnum){
				al.remove(number);
			}
		}
		System.out.println(al);
		
	}
}
