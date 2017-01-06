package labs.solutions.lab05;

public class Operators {

	public static void main(String[] args) {
		int val1 = 5;
		int val2 = 10;
		
		// SimpleComparisons
		if (val1 == val2)
			System.out.println("val1 == val2 expect false got : " + (val1 == val2));
		if (val1 != val2)
			System.out.println("val1 != val2 expect true got : " + (val1 != val2));
		if (val1 > val2)
			System.out.println("val1 > val2 expect false got : " + (val1 > val2));
		if (val1 >= val2)
			System.out.println("val1 >= val2 expect false got : " + (val1 >= val2));
		if (val1 < val2)
			System.out.println("val1 < val2 expect true got : " + (val1 < val2));
		if (val1 <= val2)
			System.out.println("val1 <= val2 expect true got : " + (val1 <= val2));
		
		//Using conditional operators
		if((val1 == 5) && (val2 == 10))
            System.out.println("(val1 == 5) && (val2 == 10) expect true got: : " 
            					+ ((val1 == 5) && (val2 == 10)));
        if((val1 == 11) || (val2 == 10))
            System.out.println("(val1 == 11) || (val2 == 10) expect true got: " 
            					+ ((val1 == 11) || (val2 == 10)));        
        // Precedence
        int answer = 4 + 5 * 6 << 4 / - 2;
        System.out.println("4 + 5 * 6 << 4 / - 2 = " + answer);
        
        answer = (4 + (5 * 6)) << (4 / (- 2));
        System.out.println("(4 + (5 * 6)) << (4 / (- 2)) = " + answer);
	}
}
