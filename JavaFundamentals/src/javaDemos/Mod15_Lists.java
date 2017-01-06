package javaDemos;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Mod15_Lists {

	public Mod15_Lists() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		List<String> lstSE6 = new ArrayList<String>();    // Java SE 6 declaratin
		List<String> lstSE7 = new ArrayList<>();          // Java SE 7 with new <> operator
		
		lstSE7.add("element 1");    // add to end of list
		lstSE7.add("element 2");    // add to end of list
		lstSE7.add("element 3");    // add to end of list
		lstSE7.add("element 4");    // add to end of list
		lstSE7.add("element 5");    // add to end of list
		lstSE7.add("element 6");    // add to end of list
		lstSE7.add("element 7");    // add to end of list
		
		lstSE7.add(4, "Wildcard at 4");    // insert in position 4
		lstSE7.add(2, "Nother Wildcard at 2");    // insert in position 2
		
												  // Forwards Iteration
	    System.out.println("Iterate through our list with for-each!");
		for (String item : lstSE7) {
		    System.out.println(item);
		}
		                                          // Backwards Iteration 
	    System.out.println("\nIterate through our list backwards with Iterator!");
		for (ListIterator<String> it = lstSE7.listIterator(lstSE7.size()); it.hasPrevious(); ) {
		    System.out.println(it.previous());
		}
	}

}
