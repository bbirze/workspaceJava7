package labs.solutions.lab12;

import java.io.IOException;

import labs.solutions.lab12.util.PrintHelper;

public class Plant {

	static enum Exposure { Sun, Shade }
	static enum WaterNeed { Dry, Average, Moist }
	public static final int NUM_PLANTS = 5; 
	
	String    name;
	Exposure  exposure;
	WaterNeed water;
	
	public Plant(String nm) {
		this(nm, Exposure.Sun);
	}
	
	public Plant(String nm, Exposure exp) {
		this(nm, exp, WaterNeed.Average);
	}
	
	public Plant(String nm, Exposure exp, WaterNeed wat) {
		name = nm;
		exposure = exp;
		water = wat;
	}
	
	public String toString() {
		return "Plant " + name + " with exposure needs: " + exposure +
				" and water needs: " + water +".";
	}
	
	static public void printPlants(Plant[] myPlants) throws IOException {
		try {
			PrintHelper printIt = new PrintHelper(); 
			printIt.printPlants(myPlants);
			
		} catch (NullPointerException e) {
			System.err.println("\nIn Plant.printPlants()");
			System.err.println("Caught NullPointerException printing out Plant arry: " + e.getMessage());
			e.printStackTrace();
			throw new IOException("Wrapping Exception", e);
		}
	
	}
	
	
	public static void main(String[] args) {
		Plant[] myPlants = new Plant[NUM_PLANTS];
		
		myPlants[0] = new Plant("Hosta", Exposure.Shade, WaterNeed.Moist);
		myPlants[1] = new Plant("Poppy");
 
		myPlants[3] = new Plant("Lilly", Exposure.Shade);
		myPlants[4] = new Plant("Cattail", Exposure.Sun, WaterNeed.Moist);
		
		try {
			printPlants(myPlants);
			
		} catch (IOException e) {
			System.err.println("\nIn Plant.main()");
			System.err.println("Caught IOException printing out Plant arry: " + e.getMessage());
			e.printStackTrace();
		}	
	}

}
