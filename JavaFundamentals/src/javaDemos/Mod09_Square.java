package javaDemos;

public class Mod09_Square extends Mod09_Shape {
	float sideSize;

	public Mod09_Square(float side, int x, int y, int pixels) {
		super(x, y, pixels);
		sideSize = side;
	}
	
	public String toString() {
		return "I am a Square with side size (" + sideSize + ") and " + super.toString();
	}

}
