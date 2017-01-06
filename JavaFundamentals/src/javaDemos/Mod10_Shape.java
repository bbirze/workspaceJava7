package javaDemos;

abstract public class Mod10_Shape {

	public Mod10_Shape() {
		// TODO Auto-generated constructor stub
	}

	abstract public void drawMe();
	
	public static void main(String[] args) {
		Mod10_Shape[] shapes = new Mod10_Shape[3];
		
		shapes[0] = new Mod10_Circle();
		shapes[1] = new Mod10_Square();
		shapes[2] = new Mod10_Triangle();
		
		for (int i=0; i < shapes.length; i++) {
			shapes[i].drawMe();
		}
	}

}
