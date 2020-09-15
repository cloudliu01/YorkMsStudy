
/**
 * To demonstrate boolean.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Person
{
	double cmHeight = 140; 
	double kgWeight = 160;
	boolean smoker = true;
	int weeklyAlcholUnits = 50;
	final int RWAL = 21;   //RWAL - Recommended Weekly Alcohol Limit
	int restPulse = 160;
	String gender = "male";
	
	public void checkPulse()
	{
	   boolean healthyPulse;
	   healthyPulse = ((restPulse > 30) && (restPulse < 180));
	   System.out.print("Healthy pulse = ");
	   System.out.println(healthyPulse);
	}
	
	public void checkForAbuse()
	{
	      boolean abuser ;
	      abuser = ((weeklyAlcholUnits > RWAL) || (smoker) );
	      System.out.print("Checking for abuse -- ");
	      System.out.println(abuser);
	
	}
	
	public void checkDesirability()
	{
		boolean desirable = ((cmHeight < 150) && (kgWeight > 100) && (smoker));
		if (desirable) {
			System.out.println("Desirable = " + desirable);
		}
	}
	
	public void displayDetails()
	{
	   System.out.println("gender = " + gender);
	   System.out.println("cmHeight = " + cmHeight);
	   System.out.println("kgWeight = " + kgWeight);
	   System.out.println("smoker = " + smoker);
	   System.out.println("weeklyAlcholUnits = " + weeklyAlcholUnits);
	   System.out.println("RWAL = " + RWAL);
	   System.out.println("restPulse = " + restPulse);
	   
	}
	
}
