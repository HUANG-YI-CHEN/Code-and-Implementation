import java.util.Calendar;
import java.util.Scanner;


public class Q22801_DoomsDayAlgorithm 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String[] dayOfWeek = {"", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		Scanner scn = new Scanner(System.in);
		int cs = scn.nextInt();
		while(cs > 0)
		{
			int m = scn.nextInt();
			int d = scn.nextInt();
			Calendar t = Calendar.getInstance();
			t.set(2011, m-1, d);
			System.out.println(dayOfWeek[t.get(Calendar.DAY_OF_WEEK)]);
			cs--;
		}
	}

}
