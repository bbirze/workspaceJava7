package javaDemos.mod12interface;

public class Snake extends Animal {

	public Snake() {
		super(0);
	}

	@Override
	public void eat() {
		System.out.println("Snake eats rodents");
	}

	@Override
	public void move() {
		System.out.println("Snake crawls");		
	}
}
