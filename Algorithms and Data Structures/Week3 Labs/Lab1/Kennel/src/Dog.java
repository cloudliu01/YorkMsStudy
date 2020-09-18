
class Dog extends Animal {
	
	public Dog(String n) {
		super(n);
		// TODO Auto-generated constructor stub
	}

	int exerciseTime;
	
	public void setExercistTime (int n) {
		exerciseTime = n;
	}

	public int getExercistTime () {
		return exerciseTime;
	}
	
	public String toString () {
		String msg = "This is an dog: " + name + " who requires " + 
					exerciseTime + " minutes exercise each day";
		//System.out.println(msg);
		return msg;
	}

}
