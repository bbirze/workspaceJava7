package labs.solutions.lab02;

public class StringWork {

	public static void main(String[] args) {
		String s = "happy look you today.";
		String happy;
		String look;
		String you;
		String today;
		
		happy = s.substring(0, 5);
		look  = s.substring(6, 10);
		you   = s.substring(11, 14);
		today = s.substring(15, 20);
		System.out.println(you + " " + look + " " + happy + " " + today + ".");
		
		StringBuffer sb = new StringBuffer();
		int length = 0;
		
		// insert "you "
		sb.insert(length, you);
		sb.insert(you.length(), " ");
		length = you.length() +1;

		// insert "look "		
		sb.insert(length, look);
		sb.insert(length + look.length(), " ");
		length = length + look.length() + 1;
		
		// insert "happy "		
		sb.insert(length, happy);
		sb.insert(length + happy.length(), " ");
		length = length + happy.length() + 1;

		// insert "today "		
		sb.insert(length, today);
		sb.insert(length + today.length(), ".");

		System.out.println(sb);
		


	}
}
