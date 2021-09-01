import java.util.Scanner;


public class Q10407_HashmatTheBraveWarrior 
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		while(scn.hasNext())
		{
			long i1 = scn.nextLong();
			long i2 = scn.nextLong();
			System.out.println(Math.abs(i1-i2));
		}
	}

}
