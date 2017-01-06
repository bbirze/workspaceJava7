package javaDemos.mod12interface;

public abstract class Animal implements IAnimal{
	protected int numLegs;

	@Override
	public int getNumLegs() { return numLegs;	}

	static void printAnimals(IAnimal[] ary) {
		for (int i = 0; i < ary.length; i++) {
			ary[i].eat();
			ary[i].move();
			System.out.println("\t with " +  ary[i].getNumLegs() + " legs.");
		}
	}
	
	public Animal(int numlegs) {
		this.numLegs = numlegs;
	}

	public static void main(String[] args) {
		IAnimal[] zoo = new IAnimal[3];
		zoo[0] = new Rabbit();
		zoo[1] = new Snake();
		zoo[2] = new Robin();	

		printAnimals(zoo);
	}

}
