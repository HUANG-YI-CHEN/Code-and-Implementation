import java.util.Scanner;

public class Q10454_BeatTheSpread
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int cs = scn.nextInt();
		while(cs > 0)
		{
			long s = scn.nextLong();
			long d = scn.nextLong();
			if((s+d)%2 != 0)
				System.out.println("impossible");
			else
			{
				long a = (s+d)/2;
				long b = s - a;
				if(s<0 || b<0)
					System.out.println("impossible");
				else
					System.out.println(a+" "+b);
			}
			cs--;
		}
	}

}
