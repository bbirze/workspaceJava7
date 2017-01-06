package javaDemos;

public class Mod09_Shape {
	
	protected int x;
	protected int y;
	protected int pixels;
	
	public Mod09_Shape(int x, int y, int pixels) {
		this.x = x;
		this.y = y;
		this.pixels = pixels;
	}

	public String toString() {
		return "Coordinates (" + x + "," + y + ") size " + pixels + " pixels";
	}
	
	public static void main(String[] args) {
		Mod09_Shape[] shapes = new Mod09_Shape[3];
		float radius = 4.5F; 
		int xCoord = 4;
		int yCoord = 6;
		int pixels = 150;
		
		shapes[0] = new Mod09_Circle(radius, xCoord, yCoord, pixels);

		float side = 55.2F;
		shapes[1] = new Mod09_Square(side, xCoord, yCoord, pixels);

		float side1 = 25.0F;
		float side2 = 25.0F;
		float side3 = 43.1F;
		shapes[2] = new Mod09_Triangle(side1, side2, side3, xCoord, yCoord, pixels);
		
		for (int i=0; i < shapes.length; i++) {
			System.out.println("Shape properties: " + shapes[i]);
		}
	}

}
