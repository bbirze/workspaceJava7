package labs.solutions.lab12.util;

public class PrintHelper {

	

	public void printPlants(labs.solutions.lab12.Plant[] plantAry)  {
		System.out.println("These are the plants in my garden:");		
		for (int i=0; i < plantAry.length; i++){
			if (plantAry[i] == null) {
				System.err.println("\tPrintHelper Error: NULL Index " + i);
				throw new NullPointerException("Given a null Plant object reference!");
			}
			System.out.println("\t" + plantAry[i]);
		}
	}

}
