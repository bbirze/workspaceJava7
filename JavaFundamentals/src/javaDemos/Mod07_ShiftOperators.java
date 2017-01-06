package javaDemos;

public class Mod07_ShiftOperators {

	public static void main(String[] args) {
		int x = -30871;
		System.out.println("x signed int = " + x);
		System.out.println("x = " + Integer.toBinaryString(x) + " : " + x );
		
		x = x >> 2;         // signed shift, fill with sign bit
		System.out.println("x signed right shift 2, fill with sign bit");
		System.out.println("x = " + Integer.toBinaryString(x) + " : " + x );
		
		x = x >>> 2;        // unsigned shift, fill with zeros
		System.out.println("x unsigned right shift 2, fill with zero");
		System.out.println("x = " + Integer.toBinaryString(x) + " : " + x );

		int y = 2465;
		System.out.println("\ny signed int = " + y);
		System.out.println("y = " + Integer.toBinaryString(y)  + " : " + y);

		y >>>= 2;
		System.out.println("y signed right shift 2, fill with sign bit");
		System.out.println("y = " + Integer.toBinaryString(y)  + " : " + y);

		y >>= 2;
		System.out.println("y unsigned right shift 2, fill with zero");
		System.out.println("y = " + Integer.toBinaryString(y)  + " : " + y);
	}
}
