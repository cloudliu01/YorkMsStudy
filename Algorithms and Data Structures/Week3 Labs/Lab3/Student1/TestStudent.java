import phd.PhDStudent;

public class TestStudent {

	public static void main(String[] args) {
		PhDStudent s=new PhDStudent();
		s.setName("Lizhuang Liu");
		s.setID("123456");
		s.setCredits(99);
		s.setResearchArea("CS");
		s.addCredits(1);
		s.displayDetails();
	}

}
