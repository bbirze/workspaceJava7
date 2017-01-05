package whats.newin.j2se7;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class AsynchrousFileIO {

	public static void main(String[] args) {

		OpenOption[] options = new OpenOption[] { 
				StandardOpenOption.CREATE, 
				StandardOpenOption.TRUNCATE_EXISTING, 
				StandardOpenOption.WRITE, 
				StandardOpenOption.READ,  };
		
		Path dpath= Paths.get("C:\\working"); ;
		Path fpath= dpath.resolve("newFile.txt");     // new file path 		
;
 		try {
			Files.deleteIfExists(fpath);             // make sure doesn't exist
			Files.deleteIfExists(dpath);           
			Files.createDirectory(dpath);            // Create work directory
		} catch (IOException e) {
			//System.out.println("caught exception: " + e);
		}
		
		CompletionHandler<Integer, Object> handler =
	        new CompletionHandler<Integer, Object>() {
			    @Override
			    public void completed(Integer num, Object attach) {
			        System.out.println("Write Handler got attachment (" + attach + ")\n\t completed with " + num + " bytes written");
			    }
			    @Override
			    public void failed(Throwable e, Object attach) {
			        System.out.println("Write Handler " +attach + " failed with:");
			        e.printStackTrace();
			    }
			};
	
		try (AsynchronousFileChannel asyncfc = 
				AsynchronousFileChannel.open(fpath, options)) {
			
	        // Write Asynchronously
			byte data[] = "Surprised to see me? ".getBytes();
		    int len = data.length;
		    ByteBuffer out  = ByteBuffer.wrap(data);

	        System.out.println("Main: do 1st async write");
	        asyncfc.write(out, 0, "Write Async # 1", handler);
	
	        data = "Time to Go!".getBytes();
	        out  = ByteBuffer.wrap(data);
	        
	        System.out.println("Main: do 2nd async write");
	        asyncfc.write(out, len+1L, "Write Async # 2", handler);
	        
	        final ByteBuffer buffer = ByteBuffer.allocate(data.length + len);

	        
	        // Read Asynchronously
	        pauseConsole("do Asynchronous Read");
	       
	        System.out.println("Main: doing an async read");
	        asyncfc.read(buffer, 0, "Reading Async!", 
	        		new CompletionHandler<Integer, Object>(){
	            @Override
	            public void completed(Integer num, Object attach) {
			        System.out.println("Read Handler got attachment (" + attach + ")\n\tcompleted with " + num + " bytes read, got:");
	                System.out.println("\t" + new String(buffer.array()));
	            }
	            @Override
			    public void failed(Throwable e, Object attach) {
			        System.out.println(attach + " failed with:");
			        e.printStackTrace();
			    }
	        });
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