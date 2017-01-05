package bbirze.javafund.basic;

public class Stoplight {

	final public String nextLight(String curColor)  {
		switch(curColor)
		{
		case "Green": return "Red";
		case "Yellow":return "Red";
		case "Red"  : return "Green";
		}
		return "Red";
	}
	
	
	public static void main(String[] args) {
		byte b= 4;
		Byte b1 = new Byte((byte)4);

		
		

		Byte b2 = new Byte(b);
		Byte b3 = b1;
		System.out.println("(b1 == b2) = " + (b1==b2));  // false
		System.out.println("(b1 == b3) = " + (b1==b3));  // true
		System.out.println("(b2 == b3) = " + (b2==b3));  // false

		int a = 4 + 5 * 6;
		System.out.println("a = " + a); 
		a = (4 + 5) * 6;
		System.out.println("a = " + a); 
		
		
		int x=5, y=5;
		 int val;

		 val = 10 + ++x;  // val=16  x=6
		 System.out.println("++x  val:" +val+"  x:" + x +"  y:" + y);
		 val = 10 + y++;  // val=15  y=6
		 System.out.println("++x  val:" +val+"  x:" + x +"  y:" + y);

		 x=y=20;
		 val = 10 + --x;  // val=29  x=19
		 System.out.println("++x  val:" +val+"  x:" + x +"  y:" + y);
		 val = 10 + y--;  // val=30  y=19
		
		System.out.println("++x  val:" +val+ "  x:" + x +"  y:" + y);
		
		if (x == y) {
			val = x;
		}
		else {
			val = y;
		}
	
		val = (x == y ? x : y);

		int[] ary = new int[3];
		System.out.println("ary[...]" + ary[0]+ "  " + ary[1] +"  " + ary[2]);
		
	}

}
