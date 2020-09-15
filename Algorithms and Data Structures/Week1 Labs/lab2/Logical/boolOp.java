
/**
 * 
 * @author (lizhuang liu) 
 * @version (2020/09/08)
 */
public class boolOp
{
    //Put your data type declarations here - I have put bresult there to hold the results 
    // of your calculations (see the Boolbag example)
      boolean bresult;
      boolean finished = false;
      int  m = 3;
      int  n = 8;

/* Put the code for your calculations in this method.
 * The result of the expression should be calculated and assigned to 'bresult'
 */
   void a_boolOperation()
   {
	System.out.println(( n > m) && ( m < -2)  );
	System.out.println((m > 5) || ! (finished));
	System.out.println(!(n < 5) && !(finished));
   }
    
	
}
