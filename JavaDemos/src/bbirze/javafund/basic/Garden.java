package bbirze.javafund.basic;

public class Garden {
	static enum Exposure { Sun, Shade }

	void plantBed() {
		class Seeds {
		   String   plant;
		   Exposure exp;
		   Seeds(String name, Exposure loc) {
			   plant = name;
			   exp = loc;
		   }
		}
		
		Seeds poppies = new Seeds("Poppies", Exposure.Sun);
		Seeds hosta  = new Seeds ("Hostas", Exposure.Shade);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
