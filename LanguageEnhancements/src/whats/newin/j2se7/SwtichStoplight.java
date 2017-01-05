package whats.newin.j2se7;

import java.io.IOException;
import java.io.InputStreamReader;

public class SwtichStoplight {
	private static final String Green = "green";
	private static final String Yellow = "yellow";
	private static final String Red = "red";

	private String color;                              
	SwtichStoplight(String c) {	this.color = c;	}        // store string

	
	public static void main(String[] args) {
		SwtichStoplight lightOld = new SwtichStoplight(Red);
		lightOld.printActionOld();                       // Determine color old way

		pauseConsole("Compare Strings using Switch");    
		
		SwtichStoplight lightNew = new SwtichStoplight(Green);
		lightNew.printActionNew();                      // Determine color with Switch
	}
	
	/** Old String Compare - chained if-then-else clauses
	 */
	public void printActionOld() {
		String action = "Unknown";

		if (color == null) {                           // no NullPointerExceptions
			System.out.println("Color is Null!");
		} else {
			if (color.equalsIgnoreCase("Green"))       // ignore case on equal
				action = "Go";
			else if (color.equalsIgnoreCase("Yellow"))
				action = "Slow Down";
			else if (color.equalsIgnoreCase("Red"))
				action = "Stop";
			System.out.println("The stoplight color is " + color + ", so "	+ action + "!");
		}
	}

	/** compare String in Switch Statement 
	 */
	public void printActionNew() {
		String action = "Unknown";
		if (color == null)  {                  // no NullPointerExceptions
			System.out.println("Color is Null!");			
		}
		else {
			switch (color.toLowerCase()) {    // case sensitive
			case Green:
				action = "Go";
				break;
			case Yellow:
				action = "Slow Down";
				break;
			case Red:
				action = "Stop";
				break;
			default:
				break;
			}
			System.out.println("The stoplight color is " + color + ", so " + action	+ "!");
		}
	}


	

	private static void pauseConsole(String doNext) {
		try {
			InputStreamReader cin = new InputStreamReader(System.in);
			System.out.println("\nHit Enter to "+ doNext +":>");
			cin.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
