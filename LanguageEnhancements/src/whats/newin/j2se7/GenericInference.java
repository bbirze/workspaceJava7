package whats.newin.j2se7;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class GenericInference <T> extends Vector <T> {
	
	private static final long serialVersionUID = 1L;

	/*  Compiler Type Inference in Generics
	 * =====================================		 */
	public static boolean typeInference() {
		// JAVA SE 6  
		HashMap <Integer, List<String>> mapSE6 = new HashMap<Integer, List<String>>(); 

		// JAVA SE 7  		 
		HashMap <Integer, List<String>> mapSE7 = new HashMap<>(); 
		 
		// MUST use the <>
		mapSE7 = new HashMap();               // Compiler warning
		mapSE7 = new HashMap<>();             
		
		// inference must be obvious from the context
		GenericInference<Integer> gi = new GenericInference<>();
		GenericInference.obvious(gi);         // compiles
		 
		//GenericInference.obvious (new Vector<>());   // Error, type not obvious
		
		return mapSE6==mapSE7;
	}
	
	static void obvious(Collection<? extends Integer> c)  {
		System.out.println("Obvious() got Collection: " + c.getClass().getName() + ": " + c);
	}
	
	
	/*  Type Inference of Generic Constructors
	 * ========================================    */
	
	 public static <T> void addIt(T y)  {  		// generic method
		 System.out.println("we got: " + y.getClass().getName() + ": " + y);
	 }

	 <E>GenericInference(E param)   {           // generic constructor
		System.out.println("we constructor got: " + param.getClass().getName() + ": " + param);
	}
	 
	 
	public static boolean makeEm() {
		// JAVA SE 6: Infers Type for Generic methods parameter
		 addIt(45);
		//               and Type for Generic Constructor parameter, String
		//
		GenericInference <Integer> gSE6 = new GenericInference<Integer>("JSE 6:String Param Only Infered"); 
		
		// JAVA SE 7 : Infer Type for Generic Constructor AND Generic Class being instantiated 	
		//
		GenericInference <Integer> gSE7 = new GenericInference<>("JSE7:String Param and Class Type Infered"); 
	
		return gSE6==gSE7;
	}
	 


	GenericInference() {}
	
	public static void main(String[] args) {
		GenericInference.typeInference();
		GenericInference.pauseConsole("to see Type Inference of Generic Constructors");
		GenericInference.makeEm();
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
