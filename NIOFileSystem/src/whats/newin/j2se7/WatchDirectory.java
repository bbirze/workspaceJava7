package whats.newin.j2se7;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;
import static java.nio.file.StandardWatchEventKinds.OVERFLOW;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.HashMap;
import java.util.Map;


public class WatchDirectory {
	private static Map<WatchKey,Path> keys = new HashMap<WatchKey,Path>();
	private static WatchService watchService;

	private static void registerDir(Path dir) throws IOException {
		WatchKey key;
		System.out.println("Register directory: " + dir + " with Watch Service");
		key = dir.register(watchService, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
		keys.put(key, dir);                // store dir for later!
	}

	public static void main(String[] args) {
		try {                              
			watchService = FileSystems.getDefault().newWatchService();
		                                   // register two directories with watcher
			registerDir(Paths.get("C:/srcDir/subDir1/subDir13"));
			registerDir(Paths.get("C:/srcDir/subDir1/subDir12"));		
		} catch (IOException e) {
			System.out.println("WatchDirectory constructor caught exception"+ e.getMessage());
		}
		
		System.out.println("Starting Watching the Watch Service Thread");
		new Thread() {                     // process file events
			public void run() {
				WatchKey key;
				while (true) {
					try {
						System.out.println("\nWait indefinitely for event");
						key = watchService.take();
					} catch (InterruptedException e) {
						System.out.println(getName() + " Caught Exception: " + e.getMessage());
						break;
					}
					Path dir = keys.get(key);
					if (dir == null) {
						System.out.println("WatchKey contains null path!");
						continue;
					}
					System.out.println("Watcher Event on Directory: " + dir);
					
					for (WatchEvent<?> event : key.pollEvents()) {

						WatchEvent.Kind kind = event.kind();
						if (kind == OVERFLOW) {
							System.out.println("\tReturned Overflow Event!");
							continue; // ignore for now
						}
						WatchEvent<Path> ev = (WatchEvent<Path>) event;
						Path name = ev.context();   // file name is in event
													// context
						Path fpath = dir.resolve(name);
						System.out.println("\tReturned Event of type:" + kind.name());
						System.out.println("\t         On file: " + fpath);
					}
					// Very Important! Reset Key!!!
					boolean valid = key.reset();
					if (!valid) {
						System.out.println("\nKey is No Longer Valid!");
						break;
					}
				}
				System.out.println("Watcher Thread Exiting!");
			}
		}.start();
		
		try {
			InputStreamReader cin = new InputStreamReader(System.in);
			System.out.println("\nHit Enter to close the WatchService:>");
			cin.read();
			watchService.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
}

}
