package javaDemos;

import java.io.IOException;
import java.io.InputStreamReader;

public class Mod08_Looping {
	
	private void tryLoops() {
		int[] ary = { 5, 4, 3, 2, 1};
		
		//	For Loop
		System.out.println("Try For Loop ");
		for(int i=0; i < ary.length; i++)  {
			System.out.print(" ary[" + i + "]=" + ary[i]);
		}

		//	While Loop
		pauseConsole("to see While loop");
		
		int i=0;	
		System.out.println("Try While Loop ");
		while(i < ary.length)  {
			System.out.print(" ary[" + i + "]=" + ary[i]);
			i++;
		}

		//	Do While Loop
		pauseConsole("to see Do-While loop");
		i=0;	
		System.out.println("Try Do-While Loop ");
		do  {
			System.out.print(" ary[" + i + "]=" + ary[i]);
			i++;
		} while(i < ary.length);

	}

	private void breakAndContinue() {
		int[][] ary = { { 2, 3, 4, 5 }, { 6, 7, 8, 9 } }; // 2-D array
		int sum = 0;

		//  Simple Unlabeled Break
		pauseConsole("to see simple break");
		System.out.println("Try simple unlabeled break ");
		System.out.println("Entering i-Loop");      

		for (int i = 0; i < ary.length; i++) {         // i-Loop

			System.out.println("\tEntering J-Loop : i = " + i);

			for (int j = 0; j < ary[i].length; j++) {  // J-Loop
				sum += ary[i][j];
				System.out.println("\t    sum = " + sum);
				if (sum > 10)  {
					System.out.println("\t    Hit Break!");
					break;                             // break inner most loop
				}
			}
			System.out.println("\tAt end of J-Loop");  // J-Loop break branches control to here
		}
		System.out.println("At end of i-Loop");  
		
		//  Labeled Break
		pauseConsole("to see Labeled Break");
		System.out.println("Try labeled break ");
		System.out.println("Entering i-Loop");     

 outer: for (int i = 0; i < ary.length; i++) {         // i-Loop
	 
	 		System.out.println("\tEntering J-Loop : i = " + i);
			for (int j = 0; j < ary[i].length; j++) {  // J-Loop
				sum += ary[i][j];
				System.out.println("\t    sum = " + sum);
				if (sum > 25)  {
					System.out.println("\t    Hit Break!");
					break outer;                       // break loop at label outer
				}
			}
			System.out.println("\tAt end of J-Loop");  
		}
		System.out.println("At end of i-Loop");      // break branches control to here

	}
	
	public static void main(String[] args) {
		Mod08_Looping loopIt = new Mod08_Looping();
		
		loopIt.tryLoops();
		loopIt.breakAndContinue();
	}



	private static void pauseConsole(String doNext) {
		try {
			InputStreamReader cin = new InputStreamReader(System.in);
			System.out.println("\n\nHit Enter to "+ doNext +":>");
			cin.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
