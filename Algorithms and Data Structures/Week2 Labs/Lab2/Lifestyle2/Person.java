
/**
 * To demonstrate boolean.
 * 
 * @author (Lizhuang Liu) 
 * @version (2020/09/13)
 */


public class Person
{
	double cmHeight;
	double kgWeight;
	boolean smoker = true;
	int weeklyAlcholUnits; // 1 pint = 2 units, 1 short = 1 unit)
	final int RWAL = 21;   //RWAL - Recommended Weekly Alcohol Limit
	int restPulse;
	YorDate dateOfBirth; 
	String name;

	public Person(String inName, int day, int month, int year) {
		name = inName;
		dateOfBirth = new YorDate(day, month, year);
	}
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
	   System.out.println("Name = " + name);
	   int y = dateOfBirth.getYear();
	   int m = dateOfBirth.getMonth();
	   int d = dateOfBirth.getDay();
	   System.out.printf("DoB  = %d/%d/%d\n", y, m, d); 
	   System.out.println("………Health Profile……");
	   
	   System.out.println("Healthy pulse check = " + checkPulse());
	   System.out.print("Abusing Body = " + checkAbuser());
	   
	}
	
	
}
