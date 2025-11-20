/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
        String s1 = preProcess(str1);
        String s2 = preProcess(str2);
        
        if (s1.length() != s2.length()) {
            return false;
        }
        
        StringBuilder tempS2 = new StringBuilder(s2);
        
        // 4. Iterate over every character in the first string (s1)
        for (int i = 0; i < s1.length(); i++) {
            char charFromS1 = s1.charAt(i);
            boolean found = false;
            

            for (int j = 0; j < tempS2.length(); j++) {
                if (charFromS1 == tempS2.charAt(j)) {
                    tempS2.deleteCharAt(j);
                    found = true;
                    break; 
                }
            }
            
            if (!found) {
                return false;
            }
        }
        
        return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		// Replace the following statement with your code
	StringBuilder result = new StringBuilder();
        
        String lowerStr = str.toLowerCase();
        
        for (int i = 0; i < lowerStr.length(); i++) {
            char c = lowerStr.charAt(i);
            
            if (Character.isLetter(c)) {
                result.append(c);
            }
        }
        
        return result.toString();
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		// Replace the following statement with your code
        StringBuilder availableChars = new StringBuilder(str);
        StringBuilder randomAnagram = new StringBuilder();

        java.util.Random rand = new java.util.Random();
        
        while (availableChars.length() > 0) {
            int randomIndex = rand.nextInt(availableChars.length());
            
            char randomChar = availableChars.charAt(randomIndex);
            
            randomAnagram.append(randomChar);
            
            availableChars.deleteCharAt(randomIndex);
        }
        
        return randomAnagram.toString();
	}
}
