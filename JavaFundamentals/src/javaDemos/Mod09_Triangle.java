package javaDemos;

public class Mod09_Triangle extends Mod09_Shape {
	float side1Size;
	float side2Size;
	float side3Size;
	
	public Mod09_Triangle(float side1, float side2, float side3, int x, int y, int pixels) {
		super(x, y, pixels);
		side1Size = side1;
		side2Size = side2;
		side3Size = side3;
	}

	public String toString() {
		return "I am a Triangle with side sizes (" + side1Size +"," + side2Size + "," + 
				side3Size + ") and " + super.toString();
	}

}
