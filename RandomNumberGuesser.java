/* Class: CMSC203 CRN 
 Program: Assignment # 2 Design
 Instructor: Ahmed Tarek
 Summary of Description: Build an application that will receive a guess and report if your guess is the random number that was generated.  
 Your application will narrow down the choices according to your previous guesses and continue to prompt you to enter a guess until you guess correctly.  

 Due Date: 02/23/2021
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
 Programmer Name: Benz Jeither Tamayo

*/


import java.util.Scanner;               

public class RandomNumberGuesser {

	public static void main(String[] args) {
	
		// Declare variables that will be used throughout the program
		int randNum;
		int lowGuess = 0;
		int highGuess = 100;
		int nextGuess;
		String answer;
		int count = 1;
		
		randNum = RNG.rand();      // calling the rand() method from RNG class in order to get a random number and assign it to the variable randNum

		Scanner keyboard = new Scanner(System.in);       // Create a new object of type Scanner that reads from the keyboard
		System.out.println("Enter your first guess");     // Prompt the user to enter their first guess
		nextGuess = keyboard.nextInt();
		System.out.println("Number of guesses is " + RNG.resetCount() ); // Display the current number of guesses of the user
		
		
		// Create a do-while loop to be able to repeat the following program if the user wanted to
		do {
			if(RNG.inputValidation(nextGuess, lowGuess, highGuess)) {
				
				 // Execute the following code if the user's input is less than the random number
				if (nextGuess < randNum) { 
					lowGuess = nextGuess;
					System.out.println("Your guess is too low.");
					System.out.println("Enter your next guess between " + lowGuess + " and " + highGuess);
					nextGuess = keyboard.nextInt();
					System.out.println("Number of guesses is " + ++count);;
				}
				// Execute the following code if the user's input is greater than the random number
				else if(nextGuess > randNum) {       
					highGuess = nextGuess;
					System.out.println("Your guess is too high.");
					System.out.println("Enter your next guess between " + lowGuess + " and " + highGuess);
					nextGuess = keyboard.nextInt();
					System.out.println("Number of guesses is " + ++count);;
				}
			}
			
			else {
				nextGuess = keyboard.nextInt(); //Prompt the user again for their next guess if their previous input was out of range
			}
		}while (nextGuess!=randNum); //Repeat this loop until the user guessed the random number correctly

		// Execute the following code if the user guessed the random number correctly
		if (nextGuess == randNum) {
			System.out.println("Congratulations, you guessed correctly.");
			
			// Prompt the user if they wanted to repeat the code
			System.out.println("Try again? (yes or no)");
			keyboard.nextLine();
			answer = keyboard.nextLine();
			
			//repeat the code if the answer is yes 
			if(answer.equalsIgnoreCase("yes")) {
				main (args);     // this statement has the ability to repeat or execute the main method program
			}
			else {
				System.out.println("Thanks for playing. . ."); // Give thanks to the user after using the program
				keyboard.close();         
			}
		}

		System.out.println("\n\nProgrammer: Benz Jeither Tamayo");
	}

}
