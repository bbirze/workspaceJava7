package whats.newin.j2se7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.FileStore;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class FileOperations {

	public static void main(String[] args) {
		
		// Create a Directory
		Path dpath=  Paths.get("C:\\working"); ;
		Path fpath = dpath.resolve("newFile.txt"); 	 // use resolve()
		try {
			Files.deleteIfExists(fpath);             // make sure doesn't exist
			Files.deleteIfExists(dpath);             // make sure doesn't exist
			Files.createDirectory(dpath);            // Create work directory
		} catch (IOException e) {
			//System.out.println("caught exception: " + e);
		}

		
		// Create a File
		pauseConsole("Create a File");
		Charset charset = Charset.forName("US-ASCII");
		OpenOption[] options = new OpenOption[] 
				{ StandardOpenOption.CREATE, StandardOpenOption.WRITE };                         

		try (BufferedWriter writer = 
				Files.newBufferedWriter(fpath, charset, options))  {
			for (int i=0; i < 1000; i++)  {
				String s = "Line: ["+ i+"] in our mavelous file!\n";
				writer.write(s, 0, s.length());   
			}
		} catch (IOException e) {
			System.out.println("caught exception: " + e);
		}
        System.out.println("Finished writing 1000 lines to our file");
		
        
		// Read a Block of Data
		pauseConsole("Read a Block of Data");
	    int    numRead;
	    char[] buf = new char[1024];

	    try (BufferedReader reader = 
				Files.newBufferedReader(fpath, charset)) {
			// 
			// reading a 1024 block from a file
			numRead = reader.read(buf, 0, buf.length);
	        System.out.println("Read these "+ numRead + " characters from our file! \n" + new String(buf));
		} catch (IOException e) {
			System.out.println("caught exception: " + e);
		}

	
		// Managing Metadata: Different views for Windows and Unix
		//                Windows: AclFileAttributeView
		//                Unix   : PosixFileAttributeView
		pauseConsole("See File Metadata");
		try {                         // Read a file's attributes as a bulk operation
			BasicFileAttributes attr = Files.readAttributes(fpath, BasicFileAttributes.class);
	
			System.out.println("Given: " + fpath);
			System.out.println("\t size()          : " + attr.size());
			System.out.println("\t isDirectory()   : " + attr.isDirectory());
			System.out.println("\t isOther()       : " + attr.isOther());
			System.out.println("\t isRegularFile() : " + attr.isRegularFile());
			System.out.println("\t isSymbolicLink(): " + attr.isSymbolicLink());
			
			long currentTime = System.currentTimeMillis();   // touch file
			FileTime ft = FileTime.fromMillis(currentTime);
			Files.setLastModifiedTime(fpath, ft);
			

			// View File Stores Information
			pauseConsole("See File Stores Information");
			System.out.println("\nThe File Stores on this machine include:");
			                                
			for (FileStore store: FileSystems.getDefault().getFileStores()) {
		        long total = store.getTotalSpace() / 1024;
		        long used = (store.getTotalSpace() - store.getUnallocatedSpace()) / 1024;
		        long avail = store.getUsableSpace() / 1024;
		        System.out.println(store + " Drive:\n\t total Space:" + total +
		        		"  Used: " + used + " Avaiable: " + avail);
			}
		} catch (IOException e) {
			System.out.println("caught exception: " + e);
		}
	}

	private static void pauseConsole(String doNext) {
		try {
			InputStreamReader cin = new InputStreamReader(System.in);
			System.out.println("\nHit Enter to "+ doNext +":>");
			cin.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
