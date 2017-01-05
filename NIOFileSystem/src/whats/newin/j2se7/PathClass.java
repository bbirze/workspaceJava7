package whats.newin.j2se7;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathClass {

	/** Path holds a representation of a path in the file system
	 */
	public static void main(String[] args) {
		
		// System specific Syntax
		//
		String unixPath    = "/users/mk/fname";      
		String windowsPath = "C:\\users\\mk\\fname";   

		Path path = Paths.get(unixPath);
		System.out.println("Unix path example: " + unixPath);
		System.out.println("\t toString(): " + path);
		System.out.println("\t getRoot(): " + path.getRoot());
		System.out.println("\t getParent(): " + path.getParent());
		System.out.println("\t getFileName(): " + path.getFileName());
		System.out.println("\t getNameCount(): " + path.getNameCount());
		System.out.println("\t getName(0): " + path.getName(0));
		System.out.println("\t getName(1): " + path.getName(1));
		System.out.println("\t getName(2): " + path.getName(2));
		System.out.println("\t subpath(1,3): " + path.subpath(1,3));

		path = Paths.get(windowsPath);
		System.out.println("\nWindows path example: " + windowsPath);
		System.out.println("\t toString(): " + path);
		System.out.println("\t getRoot(): " + path.getRoot());
		System.out.println("\t getParent(): " + path.getParent());
		System.out.println("\t getFileName(): " + path.getFileName());
		System.out.println("\t getNameCount(): " + path.getNameCount());
		System.out.println("\t getName(0): " + path.getName(0));
		System.out.println("\t getName(1): " + path.getName(1));
		System.out.println("\t getName(2): " + path.getName(2));
		System.out.println("\t subpath(1,3): " + path.subpath(1,3));

		path = Paths.get("\\users", "mk", "fname");
		System.out.println("\nVariable Arguments path example: (\"\\users\", \"mik\", \"fname\")");
		System.out.println("\t toString(): " + path);
		System.out.println("\t getRoot(): " + path.getRoot());
		System.out.println("\t getParent(): " + path.getParent());
		System.out.println("\t getFileName(): " + path.getFileName());
		
		
		//  toAbsolutePath()	
		//
		pauseConsole("Relative Path Convert to Absolute Path");
		String pathRep = "mk/myDocuments";
		path = Paths.get(pathRep);
		System.out.println("\n Given: " + pathRep);
		System.out.println("\t getRoot(): " + path.getRoot());
		System.out.println("\t getParent(): " + path.getParent());
		System.out.println("\t toAbsolutePath(): " + path.toAbsolutePath());
		      
		try {                     // can check against the file system                 
			System.out.println("\t toRealPath(): " + path.toRealPath());
		} catch(IOException ex) {
		    System.out.println("\ntoRealPath( "+ path + ") caught exception:\n\t" + ex);
		} 
		
		
		//  Normalize()
		//
		pauseConsole("Normalization over dot (.) and dot dot (..) notation");
		pathRep = "/users/./mk/myData";		// . notation
		path = Paths.get(pathRep);
		System.out.println("\n Normalize: " + pathRep +",\t to: " + path.normalize());

		pathRep = "/users/bbb/../mk/myData";  	// and .. notation
		path = Paths.get(pathRep);
		System.out.println(" Normalize: " + pathRep +", \t to: " + path.normalize());
		
		
		//  Resolve()
		//
		pauseConsole("Use resolve() to concatenate to Path");
		path = Paths.get( "/users/myData");
		System.out.println("\n Resolve /users/myData with:");
		System.out.println(" \t File name:resolve(fName) \t\t=> " + 
							path.resolve("fName"));
		System.out.println(" \t Relative path:resolve(dir/myFile) \t=> " + 
							path.resolve("dir/myFile"));
		System.out.println(" \t Empty string:resolve(\"\") \t\t=> " + 
							path.resolve(""));
		System.out.println(" \t Absolute path:resolve(C:\\documents\\fname) => " +
							path.resolve("C:\\documents\\fname"));

		
		//  Relativize()
		//
		pauseConsole("Use relativize() to construct a relative path");
		Path path1 = Paths.get( "/users/mk/myData");
		Path path2 = Paths.get("/users/bb");
		try {                  
			System.out.println("\n Path1: " + path1);
			System.out.println(" Path2: " + path2);
	
			System.out.println("\t path1.relativize(path2): " + path1.relativize(path2));
			System.out.println("\t path2.relativize(path1): " + path2.relativize(path1));
		} catch(IllegalArgumentException ex) {
		    System.out.println("toRealPath( "+ path1 + ") caught exception:\n\t" + ex);
		} 
	
	}
	
	private static void pauseConsole(String doNext) {
		try {
			InputStreamReader cin = new InputStreamReader(System.in);
			System.out.println("\nHit Enter to see "+ doNext +":>");
			cin.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
