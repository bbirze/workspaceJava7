package bbirze.javafund.basic;

class BoxHelper {
	boolean isBoxBig(Box b) {
	  /// do something... 
		return true;
	}
}

public class Box {
	private int width;
	
	
	public  int getInstanceVar() {
		Box bx = new Box(5, 4);
		width++;
		if (true) {
			int width = 20;
		}
		return bx.getWidth();
	}
	
	private int getWidth() {
		return width;
	}

	private void modPrimitive(int num) {
		num = 20;
	}
	
	public void passPrimitaive() {
	   int i = 10;
	   modPrimitive(i);
	}
	
	private int hgt;
	private int depth;
	public static final int DEPTH=1;

	public void passReference() {
	   String s = "Hello";
	   modReference(s);
	   System.out.println("s = " + s);
	}
	
	private void modReference(String s) {
		s = "Bye";
	}
	
	public void passObjByReference() {
		String s = "Hello";
		modObjByReference(s);
		System.out.println("s = " + s);
	}
			
	private void modObjByReference(String s) {
		s.replace("Hello", "Bye");
	}
			

	public Box(int hgt, int width) {
		this(hgt, width, 1);
	}
	public Box(int hgt, int width, int depth) {
		this.hgt = hgt;
		this.width = width;
		this.depth = depth;
	}
}
