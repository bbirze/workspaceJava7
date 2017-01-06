package javaDemos;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class Mod15_VarargExceptions {

	/*  Heap Pollution Generator
	 * ============================	 */
	
	public void heapPollution() 	   {
		try {
			Vector vi = new Vector<Integer>();
			Vector<String> vs = vi;            // unchecked warning, potential
			vi.add(new Integer(42));           // unchecked warning, Heap pollution!
			String str = vs.get(0);            // ClassCastException thrown
			System.out.println("First string in list is : " + str);
			
		} catch(ClassCastException ex)  {
			System.out.println("heapPolution() caught exception: \n\t"+ ex);
		}
	}
	
	

	/* Vararg methods with Non-Reifiable Parameters
	 * ==============================================	 */
	
	public static void varargMethod(List<String>... lst) {  // lst translated into an Object[]
		try {
			Object[] objAry = lst;                 
			                                       
			objAry[0]  = Arrays.asList(new Integer(88));    // add Integer to objAry, and lst 
			String str = lst[0].get(0);                     // ClassCastException, Integer is not a String
			System.out.println("First string in list is : " + str);
			
		} catch(ClassCastException ex)  {
			System.out.println("varargMethod() caught exception: \n\t"+ ex);
		}
	}
	
	

	/*  Suppress Warnings with Annotations
	 * ====================================	 */

	//@SuppressWarnings("unchecked")
	public static void suppressWarningsVararg(List<String>... lst) {                                              
		String str = lst[0].get(0);            
		System.out.println("First string in list is : " + str);
	}
	

	//  @SafeVarargs
	 public static void safeVararg(List<String>... lst) {
		String str = lst[0].get(0);         
		System.out.println("First string in list is : " + str);
	}
	 
	 public static void suppressingWarnings()  {
		List<String> lst1 = new ArrayList<String>();
		lst1.add("Lst1 1st element");
		List<String> lst2 = new ArrayList<String>();
		lst1.add("Lst2 1st element");
		
		suppressWarningsVararg(lst1, lst2);
		safeVararg(lst1, lst2);
	 }
	 
	 
	 
	 
	public static void main(String[] args) {
		Mod15_VarargExceptions ve = new Mod15_VarargExceptions();
		ve.heapPollution();

		Mod15_VarargExceptions.pauseConsole("Vararg methods with Non-Reifiable Parameters");
		List<String> lst1 = new ArrayList<String>();
		List<String> lst2 = new ArrayList<String>();
		ve.varargMethod(lst1, lst2);
		
		Mod15_VarargExceptions.pauseConsole("How to Suppress Warnings with Annotations");
		ve.suppressingWarnings();
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
