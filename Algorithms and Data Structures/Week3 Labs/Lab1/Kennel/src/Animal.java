
public class Animal {

	String name;
	
	public Animal (String n) {
		name = n;
	}
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		String msg = "This is an Animal: " + name;
		return msg;
	}


}
