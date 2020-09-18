
public class TestAnimal {

	public static void main(String[] args) {
		Animal a = new Animal("A");
		System.out.println(a.getName());
		System.out.println(a);

		Cat c = new Cat("C");
		System.out.println(c);
		while (c.getLivesLeft() > 0) {
			c.loseLife();
		}

		Dog d = new Dog("D");
		d.setExercistTime(30);
		System.out.println(d);

	}

}
