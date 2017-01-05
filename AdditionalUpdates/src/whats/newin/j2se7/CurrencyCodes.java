package whats.newin.j2se7;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Currency;
import java.util.Locale;
import java.util.Set;

public class CurrencyCodes {

	public static void main(String[] args) {
		Locale frLocale = Locale.forLanguageTag("fr-FR");
		Locale usLocale = Locale.forLanguageTag("en-US");
		Locale gbLocale = Locale.forLanguageTag("en-GB");
		Currency frCur = Currency.getInstance(frLocale);
		Currency usCur = Currency.getInstance(usLocale);
		Currency gbCur = Currency.getInstance(gbLocale);

		Set<Currency>availCurs = Currency.getAvailableCurrencies();
		for (Currency c: availCurs) {
			System.out.println(c.getCurrencyCode() +", " +
					           c.getNumericCode() + ", " + c.getDisplayName());
		}
		pauseConsole("To see associated numeric codes");

		System.out.println("en-US: ISO 4217 Currency Code: " + usCur.getCurrencyCode()
				+ "  Numeric Code:" + usCur.getNumericCode() 
		        +"   Symbol:" + usCur.getSymbol()+ "\n\t"
		        +"   Display Name():" + usCur.getDisplayName()+ "\n\t"
		        +"   Display Name(usLocale):" + usCur.getDisplayName(usLocale)+ "\n\t"
		        +"   Display Name(gbLocale):" + usCur.getDisplayName(gbLocale)+ "\n\t"
		        +"   Display Name(frLocale):" + usCur.getDisplayName(frLocale));

		System.out.println("\nen-GB: ISO 4217 Currency Code: " + gbCur.getCurrencyCode()
				+ "  Numeric Code:" + gbCur.getNumericCode() 
		        +"   Symbol:" + gbCur.getSymbol()+ "\n\t"
		        +"   Display Name():" + gbCur.getDisplayName()+ "\n\t"
		        +"   Display Name(usLocale):" + gbCur.getDisplayName(usLocale)+ "\n\t"
		        +"   Display Name(gbLocale):" + gbCur.getDisplayName(gbLocale)+ "\n\t"
		        +"   Display Name(frLocale):" + gbCur.getDisplayName(frLocale));


		System.out.println("\nfr-FR: ISO 4217 Currency Code: " + frCur.getCurrencyCode()
				+ "  Numeric Code:" + frCur.getNumericCode() 
		        +"   Symbol:" + frCur.getSymbol()+ "\n\t"
		        +"   Display Name():" + frCur.getDisplayName()+ "\n\t"
		        +"   Display Name(usLocale):" + frCur.getDisplayName(usLocale)+ "\n\t"
		        +"   Display Name(gbLocale):" + frCur.getDisplayName(gbLocale)+ "\n\t"
		        +"   Display Name(frLocale):" + frCur.getDisplayName(frLocale));
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
