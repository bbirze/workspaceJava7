package whats.newin.j2se7;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Set;

public class LocalAdditionalUpdates {

	 public static final String LatinA = "\u0041";
	 public static final String HanForEast = "\u6771";

	public void localeUpdates() {
	      Locale uslocale = new Locale("en", "US");
	      System.out.println("Created Locale, start with:\n\tDisplay Locale: " + Locale.getDefault(Locale.Category.DISPLAY) +
	    		             "\n\tFormat Locale : " + Locale.getDefault(Locale.Category.FORMAT));

	      // Set both locale categories
	      Locale.setDefault(Locale.Category.FORMAT, new Locale("fr", "FRANCE", "MAC"));
	      Locale.setDefault(Locale.Category.DISPLAY, new Locale("no", "NORWAY", "NY"));
	      System.out.println("\nSet Locale Display to Norway and Format to France:\n\tDisplay Locale: " + Locale.getDefault(Locale.Category.DISPLAY) +
		             "\n\tFormat Locale : " + Locale.getDefault(Locale.Category.FORMAT));
	     
	      Locale.setDefault(Locale.Category.FORMAT, uslocale);
	      Locale.setDefault(Locale.Category.DISPLAY, uslocale);
	      System.out.println("\nReSet Locale Display and France:\n\tDisplay Locale: " + Locale.getDefault(Locale.Category.DISPLAY) +
		             "\n\tFormat Locale : " + Locale.getDefault(Locale.Category.FORMAT));
	      
	      pauseConsole("see New Locale Instatiation");
	      Locale gLocale = new Locale.Builder().setLanguage("en").setRegion("GB").build();
	      System.out.println("Create Locale with new Locale.Builder nested class:\n\tLocale: " + gLocale.getDefault());

	      gLocale = Locale.forLanguageTag("ja-JP-u-ca-japanese");
	      System.out.println("\nCreate a IEFT BCP 47 enabled Locale with new Locale.forLanguageTag():"
		      	+ "\n\t getCountry()     : " +  gLocale.getCountry() 
		      	+ "\n\t getISO3Country() : " +  gLocale.getISO3Country() 
	      		+ "\n\t getLanguage()    : " +  gLocale.getLanguage() 
	      		+ "\n\t getISO3Language(): " +  gLocale.getISO3Language() 
	      		+ "\n\t toLanguageTag()  : " +  gLocale.toLanguageTag() +" (IETF BCP 47 tag)");

	      Set<String> ss = gLocale.getUnicodeLocaleKeys();
	      System.out.print("\nLocal Keys include: ");
	      String key = null;
	      for (String s: ss) {
	    	  System.out.print(s + " ");
	    	  key = s;
	      }
	      System.out.println("\nLocal Type for Key <"+key+"> is " + gLocale.getUnicodeLocaleType(key));
	}

		
	public static void main(String[] args) {
		LocalAdditionalUpdates lc = new LocalAdditionalUpdates();

		lc.localeUpdates();
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


