package labs.solutions.lab03;

public class Plant {

	static enum Exposure { Sun, Shade }
	static enum WaterNeed { Dry, Average, Moist }
	String    name;
	Exposure  exposure;
	WaterNeed water;
	
	public Plant(String nm, Exposure exp, WaterNeed wat) {
		name = nm;
		exposure = exp;
		water = wat;
	}
	
	public String toString() {
		return "Plant " + name + " with exposure needs: " + exposure +
				" and water needs: " + water +".";
	}
	
	public static void main(String[] args) {
		Plant[] myPlants = new Plant[5];
		
		myPlants[0] = new Plant("Hosta", Exposure.Shade, WaterNeed.Moist);
		myPlants[1] = new Plant("Poppy", Exposure.Sun, WaterNeed.Average);
		myPlants[2] = new Plant("Aloe", Exposure.Shade, WaterNeed.Dry);
		myPlants[3] = new Plant("Yucca", Exposure.Sun, WaterNeed.Dry);
		myPlants[4] = new Plant("Cattail", Exposure.Sun, WaterNeed.Moist);
		

		System.out.println(myPlants[0]);
		System.out.println(myPlants[1]);
		System.out.println(myPlants[2]);
		System.out.println(myPlants[3]);
		System.out.println(myPlants[4]);
	}

}
