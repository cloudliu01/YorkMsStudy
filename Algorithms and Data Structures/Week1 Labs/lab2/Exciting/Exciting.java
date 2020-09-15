
/**
 * Write a description of class Exciting here.
 * 
 * @author (lizhuang liu) 
 * @version (0.1)
 */
public class Exciting
{
    //Put your declarations for a) beneath here 
     double z ;
     int count = 0;
     double cost = 3.45;
     char choice = 'X';
     boolean goodChoice = true;
     short lowest = 5;
    //Put your declarations and initialisations to b) beneath here 
     int temperature = 27;
     int ball = 10;
     long population = 1400000000;
     boolean finished = false;
     double distance = 100.0;
     char grade = 'A';
     
    
   public void doit()
   {
     double x = 3.0;
     double y = 4.0;
     z = 2.0 * y + x/4.0 - (x + y ) ;
   }    
   
   public void displayDetails() 
   {
	   System.out.print("z= ");
	   System.out.println (z);
	   
	   //display the details for the variables you declared in a)
	   System.out.println("------ a ------------------");

	   System.out.println("count = " + count);
	   System.out.println("cost = " + cost);
	   System.out.println("choice = " + choice);
	   System.out.println("goodChoice = " + goodChoice);
	   System.out.println("lowest = " + lowest);
	   //display the details for the variables you declared in b)
	   System.out.println("------ b ------------------");
	   System.out.println("temperature = " + temperature);
	   System.out.println("ball = " + ball);
	   System.out.println("population = " + population);
	   System.out.println("finished = " + finished);
	   System.out.println("distance = " + distance);
	   System.out.println("grade = " + grade);

	   
   }
    
}

	   
    
 