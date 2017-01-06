package javaDemos;

public class Mod05_Modifiers {
	
	// Instance Properties
	private int stealth;
	protected byte allInTheFamily;
	public String friendly;
	String pckgFriendly;

	// Class Properties
	static public int oneOfAKind;
	static final private int HIDE_ME = 5;
	
	// Instance Method
	protected void setOneOfAKind(int val)  { oneOfAKind = val; }
	
	void doSomeStuff(byte relative, String pckgItUp) {
		allInTheFamily = relative;
		pckgFriendly = pckgItUp;
		stealth = HIDE_ME;      // instance method uses static constant
		oneOfAKind = stealth;
	}

	// Class Method
	public static int getHIDE_ME()    {
		//stealth = 5;
		return HIDE_ME; 
	}
	
	public static void main(String[] args) {
		Mod05_Modifiers mobj = new Mod05_Modifiers(7);
		
		int constant = Mod05_Modifiers.getHIDE_ME();
		 constant = mobj.getHIDE_ME();
		if (constant == oneOfAKind)  {
			mobj.pckgFriendly = "Open To the Public!";
		}
	}
	// Constructor
	public Mod05_Modifiers(int spy) {
		stealth = spy;
	}
	
	
}
