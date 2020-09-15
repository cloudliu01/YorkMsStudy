
/**
 * To demonstrate boolean.
 * 
 * @author (lizhuang liu) 
 * @version (2020/09/20)
 */
import java.util.*;

public class Person
{
	double cmHeight;
	double kgWeight;
	boolean smoker = true;
	int weeklyAlcholUnits; // 1 pint = 2 units, 1 short = 1 unit)
	final int RWAL = 21;   //RWAL - Recommended Weekly Alcohol Limit
	int restPulse;

    public void setHeight(double heightIn)
    {
        cmHeight= heightIn;
    }
       
    public void setWeight(double weightIn)
    {
       kgWeight= weightIn;
    }
    
    public void setPulse(int pulseIn)
    {
        restPulse = pulseIn;
    }
    
    
	public boolean checkPulse()
	{
	   boolean healthyPulse;
	   healthyPulse = ((restPulse > 30) && (restPulse < 180));
	   return healthyPulse;
	}
	
	public boolean checkAbuser()
	{
	      boolean abuser ;
	      abuser = ((weeklyAlcholUnits > RWAL) || (smoker) );
	      return abuser;
	}
	
	public void displayProfile()
	{
	   System.out.println("………Health Profile……");
	   System.out.println("Healthy pulse check = " + checkPulse());
	   System.out.println("Abusing Body = " + checkAbuser());
	   System.out.println("BMI = " + getBMI());
	}
	
	
	public void promptDetail() {
		Scanner sc = new Scanner(System.in);

	    System.out.println("Enter Height ");
	    setHeight( sc.nextDouble());
	    System.out.println("Height set to " + cmHeight);

	    System.out.println("Enter kgWeight ");
	    setWeight(sc.nextDouble());
	    System.out.println("kgWeight set to " + kgWeight);

	    System.out.println("Enter Weekly Alchol Units ");
	    weeklyAlcholUnits = sc.nextInt();
	    System.out.println("Weekly Alchol Units set to " + weeklyAlcholUnits);

	    System.out.println("Enter Rest Pulse ");
	    setPulse( sc.nextInt());
	    System.out.println("Rest Pulse set to " + restPulse);
	}
	
	
	public double getBMI() {
		double bmi = 10000 * kgWeight / (cmHeight * cmHeight);
		return bmi;
	}
}
