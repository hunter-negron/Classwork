import java.util.*;

public class Mnemonics {

	private static String[] digits = {"0", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};

	public static Vector<String> mnemonics(String number) {
	
		Vector<String> all = new Vector<String>();
		
		// Base Case
		if(number.length() == 1) {
		
			for(int i = 0; i < digits[Integer.parseInt(number)].length(); i++) {
			
				all.add(String.valueOf(digits[Integer.parseInt(number)].charAt(i)));
			}
			
			return all;
		}
		
		// General Case
		int head = number.charAt(0) - '0';
		Vector<String> tails = mnemonics(number.substring(1, number.length())); // Recursion
		
		for(int i = 0; i < tails.size(); i++) {
		
			// Uses the first digit of the number to get the string of relevant characters from the digits array
			for(int j = 0; j < digits[head].length(); j++) {
			
				String firstDigit = String.valueOf(digits[head].charAt(j));
				all.add(firstDigit + tails.get(i));
			}
		}
		
		return all;
	}
	
	public static void main(String[] args) {
	
		System.out.println("Enter number: ");
		String number = (new Scanner(System.in)).nextLine();
		
		Vector<String> all = mnemonics(number);
		for(String s : all) {
		
			System.out.println(s);
		}
	}
}
