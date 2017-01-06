package javaDemos.mod12interface;

public class Robin extends Animal {

	public Robin() {
		super(2);
	}

	@Override
	public void eat() {
		System.out.println("Robin eats worms");
	}

	@Override
	public void move() {
		System.out.println("Robin flys");
	}
}
