package whats.newin.j2se7;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileSystemAccess {

	private void dumpDirsExist(Path path, Path path2, Path path3) {
		System.out.println("\t exists("+path+"): " + Files.exists(path));
		System.out.println("\t exists("+path2+"): " + Files.exists(path2));
		System.out.println("\t exists("+path3+"): " + Files.exists(path3));	
	}


	public FileSystemAccess() {
		try {
			// file existence and accessibility
			//
			Path path = Paths.get("C:\\Users"); // directory
			System.out.println("Existing directory, path: " + path);
			System.out.println("\t exists():        " + Files.exists(path));
			System.out.println("\t notExists():     " + Files.notExists(path));
			System.out.println("\t isRegularFile(): " + Files.isRegularFile(path));
			System.out.println("\t isReadable():    " + Files.isReadable(path));
			System.out.println("\t isWritable():    " + Files.isWritable(path));
			System.out.println("\t isExecutable():  " + Files.isExecutable(path));

			path = Paths.get("C:\\am_I_here"); 
			Files.deleteIfExists(path);             // make sure doesn't exist
			System.out.println("\nDoesn't exist, path: " + path);
			System.out.println("\t exists():        " + Files.exists(path));
			System.out.println("\t notExists():     " + Files.notExists(path));
			System.out.println("\t isRegularFile(): " + Files.isRegularFile(path));
			System.out.println("\t isReadable():    " + Files.isReadable(path));
			System.out.println("\t isWritable():    " + Files.isWritable(path));
			System.out.println("\t isExecutable():  " + Files.isExecutable(path));

			pauseConsole("Create a Directory");
			
			
			// Create a directory
			//
			Path path2 =  Paths.get("C:\\nowIAm_Here"); 
			Path path3 =  Paths.get("C:\\nowIAm_There"); 
			
			System.out.println("Creating path: " + path);
			Files.createDirectory(path);

			dumpDirsExist(path, path2, path3);
			
			
			// Copy the directory
			//
			pauseConsole("Copy a Directory");
			System.out.println("Copying ("+path+") to ("+path2+") ");
			Files.copy(path, path2, StandardCopyOption.REPLACE_EXISTING);
			dumpDirsExist(path, path2, path3);
			
			
			// Move the directory
			//
			pauseConsole("Move a Directory");
			System.out.println("Moving ("+path2+") to ("+path3+") ");
			Files.move(path2, path3, StandardCopyOption.REPLACE_EXISTING);
			dumpDirsExist(path, path2, path3);	
			
			
			// delete if exists fails silently, no exceptions
			//
			pauseConsole("Delete a Directory that Doesn't Exist with NO Exception");
			System.out.println("\n DeleteIfExist");
			
			boolean deleted = Files.deleteIfExists(path2);           // moved, no longer exists
			System.out.println("\n DeleteIfExist("+path2+") returned " + deleted);
			
			deleted = Files.deleteIfExists(path3);
			System.out.println("DeleteIfExist("+path3+") returned " + deleted + "\n");
			dumpDirsExist(path, path2, path3);

			
			// delete will throw an exceptions
			//
			pauseConsole("Delete a Directory that Doesn't Exist Throwing An Exception");
			System.out.println("\n Delete on already deleted ("+path3+") \n");
			Files.delete(path3);         
			
		} catch (IOException e) {
			System.out.println("caught exception: " + e);
		}
	}
	
	
	
	private void pauseConsole(String doNext) {
		try {
			InputStreamReader cin = new InputStreamReader(System.in);
			System.out.println("\nHit Enter to "+ doNext +":>");
			cin.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	
	public static void main(String[] args) {
		try {
			Path path = Paths.get("C:\\am_I_here"); 
			Files.deleteIfExists(path);             // make sure doesn't exist
			path =  Paths.get("C:\\nowIAm_Here");          
			Files.deleteIfExists(path);
			path =  Paths.get("C:\\nowIAm_There"); 
			Files.deleteIfExists(path); 
	
			FileSystemAccess fsa = new FileSystemAccess();
		} catch (IOException e) {
			System.out.println("Main: Caught exception  "+ e.getMessage());
			e.printStackTrace();
		}

	}


}
