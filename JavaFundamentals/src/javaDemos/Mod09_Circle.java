package javaDemos;

public class Mod09_Circle  extends Mod09_Shape {
	protected float radius;
	
	public Mod09_Circle(float rad, int x, int y, int pixels) {
		super(x, y, pixels);
		radius = rad;
	}

	public String toString() {
		return "I am a Circle with radius (" + radius + ") and " + super.toString();
	}
}
