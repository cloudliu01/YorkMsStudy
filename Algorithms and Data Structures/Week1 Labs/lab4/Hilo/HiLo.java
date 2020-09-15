/*
 * @author Tommy Yuan
 * The purpose is to practise the use of if statement.
 * 
 * */


import java.util.*;

public class HiLo {
    
     int random;
     int guess;
    
    public void generateNumber() 
    {
       //The following lines generate and output a random number between 1 and 100
        random = (int)(Math.random()*100)+1;
    }
    
   //Write the guess() method below 
   public void guess()
   {
	   //Use scanner to accept a user input 
	   //Create a new scanner object to receive user input
	      Scanner sc=new Scanner(System.in);
	    
	      System.out.println("Enter you guess ");
	      guess = sc.nextInt();
	      
	      //write your code below
	      if (guess == random) {
	    	  System.out.println("Hit");
	      } else if (guess < random) {
	    	  System.out.println("Low");
	      } else {
	    	  System.out.println("High");
	      }
   }
   
   //Write startGuessing method here
   public void startGuessing() {
	   int n = 0;
	   do {
		   guess();
		   System.out.printf("%d: %d <=> %d\n", n, guess, random);
		   n += 1;

	   }
	   while (guess != random);
	   System.out.println("You hit it!!");
   }
    
}
 