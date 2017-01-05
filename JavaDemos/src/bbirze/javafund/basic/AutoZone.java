package bbirze.javafund.basic;

import java.util.LinkedList;
import java.util.List;

public class AutoZone {
	static private int NUM_TRACKS;
	static private enum trackType{Round, Oval, Linear};
	static private MyTrack[] tracks = new MyTrack[NUM_TRACKS];
	
	static class MyTrack {
		int miles;
		trackType type;	
	}

	public MyTrack makeTrack() {
		

		MyTrack track = new AutoZone.MyTrack();

		
		String[] ary = new String[10];
		List<String> lst = new LinkedList<>();
		aryToLst(ary, lst);
		return track;
	}

	static <T> void aryToLst(T[] a, List<T> lst) {
	  for (T o : a) {
	     lst.add(o); 
	  }
	}
	
	
}
