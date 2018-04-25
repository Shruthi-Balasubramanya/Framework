public class dummy{
	public static void main(String[] args) {
		String str = "123##@#$sHr";int chCount =0; int digCount =0; int splChar =0;
		for (int i = 0; i < str.length(); i++) {
			Character ch = str.charAt(i);
			if(ch.isDigit(ch)){
				chCount ++;
				
			}
			else if(ch.isLetter(ch)){
				digCount++;
				
			}
			else
				splChar++;
			
		}
		System.out.println(chCount);
		System.out.println(digCount);
		System.out.println(splChar);
	}
}