package whats.newin.j2se7;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import whats.newin.j2se7.WalkTree.PrintFileVisitor;

public class FindFiles {
	
	public static void main(String[] args) {
        FinderFV finder = new FinderFV("");
        Path     dirPath = Paths.get("C:/srcDir");
        FindFiles ffiles = new FindFiles();
        
		try  {
			ffiles.findIt("*", dirPath, finder);        // * wildcard matches everything      
			
			pauseConsole("Match Selective *, *_13*");
			ffiles.findIt("*_13*", dirPath, finder);          
			
			pauseConsole("Match Another Selective *, subDir*");
			ffiles.findIt("subDir*", dirPath, finder);           
			
			pauseConsole("Match with ?, subDir1?");
			ffiles.findIt("subDir1?", dirPath, finder);          
			
			pauseConsole("Match with {}, {subDir11, subDir12}");
			ffiles.findIt("{subDir11, subDir12}", dirPath, finder);    
			
			pauseConsole("Match More Correctly with {}, {subDir11,subDir12}");
			ffiles.findIt("{subDir11,subDir12}", dirPath, finder);   

			pauseConsole("Match with * and ? in {}, {subDir?1,subDir*2}");
			ffiles.findIt("{subDir?1,subDir*2}", dirPath, finder);   
			
			pauseConsole("Match with [], subDir1[2-3]");
			ffiles.findIt("subDir1[2-3]", dirPath, finder);      
		    
			pauseConsole("Match Again with [], subDir1[123]");
			ffiles.findIt("subDir1[123]", dirPath, finder);      
		    
		} catch (IOException e) {           
			System.out.println("caught exception: " + e);
			e.printStackTrace();
		}
 	}


	public void findIt(String pattern, Path fileTree, FinderFV finder) throws IOException { 
		finder.setPattern(pattern); 
		System.out.println("Searching file tree for pattern <" + finder.getPattern() + ">");
		Files.walkFileTree(fileTree, finder);
	}
	
	/**  Finder5FV File Visitor inner class
	 */
	public static class FinderFV extends SimpleFileVisitor<Path> {
		private PathMatcher matcher;
		private int         matchCnt;
		private String      pattern;

		public int getMatchCnt()   { return matchCnt; }
		public String getPattern() { return pattern;  }

		public void setPattern(String pattern) {
			this.pattern = pattern;
			matcher = FileSystems.getDefault().getPathMatcher("glob:" + pattern);
		}
       
		FinderFV(String pattern) {
	    	 this.matchCnt = 0;
	    	 this.pattern = pattern;
	    	 this.matcher = FileSystems.getDefault().getPathMatcher("glob:" + pattern);
	     }


		void isMatch(Path path) {
			Path fname = path.getFileName();       // get last node in path, 
			if (fname == null) {                   // null is path has 0 elements
				System.out.println("isMatch given empty path " + fname);
				return;
			}
			if (matcher.matches(fname)) {      
				matchCnt++;                        // found a match
				System.out.println(fname);
			}
		}

		// Pre-Visit Directory
		@Override
		public FileVisitResult preVisitDirectory(Path dirPath,	BasicFileAttributes attrs) throws IOException {
			isMatch(dirPath);
			return FileVisitResult.CONTINUE;
		}

		// Visit File 
		@Override
		public FileVisitResult visitFile(Path fPath, BasicFileAttributes attrs)throws IOException {
			isMatch(fPath);
			return FileVisitResult.CONTINUE;
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
