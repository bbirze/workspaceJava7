package whats.newin.j2se7;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Set;

public class LocalExtensions {

	public void LocaleUpdates() {
		Locale gLocale = new Locale("en", "US");
		gLocale = new Locale.Builder().setLanguage("en")
				.setExtension(Locale.UNICODE_LOCALE_EXTENSION, "ca-gregory-nu-roman" )
				.setExtension(Locale.PRIVATE_USE_EXTENSION, "jkd-1-7-I-can-be-Anything")
				.addUnicodeLocaleAttribute("email")
				.addUnicodeLocaleAttribute("ASCII")
				.setRegion("gb").build();
	      
	      System.out.println("Locale.UNICODE_LOCALE_EXTENSION = " + Locale.UNICODE_LOCALE_EXTENSION +
	    	               "\nLocale.PRIVATE_USE_EXTENSION    = " + Locale.PRIVATE_USE_EXTENSION);
	      System.out.println("Unicode Locale Attributes: " + gLocale.getUnicodeLocaleAttributes());

	      pauseConsole("see Unicode Locale Keys and Values");
	      System.out.println("Unicode Locale Extensions include: ");
	      
	      Set<String> ss = gLocale.getUnicodeLocaleKeys();
	      for (String key: ss) {
		      System.out.println("\tKey <"+key+"> type is " + gLocale.getUnicodeLocaleType(key));
	      }
	      
	      pauseConsole("see All the Locale Extension Keys and Values");
	      System.out.println("Unicode Locale Extensions include: ");

	      Set<Character> cc = gLocale.getExtensionKeys();
	      for (char key: cc) {
		      System.out.println("\tKey <"+key+"> value is " + gLocale.getExtension(key));
	      }
	}

		
	public static void main(String[] args) {
		LocalExtensions lc = new LocalExtensions();

		lc.LocaleUpdates();
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


