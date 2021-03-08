import java.util.Scanner;


public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;
	static Scanner keyboard = new Scanner(System.in);

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	
	public static boolean stringInBounds (String plainText) {
		
		boolean inBounds = true;			// declare boolean variable for a return value and initiliaze it to true
		
		for(int i = 0; i < plainText.length(); i++) {             // for loop to check each character of the plaintext if it's in Bounds
	
			if((int)plainText.charAt(i) < (int)LOWER_BOUND)    // if each character of plaintext is less than the lower bounds then set 
			{												// it to false
				
				inBounds = false;      
			}

			else if((int)plainText.charAt(i) > (int)UPPER_BOUND) 
			{
				inBounds = false;      // if each character of plaintext is greater than the lower bounds then set 
				break;                 // it to false
			}

		}
		
		return inBounds;   // return value (true or false)
		
	//	throw new RuntimeException("method not implemented");

		

	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		
		String encryptedText = "";				// declare a variable an empty String encryptedText 
		int temp = 0;         // declare variable temp to use later in the program

		for(int index = 0; index  < plainText.length(); index++) {	// for loop to keep repeating the program to check each character of the user's input
			
			temp = (int)((plainText.charAt(index) + key));  // Initialize the value of temp by adding the key to each character of plainText
			
			if(temp < LOWER_BOUND)	// if the total value of a character + key is less than the LOWER_BOUND then use a do while loop 
			{						// in order to add 32 to make the character in bounds
				

				do {
					plainText +=(char)(LOWER_BOUND) + temp;     
				}while(temp < LOWER_BOUND);
			
			}

			else if (temp  > UPPER_BOUND) {   // if the total value of a character + key is greater than the UPPER_BOUND 
				
				// use while loop in oder to keep subtracting the value of RANGE to variable temp to make each character in Bounds
				while(temp  > UPPER_BOUND)
				{
					temp -= RANGE;	
				}
	
				encryptedText += (char)(temp); 	// assign the current value of temp into encryptedText
				
			}
			else 
			{
				encryptedText += (char)(plainText.charAt(index) + key); 	// if the entered input is in range, then just assign each character to encrypted Text
		
			}
		} 
		
		return encryptedText;  // return the value of encryptedText 


		
		//	throw new RuntimeException("method not implemented");
		

		
	}	
	
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {
	
		// declaring variables
		String encryptedText = "";
		int temp;
		char perCharacter;
		int result = 0;
		
		for(int index = 0; index <plainText.length(); index++) { 		  //   for loop to keep repeating the program to check each character of the user's input 
			
			perCharacter = (plainText.charAt(index)); // initialize perCharacter by assigning it the value of each character of plaintext
			temp = (index% bellasoStr.length()); // Initialize the value of temp by getting the remainder of index divided by the length of the user's input key

			result = ((int)perCharacter + (int)bellasoStr.charAt(temp)); // add the value of perCharacter and bellasoStr and assign it to result
			
			if(result < (int) LOWER_BOUND)		// if result is less than the lower bound, then add 32 to it to be in bounds
			{
				encryptedText += (char)(LOWER_BOUND);
			}
			
			else if(result > (int)UPPER_BOUND){	     // if result is greater than the upper bound
				while (result > (int)UPPER_BOUND) {   // then, use a while loop to keep subtracting the value of RANGE in order to make each character
					result -= RANGE;                  // of plainText in Bounds
				}
				encryptedText += (char)result;      //assign result to encryptedText

			}
			
			else {
				encryptedText += (char)result;  // if each character of the plainText is in Bounds, then just add result to encryptedText
			}
		
		}
		
		return encryptedText;		// return the value of encryptedText

	//	throw new RuntimeException("method not implemented");

	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		
		
		String decryptedText = "";					// declare and set a String variable decryptedText empty
		int temp = 0;									// declare variable temp to be use later in the program
		
		for(int index = 0; index  < encryptedText.length(); index++) { // use  for loop to keep repeating the program to check each character of the user's input 
			temp = (int)(encryptedText.charAt(index) - key);     // Initialize the value of temp by subtracting the key to each character of plainText
			
			if(temp < LOWER_BOUND) 	// if the total value of a temp  is less than the LOWER_BOUND then use a do while loop
			{                       // in order to add 32 to make the character in bounds
				do {
					temp += RANGE;
				}while(temp < LOWER_BOUND);
				
				decryptedText +=(char)(temp);    // Initialize the value of decryptedText by adding itself to the value of temp
			}
			else if (temp > UPPER_BOUND) { 		// if the total value of a character + key is greater than the UPPER_BOUND 
				
				while(temp > UPPER_BOUND) { 	// use while loop in oder to keep subtracting the value of RANGE to variable temp to make each character in Bounds
					temp -= RANGE;
				}
			
				decryptedText += (char)(temp); 	// Initialize the value of decryptedText by adding itself to the value of temp 	

			}
			
			else {
				decryptedText += (char)temp;    // Initialize the value of decryptedText by adding itself to the value of temp
			}
		
		}
		
		return decryptedText;    // return the value of decryptedText
		
	//	throw new RuntimeException("method not implemented");
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		
		
		// declaring variables
		String decryptedText = "";
		int temp;
		char perCharacter;
		int result = 0;
		
		for(int index = 0; index <encryptedText.length(); index++) {   // use for loop to keep repeating the program to check each character of the user's input 
			
	
			
			perCharacter = (encryptedText.charAt(index)); 	 // initialize perCharacter by assigning it the value of each character of plaintext
			temp = (index% bellasoStr.length()); 			// Initialize the value of temp by getting the remainder of index divided by the length of the user's input key
			
			result = ((int)perCharacter - (int)bellasoStr.charAt(temp)); 	// subtract the value of perCharacter and bellasoStr and assign it to result
			
			

			if ( result < (int)LOWER_BOUND)					// if result is less than the lower bound, then add 32 to it to be in bounds
			{
				do {										// then, use a do while loop to keep adding the value of RANGE in order to make each character
				result += RANGE;							// of plainText in Bounds
					} while (result < (int)LOWER_BOUND);
				
				decryptedText += (char)result;       //Initialize the value of decrypted text by adding itself to the current value of variable result

			}
		
			else if(result >= (int)LOWER_BOUND && result <= (int) UPPER_BOUND)	// if the result is in bounds.
			{	
					
				decryptedText += (char)result;				// then Initialize the value of decrypted text by adding itself to the current value of variable result
			}

		}
		
		return decryptedText; //return the value of decryptedText
		
		
		
	//	throw new RuntimeException("method not implemented");
	}
}