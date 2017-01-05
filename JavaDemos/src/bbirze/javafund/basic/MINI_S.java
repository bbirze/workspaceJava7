package bbirze.javafund.basic;

public class MINI_S extends Car{
	String fuelType;
	private String color;
	
	public String  getColor()          { return color; }
	protected void setColor(String cl) { color = cl; }
	
	public String toString() {
		return "MINI_S: Color: " + color;
	}
	
	public MINI_S(String color) {
		super(color);
	}
	
	public static void main(String[] args) {
		Car[] cars = new Car[3];
		cars[0] = new Car("Blue");
		cars[1] = new MINI_S("Yellow");
		cars[2] = new ChevySpark("Green");
		for (int i=0; i<cars.length; i++) {
			System.out.println("cars[" + i + "] = " + cars[i]);
		}
	}

	public void superKeyword() {
        String ft;
        ft = fuelType;        // MINI-S property
        ft = super.fuelType;  // Car property
    }
	
	
	
	public void myMini(MINI_S myMini)  {
		Car car = myMini;
		car.getFuelType();   // MINI_S implementation
		Car.printModel();    // Car implementation
		MINI_S.printModel(); //MINI_S implementation

	}

	public static void printModel() {
		// TODO Auto-generated method stub
		
	}

	public void myMethod(int index) {
		if (index < 10) {
			return;
		}
		System.out.println("Not Done Yet!");		
	}
	
	public int yourMethod(int index) {
		if (index < 10) {
			return index;
		}
		System.out.println("Not Done Yet!");
		return 10;
	}
	
	
	public void myMeth(Car myCar)  {
		MINI_S myMini = (MINI_S)myCar;
		myMini.addFuel(16.2);  
	}
	
	
	public int drive(int speed) {
		
		Object myMini2 = new MINI_S("Yellow");
		
		return speed;
	}
	
	public void addFuel(double gallons) {
	}

	public boolean putTopUp() {
		return true;
	}
	
	public boolean putTopDown() {
		return true;
	}
	

}
