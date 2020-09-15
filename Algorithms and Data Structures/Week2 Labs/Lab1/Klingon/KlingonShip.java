
/**
 * AlienShip - Unit 4 exercise.
 * 
 * @author (lizhuang liu) 
 * @version (2020/09/11)
 */
import java.util.*;

public class KlingonShip
{
	double photonPower = 45;
	int threatFactor = 7;
	double cosmicProximity = 20.6;
	
	//Put the displayKlingonDetails()and getDangerLeve() methods below.
	
	public void displayKlingonDetails() {
		double dangerLevel =  (photonPower * threatFactor)/cosmicProximity;
	    System.out.println("***** Output *******");
		System.out.print("Danger level =\t" + dangerLevel + "\t\n");
	}
	
	public void promptSettings() {
		Scanner sc = new Scanner(System.in);
	    System.out.println("Enter photonPower ");
	    photonPower = sc.nextInt();
	    System.out.println("photonPower set to " + photonPower);
	    System.out.println("Enter threadFactor ");
	    threatFactor = sc.nextInt();
	    System.out.println("threatFactor set to " + threatFactor);
	    System.out.println("Enter cosmicProximity ");
	    cosmicProximity = sc.nextDouble();
	    System.out.println("cosmicProximity set to " + cosmicProximity);
	    
	}
	
	
}
