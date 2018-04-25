import java.util.HashSet;
import java.util.Set;

public class FirstRepeatingElementInArrayTwo {

	public static void main(String[] args) {
		int[] arr = { 2, 6, 22, 6, 34, 22, 0,2 };
		nonrepeating(arr);
	}

	public static void nonrepeating(int[] arr) {
		int n =arr.length; int min = -1;
		HashSet<Integer> hs = new HashSet<>();
		for (int i=arr.length-1; i>=0; i--) {
		if(hs.contains(arr[i]))
			min = i;
		else
			hs.add(arr[i]);
	}
	if(min !=-1)
		System.out.println("First repeating element is:"+arr[min]);
	else
		System.out.println("No repeating elements");
	}
}
