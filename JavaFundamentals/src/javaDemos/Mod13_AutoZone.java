package javaDemos;

public class Mod13_AutoZone {
	static private int NUM_TRACKS;
	static private enum trackType{Round, Oval, Linear};
	static private MyTrack[] tracks = new MyTrack[NUM_TRACKS];
	
	static class MyTrack {
		int miles;
		trackType type;	
	}

	public MyTrack makeTrack() {
		MyTrack track = new Mod13_AutoZone.MyTrack();
		return track;
	}
}
