package whats.newin.j2se7;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;

public class WalkTree {
    final static Path sourceDir = Paths.get("C:/srcDir");
	final static Path targetDir = Paths.get("C:/destDir");
	
	public static void main(String[] args)  { 
		try  {
			// Print file tree
			WalkTree walk = new WalkTree();
			PrintFileVisitor fvisit = new PrintFileVisitor();
	
			walk.printTree("Source Directory Tree Structure!", 
					        sourceDir, fvisit);
			
			// Copy file tree
			pauseConsole("Copy File Tree");
			System.out.println("COPY SourceDir "+sourceDir+" to TargetDir "+targetDir);
			walk.copyTree();
			walk.printTree("Target Directory Tree Structure!", 
					        targetDir, fvisit);
			
			// Delete file tree
			pauseConsole("Delete File Tree");
			System.out.println("DELETE TargetDir "+targetDir);
			walk.deleteTree(targetDir);
			
			System.out.println("SourceDir "+sourceDir+" exists: " + Files.exists(sourceDir));
			System.out.println("TargetDir "+targetDir+" exists: " + Files.exists(targetDir));
		} catch (IOException e) {    
			System.out.println("caught exception: " + e);
			e.printStackTrace();
		}
	}
		
	/** Print a File Tree using given PrintFileVisitor
	 */
	private void printTree(String heading, Path path, PrintFileVisitor fvisit)  throws IOException {
		
		System.out.println("\nSourceDir "+sourceDir+" exists: " + Files.exists(sourceDir));
		System.out.println("TargetDir "+targetDir+" exists: " + Files.exists(targetDir));
		System.out.print("\nPRINT  " +heading);

		Files.walkFileTree(path, EnumSet.of(FileVisitOption.FOLLOW_LINKS),
				Integer.MAX_VALUE, fvisit ); 
	}

	/**  PrintFileVisitor inner class
	 */
	public static class PrintFileVisitor implements FileVisitor<Path> {

		// Pre-Visit Directory
		@Override
		public FileVisitResult preVisitDirectory(Path dirPath,	BasicFileAttributes attrs) throws IOException {
			System.out.println("\npreVisitDirectory: Directory=>  "+ dirPath + "  size: " + attrs.size());
			return FileVisitResult.CONTINUE;
		}

		// Post-Visit Directory
		@Override
		public FileVisitResult postVisitDirectory(Path dirPath, IOException ex) throws IOException {
			System.out.println("postVisitDirectory: Leaving Directory=>  "+ dirPath);
			if (ex != null)  {                           // null if no exception
				System.out.println("postVisitDirectory: given exception: " + ex);
				ex.printStackTrace();
			}
			return FileVisitResult.CONTINUE;
		}

		// Visit File 
		@Override
		public FileVisitResult visitFile(Path fPath, BasicFileAttributes attrs)throws IOException {
			System.out.println("visitFile: "+ fPath);
			return FileVisitResult.CONTINUE;
		}

		// File-Visit Failed
		@Override
		public FileVisitResult visitFileFailed(Path fPath, IOException ex) throws IOException {
			System.out.println("visitFileFailed: given exception: " + ex);
			ex.printStackTrace();
			return FileVisitResult.CONTINUE;
		}
	}
	
	
	/**  Copy a File Tree
	 */
	private void copyTree()  throws IOException {
		
		Files.walkFileTree(sourceDir, EnumSet.of(FileVisitOption.FOLLOW_LINKS), Integer.MAX_VALUE, 
				new SimpleFileVisitor<Path>() {
			
					// Pre-Visit Directory
					@Override
					public FileVisitResult preVisitDirectory(Path dirPath, BasicFileAttributes attrs) throws IOException {
						Path target = targetDir.resolve(sourceDir.relativize(dirPath));
						try {
							System.out.println("preVisitDirectory: Copying: " + dirPath + " to directory " + target);
							Files.copy(dirPath, target);
				        } catch (FileAlreadyExistsException ex) {
							System.out.println("preVisitDirectory: " + dirPath + " already exists! " + ex);
				        } catch (IOException ex) {
							System.out.println("preVisitDirectory: caught exception: " + ex);
							ex.printStackTrace();
			                return FileVisitResult.SKIP_SUBTREE;    // skip this subtree but keep going
				        }
						return FileVisitResult.CONTINUE;
					}

					// Visit File 
					@Override
					public FileVisitResult visitFile(Path srcPath, BasicFileAttributes attrs) throws IOException {
						Path destPath = targetDir.resolve(sourceDir.relativize(srcPath));
						System.out.println("visitFile: Copying: " + srcPath + " to directory " + destPath);
						Files.copy(srcPath, destPath);
						return FileVisitResult.CONTINUE;
					}
				});
	}
	

	/** Delete a File Tree
	 */
	private void deleteTree(Path path) throws IOException {
		Files.walkFileTree(path, EnumSet.of(FileVisitOption.FOLLOW_LINKS),Integer.MAX_VALUE, 
				new SimpleFileVisitor<Path>() {
			
					// Post-Visit Directory
					@Override
					public FileVisitResult postVisitDirectory(Path dirPath, IOException ex) throws IOException {
						if (ex != null)  {                           // null if no exception
							System.out.println("postVisitDirectory: given exception: " + ex);
							ex.printStackTrace();
						}
						try {
							System.out.println("postVisitDirectory: Deleting: " + dirPath);
							Files.deleteIfExists(dirPath);             // files are now gone
						} catch (IOException ex1) {
						}
						return FileVisitResult.CONTINUE;
					}

					// Visit File 
					@Override
					public FileVisitResult visitFile(Path fpath,	BasicFileAttributes attrs) throws IOException {
						System.out.println("visitFile: Deleting: " + fpath);
						Files.deleteIfExists(fpath);             
						return FileVisitResult.CONTINUE;
					}
			});
	}
	
	
	
	
	public WalkTree() {
		//init();          // uncomment to create src tree
	}

	private void init() {  
		try {                                     // Create work directories and files
			Files.deleteIfExists(sourceDir);      // make sure doesn't exist
			createDirNFiles(sourceDir, 3, "0");
			createDirNFiles(sourceDir.resolve("subDir1"), 2, "1");
			createDirNFiles(sourceDir.resolve("subDir1/subDir11"), 1, "11");
			createDirNFiles(sourceDir.resolve("subDir1/subDir12"), 1, "12");
			createDirNFiles(sourceDir.resolve("subDir1/subDir13"), 3, "13");
			createDirNFiles(sourceDir.resolve("subDir1/subDir13/subDir131"), 2, "131");
			createDirNFiles(sourceDir.resolve("subDir1/subDir13/subDir131/subDir132"), 1, "132");
		} catch (IOException e) {                  // already exists
			System.out.println("caught exception: " + e);
			e.printStackTrace();
		}
	}

	private void createDirNFiles(Path dir, int numFiles, String fSuffix) throws IOException {
		Files.createDirectory(dir);  
		for (int i=1; i <= numFiles; i++) {
			Path fname = dir.resolve("File_" + fSuffix + "_" + i + ".txt");
			System.out.println("Create File  "+ fname);
			File file = new File(fname.toString());   // old school
            file.createNewFile();
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
