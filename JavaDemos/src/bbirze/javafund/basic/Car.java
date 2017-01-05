package bbirze.javafund.basic;

import bbirze.javafund.basic.AutoZone; 
import bbirze.javafund.basic.AutoZone.MyTrack; 
import bbirze.javafund.basic.AutoZone.*;

public class Car extends Throwable implements Vehicle, Cloneable {

	public int drive(int speed, MyTrack track) {
		int time =  track.miles/speed;
		return time;
	}


	public int drive(int speed) {
		final int i = 10;
		int j = i;
		speed = 11;
		
		
		// do stuff...
		return speed;
	}

	public int getFuelType() {
		return GASOLINE;
	}

	public void printFuel(Vehicle[] vh) {
		for (int i=0; i < vh.length; i++)
			System.out.println(vh[i].getFuelType());
	}
	
	public static void printModel() {
		// TODO Auto-generated method stub
		
	}
	protected int MPG;
	protected String color;
	protected String fuelType;
	
	public String toString() {
		return "Car: Color: " + color;
	}
	
	public Car() {
		this.color = "Red";
	}
	public Car(String color) {
		this.color = color;
	}
	}
