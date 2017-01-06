package javaDemos;


public class Mod04_DataTypes {

	/*  Binary Literals
	 * ===============================	 */
	public static void main(String[] args) {
		                                         //8-bit: byte value
		byte x8bit= (byte)0b00100001;
		                                         //16-bit: short values
		short x16bit = (short)0b1010000101000101;
	                                             //32-bit: int value
		int x32bit = (int)0B10100001010001011010000101000101;
		                                         //64-bit: long value
		long x64bit = (long)0B0010000101000101101000010100010110100001010001011010000101000101L;
		
		System.out.println ("8-bit binary byte: " + x8bit + "\n16-bit binary short: "+ x16bit
				 + "\n32-bit binary int: "+ x32bit + "\n64-bit binary long: "+ x64bit);
	}

	
	
	
	/*  Underscores in Numeric Literals
	 * =================================  */
	void underscore()  {
		long x64bit = (long)0B0010_0001_0100_0101_1010_0001_0100_0101_1010_0001_0100_0101_1010_0001_0100_0101L;
		
		// normal number grouping
		long hundredMil = 100_000_000;
		
		// Unique pattern groupings 
		long debitCard = 1122_3344_5566_7788L;
		long SSN       = 999_00_0000L;

		// works for non decimal literals
		int  hexRep   = 0XC_7_A_8;
		int  binRep   = 0B1100_0111_1011_1000;
		long hexBytes = 0xE2_69_B7_F4L;
		long binBytes = 0b11010010_01101001_10110100_11110100;
		int  maxInt   = 0x7FFF_FFFF;
		
		// multiple '_'s OK!
		int funny = 123____________890;

		// Does Not Work for
		//int  xhexRep   = 0X_C7A8;		   // beginning of a number
		//int  xhexRep1  = 0XC7A8_;		   // end of a number
		//int  xfloat    = 234._567;       // next to a decimal point
		//long xhexRep3  = 0xE269_B7F4_L;  // before an L or F Suffix
	}
	
	
}
