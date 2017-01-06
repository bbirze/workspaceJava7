package javaDemos.mod12interface;

public class Rabbit extends Animal {

	public Rabbit() {
		super(4);
	}

	@Override
	public void eat() {
		System.out.println("Rabbit eats carrots");
	}

	@Override
	public void move() {
		System.out.println("Rabbit hops");
	}
}
