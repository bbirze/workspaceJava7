package javaDemos;


public class Mod06_StaticInit {
	static final private int NUM_TRACKS = 3;   // inline
	static private Mod06_MyTrack[] tracks;
	
	
	static private int NumGates = setNumGates();
	
	static private int setNumGates()  {
		System.out.println("Setting setNumGates to 7 in static initializer method!");
		return 7;
	}
	static {
		System.out.println("Creating tracks array in static block initilzer!");
		tracks = new Mod06_MyTrack[NUM_TRACKS];
		for (int i=0; i<tracks.length; i++)  {
			tracks[i] = new Mod06_MyTrack();
		}
	}
	
	public static void main(String[] args) {
		System.out.println("NUM_TRACKS = " + NUM_TRACKS);
		System.out.println("Length tracks[] = " + tracks.length);
		System.out.println("NumGates = " + NumGates);
	}

}
