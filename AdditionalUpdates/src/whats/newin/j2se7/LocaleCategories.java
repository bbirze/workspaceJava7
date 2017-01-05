package whats.newin.j2se7;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class LocaleCategories {

	public void defaultCategories() {
		Locale jvmDefaultLocale = Locale.getDefault();  // save for later
													    // Print current default settings
		System.out.println("Start with Deafult Locals:"+
    		  "\n\tDisplay Locale: " + Locale.getDefault(Locale.Category.DISPLAY) +
    		  "\n\tFormat Locale : " + Locale.getDefault(Locale.Category.FORMAT) +
    		  "\n\tJVM Locale    : " + Locale.getDefault());

		pauseConsole("Separately Set Default Locale For Each Category");
                                                        // Set both locale categories
		Locale.setDefault(Locale.Category.DISPLAY, new Locale("no", "NORWAY", "NY"));
		Locale.setDefault(Locale.Category.FORMAT,  new Locale("fr", "FRANCE", "MAC"));
		
		System.out.println("Set Default Display and Format Locals Separately:"+
    		  "\n\tDisplay Locale: " + Locale.getDefault(Locale.Category.DISPLAY) +
    		  "\n\tFormat Locale : " + Locale.getDefault(Locale.Category.FORMAT) +
    		  "\n\tJVM Locale    : " + Locale.getDefault());
     
		pauseConsole("Set JVM Default Locale");
											           // Set without specifying a category
		Locale.setDefault(jvmDefaultLocale);           // original saved default Locale
		
		System.out.println("Set JVM Locale with no category:"+
    		  "\n\tDisplay Locale: " + Locale.getDefault(Locale.Category.DISPLAY) +
    		  "\n\tFormat Locale : " + Locale.getDefault(Locale.Category.FORMAT) +
    		  "\n\tJVM Locale    : " + Locale.getDefault());
      	}

		
	public static void main(String[] args) {
		LocaleCategories lc = new LocaleCategories();
		lc.defaultCategories();
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


