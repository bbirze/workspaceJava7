package whats.newin.j2se7;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class UnicodeUpdates {
	                                        // Specify Unicode code points
	 public static final String LatinA = "\u0041";
	 public static final String HanForEast = "\u6771";

	 public void regExUpdates() {
		                                    // Unicode General Category Property Matching
		String pat1 = "\\p{IsL}";                   // is it unicode?
		String pat2 = "\\P{IsL}";                   // is it Not unicode?
		String pat3 = "\\p{general_category=L}";    // use general_category keyword
		String pat4 = "\\P{gc=L}";                  // use gc keyword
		System.out.println("Use General Category to match against pattern LatinA <\\u0041> \n\t" +
				"Pattern: "+pat1 + "  is it Unicode? "    + Pattern.matches(pat1, LatinA) + "\n\t" +
				"Pattern: "+pat2 + "  is it Not Unicode? "+ Pattern.matches(pat2, LatinA) +"\n\t" +
				"Pattern: "+pat3 + "  is it Unicode? "    + Pattern.matches(pat3, LatinA) +"\n\t" +
				"Pattern: "+pat4 + "  is it Not Unicode? "+ Pattern.matches(pat4, LatinA)
				);
		
		                                    // Unicode Script Property Character Matching
		pauseConsole("see Script Property Types");
		pat1 = "\\p{IsLatin}";                      // is it supported by the Latin script?
		pat2 = "\\P{IsLatin}";                      // is it Not supported by the Latin script?
		pat3 = "\\p{script=Han}";                   // is it supported by the Han script?
		pat4 = "\\P{IsHan}";                        // is it Not supported by the Han script?
		System.out.println("\nMatch against Script Property of LatinA <\\u0041> \n\t" +
				"Pattern: "+pat1 + " is supported by Latin script? "    + Pattern.matches(pat1, LatinA) + "\n\t" +
				"Pattern: "+pat2 + " is Not supported by Latin script? "+ Pattern.matches(pat2, LatinA) +"\n\t" +
				"\nMatch against script HanForEast <\\u6771>  \n\t" +
				"Pattern: "+pat3 + " is supported by Han script? "    + Pattern.matches(pat3, HanForEast) +"\n\t" +
				"Pattern: "+pat4 + " is Not supported by Han script? "+ Pattern.matches(pat4, HanForEast)
				);

		                                    // Unicode Block Property Character Matching
		pauseConsole("see Unicode Block Property Types");
		pat3 = "\\p{block=Mongolian}";
		pat4 = "\\P{InMongolian}";  
		System.out.println("\nMatch against Block Property of LatinA <\\u0041> \n\t" +
				"\nPattern: " +pat3 + " is supported by Latin block"     + Pattern.matches(pat3, LatinA) +
				"\nPattern: " +pat4 + " is Not supported by Latin block" + Pattern.matches(pat4, LatinA)
				);
	 }
	
		
	public static void main(String[] args) {
		UnicodeUpdates uu = new UnicodeUpdates();
		
		uu.regExUpdates();
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
