
/**
 * Favourite class to test a string object and it's methods.
 * 
 * @version (2020/09/13)
 */

import java.util.*;

public class WrappedUp
{
	
	public void guessMyFavouriteThing()
	{
	   //Create a string object with your favourite animal, car ..whatever
	   //e.g String favMotorBikeManufacturer = "bmw"
	   String myFavCar = "Focus";
	   /* Now prompt for a guess - using the Scanner class
	   ** Using String methods, you should give the length 
	   ** and first letter of your favourite thing in the prompt.
	   */
	   System.out.println("Guess my favouriate car: the word should start with 'F' and contain 5 characters:");
	   Scanner sc = new Scanner(System.in);
	   String guess = sc.next();
	  
	  
	  // Now test if the guess was correct - ignore case 
	   if (guess.equalsIgnoreCase(myFavCar)) {
		   System.out.println("You got it!");
	   } else {
		   System.out.println("Sorry, wrong!");
	   }
	 
	
	}//end guessing


	public static void main(String args[]) {
		//Create WrappedUp object and test the methods
		WrappedUp w = new WrappedUp();
		w.guessMyFavouriteThing();
	}
}
