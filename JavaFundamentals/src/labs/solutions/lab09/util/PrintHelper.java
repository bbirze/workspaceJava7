package labs.solutions.lab09.util;

public class PrintHelper {

	

	public void printPlants(labs.solutions.lab09.Plant[] plantAryj)  {
		System.out.println("These are the plants in my garden:");		
		for (int i=0; i < plantAryj.length; i++){
			System.out.println("\t" + plantAryj[i]);
		}
	}

}
