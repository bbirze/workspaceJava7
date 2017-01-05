package whats.newin.j2se7;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Set;

public class BCP47Support {
	 
	 public void localeOut(Locale loc, String comment)  {
		 System.out.println(comment + ":\n" +
				 "Locale.toString(): " + loc.toString() + "\t" + 
				 "Locale.toLanguageTag(): " + loc.toLanguageTag()  +"\n\t" +
				 "getLanguage()     : <" + loc.getLanguage()    +">\n\t" +
				 "getScript()       : <" + loc.getScript()      +">\n\t" +
				 "getCountry()      : <" + loc.getCountry()     +">\n\t" +
				 "getDisplayScript(): <" + loc.getDisplayScript()+">");
	 }
		
	public static void main(String[] args) {
		BCP47Support lc = new BCP47Support();
		Locale gLocale;
		gLocale = new Locale.Builder().setLanguage("EN").setScript("latn").setRegion("gb").build();
	    lc.localeOut(gLocale, "Create Locale with new Locale.Builder nested class");

		pauseConsole("Create Locale with new forLanguageTag() factory method");
		 
		gLocale = Locale.forLanguageTag("ja-Jpan-JP");
	    lc.localeOut(gLocale, "Create an IEFT BCP 47 enabled Locale with new Locale.forLanguageTag()");
	    
	    gLocale = Locale.CANADA_FRENCH;
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


