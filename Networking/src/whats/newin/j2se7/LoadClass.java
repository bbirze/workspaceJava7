package whats.newin.j2se7;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class LoadClass {
	public static String JarName = "file:simple.jar";
	public static String JarClass = "simple.WhatsNew";
	
	public static void main(String[] args) {
        // Getting the jar URL which contains target class

		loadAndRunClass("Loading Jar and Class with Brand new UrlClassLoader");
        pauseConsole("Load and Run new Version of What's New");
        loadAndRunClass("Re-Loading Jar and Class with Brand new UrlClassLoader");
	}
	
	public static void loadAndRunClass(String heading)
	{
	    URL[] url;
		System.out.println("\n---------------------");
		System.out.println(heading);
		System.out.println("Main: Load jar :" + JarName);
		try {
			url = new URL[] { new URL(JarName) };
			URLClassLoader urlClassLoader = new URLClassLoader(url);

			Class cl = urlClassLoader.loadClass(JarClass);
			Runnable whatsNew = (Runnable) cl.newInstance();

			System.out.println("Main: Loaded Class :" + JarClass);
			System.out.println("Main: Running :" + JarClass);

			whatsNew.run();
			urlClassLoader.close();
			System.out.println("Main: Loader is Closed!");
			
		} catch (MalformedURLException | IllegalAccessException
				| IllegalArgumentException | InstantiationException
				| ClassNotFoundException | SecurityException e) {
			System.out.println("loadAndRunClass caught exception: "
					+ e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("loadAndRunClass caught General IUexception: "
					+ e.getMessage());
			e.printStackTrace();
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
