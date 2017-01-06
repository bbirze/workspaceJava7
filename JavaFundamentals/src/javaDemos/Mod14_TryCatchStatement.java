package javaDemos;

import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.FileSystemException;
import java.rmi.activation.ActivationException;
import java.rmi.activation.UnknownObjectException;


public class Mod14_TryCatchStatement {

	public void fourExceptionMethod() throws FileNotFoundException, IOException,
	ActivationException, UnknownObjectException {

	}	
	
	/* Java SE 6 only allowed one exception to be caught per catch block
	 */
	public void oldMultiCatch() throws IOException, ActivationException {
		//                                 Code Bloat!
		try { 
			fourExceptionMethod();
		} catch (FileNotFoundException ex) {
			System.out.println("caught exception: " + ex.getMessage());
		} catch (IOException ex) {
			System.out.println("caught exception: " + ex.getMessage());
			throw ex;
		} catch (UnknownObjectException ex) {
			System.out.println("caught exception: " + ex.getMessage());
		} catch (ActivationException ex) {
			System.out.println("caught exception: " + ex.getMessage());
			throw ex;
		}
		//                                 Sometimes You'd see This!
		try {
			fourExceptionMethod();
		} catch (Exception ex) {	    // Broad catch everything!
			System.out.println("caught exception: " + ex.getMessage());
		} 
	}


	/* Java SE 7 allows us to catch multiple exception in a single catch block
	 */
	public void newMultiCatch() throws IOException, ActivationException {
		try {
			fourExceptionMethod();
		} 
		catch (FileNotFoundException | UnknownObjectException ex) {           // use | to separate Exceptions
			System.out.println("log error and continue: " + ex.getMessage());
			// ex = new IOException("This is illegal because ex is final!");
		} 
		catch (IOException| ActivationException ex) {
			System.out.println("log error and rethrow: " + ex.getMessage());
			throw ex;
		}
	
	}


	
	
	
	public static void main(String[] args) throws IOException, ActivationException{
		Mod14_TryCatchStatement tcs = new Mod14_TryCatchStatement();

		System.out.println("\nNow lets see Multiple Exceptions in a Single Catch");
		try {
			tcs.oldMultiCatch();
		}catch (Exception e)  {}
		
		try {
			tcs.newMultiCatch();
		}catch (Exception e)  {}	
	}
	
	private  void pauseConsole(String doNext) {
		try {
			InputStreamReader cin = new InputStreamReader(System.in);
			System.out.println("\nHit Enter to "+ doNext +":>");
			cin.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
