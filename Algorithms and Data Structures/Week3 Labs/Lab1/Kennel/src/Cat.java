
class Cat extends Animal {

	int livesLeft = 9;

	public Cat(String n) {
		super(n);
		// TODO Auto-generated constructor stub
	}
	
	public int getLivesLeft() {
		return livesLeft;
	}

	public void loseLife() {
		livesLeft -= 1;
		if (livesLeft == 0) {
			System.out.print("the cat is dead");
		}
	}
	
	public String toString() {
		String msg = "This is a cat: " + name + " with " + livesLeft + " lives left";
		return msg;
	}

}
