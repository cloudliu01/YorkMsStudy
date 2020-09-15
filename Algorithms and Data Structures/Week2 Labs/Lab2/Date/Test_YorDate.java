// File: Test_YorDate.java
/**
 * Test harness for YorDate class
 *
 * @author	Lizhuang Liu
 * @version	13 Sep 2020 */
 
public class Test_YorDate
{
	public static void main(String args[])
	{
		//Create a reference to a YorDate object
		YorDate date1;
			
	    // This creates an object which sets the date to the current date
		 date1 = new YorDate();
		
		//Using the appropriate methods set, set date1 to your birthdate
		 YorDate date2 = new YorDate(21, 7, 1981);
		 date1.setDay(date2.getDay());
		 date1.setMonth(date2.getMonth());
		 date1.setYear(date2.getYear());
		
		//Using appropriate date1 method(s) display your birthday
		 System.out.println("You were borned on: " + date1.getDayOfWeek());
		
		
	}
}