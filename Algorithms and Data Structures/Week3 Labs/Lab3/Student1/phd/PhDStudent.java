/**
   Class:   PhD Student
   Author:  Lizhuang Liu
   Date:    Sep 26 2020
  Access control experiment:
 */

package phd;

import student.*;

public class PhDStudent extends Student
{
	String researchArea;
	
	public PhDStudent() {
		// TODO Auto-generated constructor stub
	}
	
    public void setResearchArea(String area) {
		
		researchArea=area;
	}
	
	public String getResearchArea() {
		
		return researchArea;
	}
	
	public void displayDetails(){
		
		System.out.println("Credits =" + super.credits); 
		
		//Try this, 
		System.out.println("ID =" + super.getStudentID());
	}
	

}


