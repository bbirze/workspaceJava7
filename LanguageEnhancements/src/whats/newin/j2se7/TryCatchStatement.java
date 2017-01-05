package whats.newin.j2se7;

import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.FileSystemException;
import java.rmi.activation.ActivationException;
import java.rmi.activation.UnknownObjectException;


public class TryCatchStatement {

	/*  Automatic Resource Management
	 * =============================== */
	FileOutputStream fileOS = null;
	DataOutputStream dataOS = null;

	public void testTryWithResources()
	{
		try  {
			manageWithFinally();
		} catch (Exception ex)  {
			System.out.println("In testTryWithResources: Manage with Finally: threw exception: " + ex.getMessage());			
		}
		pauseConsole("to see Try-with-Resources");
		
		try  {
			tryWithResources();
		} catch (Exception ex)  {
			System.out.println("In testTryWithResources: try With Resources: threw exception: " + ex.getMessage());			
			System.out.println("   any suppressed exceptions?: ");	
			Throwable[] exLst =  ex.getSuppressed();    
			for(Throwable supEx : exLst)  {
				System.out.println("\tSuppressed Exception:" + supEx.getMessage()); 
			}
		}
	}
	

	
	 /* Java SE 6 used a finally block to Always close resources
	 */
	public void manageWithFinally() throws IOException  {
		try {
			fileOS = new FileOutputStream("myFiles.txt");
			dataOS = new DataOutputStream(fileOS);
			fileOS.close();          
			dataOS.writeUTF("Write with closed stream");  // Exception!
		} catch (IOException ex) {
			System.out.println("manageWithFinally: caught exception: " + ex.getMessage());
			throw ex;
		}
		finally {
			dataOS.close();
			fileOS.close();
			System.out.println("manageWithFinally finally block: throwing IO Exception");
			throw new IOException("Thrown from Finally Block!");
		}
	}

	/* Java SE 7 can automatically close resources for us
	 */
	public void tryWithResources() throws IOException {

		try (FileOutputStream fileOS = new FileOutputStream("myFiles.txt");        // use ; bewtween declarations
			 DataOutputStream dataOS = new DataOutputStream(fileOS)) 	{

			fileOS.close();   
			dataOS.writeUTF("Write with closed stream");  // Exception!
			
		} catch (IOException ex) {
			System.out.println("In tryWithResources: caught exception: " + ex.getMessage());
			System.out.println("In tryWithResources: Re-throw caught exception ");
			throw ex;
		}
	}
	
	

	
	
	/*  Multiple Exceptions in a Single Catch
	 * =======================================	 */
	
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

	
	/*  Enhanced Type Checking on Re-Thrown Exceptions
	 * ================================================ */

	/* Java SE 6 restriction on thrown exception
	 */
	 public void rethrowBroadException(String status) throws IOException {
		    try {
		      if (status.equals("File Not Found")) {
		        throw new FileNotFoundException(status);
		      } else {
		        throw new FileSystemException(status);
		      }
		    } catch (IOException ex) {
		      throw ex;                  // re-throw broader IOException
		    }
		  }

	
	/*  Java SE 7 allows us to declare a more specific exception than the one thrown
	 */
	public void rethrowGeneralException(String status)
			throws FileNotFoundException, FileSystemException, EOFException {

		try {
			if (status.equals("File Not Found")) {
				throw new FileNotFoundException(status);
			} else {
				throw new FileSystemException(status);
			}
		} catch (IOException ex) {             // Don't have to declare IOException, unless reassign
			// ex = new EOFException("If reassign ex, throws must specify broader IOException");
			throw ex;
		}
	}	 
	 
	
	
	
	
	public static void main(String[] args) throws IOException, ActivationException{
		TryCatchStatement tcs = new TryCatchStatement();
		tcs.testTryWithResources();

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
