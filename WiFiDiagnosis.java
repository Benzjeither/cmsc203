/*
 * Class: CMSC203 
 * Instructor: Prof. Ahmed Tarek
 * Description: Build an application that will step through some possible problems to restore internet connectivity.  Assume that your computer 
 * 				uses wi-fi to connect to a router which connects to an Internet Service Provider (ISP) which connects to the Internet.
 * Due: 2/09/2021
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Benz Jeither Tamayo
*/


import java.util.Scanner;

public class WiFiDiagnosis {

	public static void main(String[] args) {
		

		Scanner scanner = new Scanner(System.in); // Created scanner object to get user's input

		System.out.print("If you have a problem with internet connectivity,");
		System.out.println("this WiFi Diagnosis might work. \n");
		
		System.out.println("First step: Reboot the computer and try to connect");
		System.out.println("Are you able to connect with the internet? (yes or no)");   // Ask the user if the first step works
		
		String answer; 			// Declared a string variable named answer to store user's input
		answer = scanner.next();  //Ask the user for input
		
		if(answer.equalsIgnoreCase("yes")){
			System.out.println("Rebooting your computer seemed to work.");     // display this message if the answer is yes
		}
		else{
			System.out.println("Second Step: Reboot the router and try to connect");
			System.out.println("Are you able to connect with the internet? (yes or no)");  // Ask the user if the second step works
			answer = scanner.next(); //Ask the user for input
			
			if(answer.equalsIgnoreCase("yes")) {
				System.out.println("Rebooting your router seemes to work");   // display this message if the answer is yes
			}
			else {
				System.out.println("Third Step: Make sure the cables connecting the router are firmly plugged in and power is getting to the router.");
				System.out.println("Are you able to connect with the internet? (yes or no)");     //Ask the user if the third step works
				answer = scanner.next(); //Ask the user for input
				
				if(answer.equalsIgnoreCase("yes")) {
					System.out.println("Making sure the cables are plugged in seemes to work."); // display this message if the answer is yes
				}
				else {
					System.out.println("Fourth Step: Move the computer closer to the router and try to connect.");
					System.out.println("Are you able to connect with the internet? (yes or no)");   // Ask the user if the fourth step works
					answer = scanner.next(); //Ask the user for input
					scanner.close();
					if(answer.equalsIgnoreCase("yes")) {
						System.out.println("Making sure the cables are plugged in seemes to work."); // display this message if the answer is yes
					}
					else {
						System.out.println("Fifth Step: Contact your ISP");
					}
				}
				
			}
		}


	}
	
}
		
		
		
		

