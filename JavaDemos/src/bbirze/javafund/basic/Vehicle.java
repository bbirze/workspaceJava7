package bbirze.javafund.basic;

import java.io.Serializable;

public interface Vehicle  extends Serializable, Cloneable {

	int GASOLINE = 0;
	int DIESEL   = 1;
	int HYBRID   = 3;
	int ELECTRIC = 4;
	
	int drive(int speed);
	int getFuelType();
}
