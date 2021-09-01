import java.util.Scanner;


public class Q10500_BrickWallPatterns 
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		while(true)
		{
			int n = scn.nextInt();
			if(n == 0)
				break;
			System.out.println(F(n));
		}
	}
	public static long F(int n)
	{
		if(n <= 2)
			return n;
		long f1 = 1;
		long f2 = 2;
		for(int i=3; i<=n; i++)
		{
			long tmp = f1+f2;
			f1 = f2;
			f2 = tmp;
		}
		return f2;
	}

}
