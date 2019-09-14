public class TestPalindrome {

	public static boolean testPalindrome(String str) {
	
		str = str.replaceAll("\\s+",""); // Remove spaces
		str = str.toLowerCase(); // Make lowercase

		if(str.length() == 1 || str.length() == 0) {
		
			return true;
		}
		else {
		
			char first = str.charAt(0);
			char last = str.charAt(str.length() - 1);
			str = str.substring(1, str.length() - 1);
			
			if(first == last) {
			
				return testPalindrome(str);
			}
			else {
			
				return false;
			}
		}
	}
	
	public static void main(String[] args) {
	
		System.out.println("radar: " + testPalindrome("radar"));                                                                                              // true
		System.out.println("Was it a cat I saw: " + testPalindrome("Was it a cat I saw"));                                                                    // true
		System.out.println("pork chop: " + testPalindrome("pork chop"));                                                                                      // false
		System.out.println("123454321: " + testPalindrome("123454321"));                                                                                      // true
		System.out.println("1 2  3 4566 5 4 3          2                      1: " + testPalindrome("1 2  3 4566 5 4 3          2                      1"));  // true
		System.out.println("dogdogdogdogf: " + testPalindrome("dogdogdogdogf"));                                                                              // false
		System.out.println("a: " + testPalindrome("a"));                                                                                                      // true
		System.out.println(": " + testPalindrome(""));                                                                                                        // true
		System.out.println("ab: " + testPalindrome("ab"));                                                                                                    // false
	}
}
