import java.util.Scanner;

public class MovieDriver {
			
	public static void main(String[] args) {

		 String answer;
		do {
			
			Scanner keyboard = new Scanner(System.in); // Create a new object of type Scanner that reads from the keyboard
			
			Movie movieInfo = new Movie();   //Create a new movie object
			System.out.println("Enter the name of the movie: "); //Prompt the user to enter the title of a movie 
			String movieTitle = keyboard.nextLine();  //Read in the line that the user types
			movieInfo.setTitle(movieTitle); //Set the title in the movie object
			
			System.out.println("Enter the rating of the movie: "); //Prompt the user to enter the movie’s rating
			String rating = keyboard.nextLine(); //Read in the line that the user types
			movieInfo.setRating(rating); //Set the rating in the movie object
			
			System.out.println("Enter the number of tickets sold for this movie: "); //Prompt the user to enter the number of tickets sold at a (unnamed) theater
			int ticketSold = keyboard.nextInt(); //Read in the integer that the user types
			movieInfo.setSoldTickets(ticketSold); // Set the number of tickets sold in the movie object

			
			System.out.println(movieTitle+" ("+rating+"): Tickets Sold: "+ticketSold); //Print out the information using the movie’s toString method

			
			System.out.println("\nDo you want to enter another? (yes or no)"); // Ask the user if they want to repeat the program
			keyboard.nextLine();
			answer = keyboard.nextLine();

			
		}while (answer.equalsIgnoreCase("yes"));  //repeat the program if the answer is yes
		
		
		System.out.println("Goodbye!"); // say goodbye to the user after using the program
		
		System.exit(0);
		
	}
}

