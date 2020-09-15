
/**
 * Write a description of class Lotto here.
 * 
 * @author (Lizhuang Liu) 
 * @version (Sep 9, 2020)
 */
public class Lotto
{
	
	//Put the luckyDip() method here
	
	protected static void luckyDip () {
		int random;
		for (int i=0; i<6; i++) {
			random = (int) (Math.random()*49) + 1;
			System.out.printf("Ball %d = %d\n", i, random);
		}
	}






        //Test
	public static void main (String args[]) {
		
		Lotto l=new Lotto();
		l.luckyDip();
	}

	
}
