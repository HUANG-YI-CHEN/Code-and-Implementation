import java.util.Scanner;


public class Q22161_EuclidProblem 
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
			long A = scn.nextLong();
			long B = scn.nextLong();
			GCD(A, B);
			System.out.println(x+" "+y+" "+gcd);
		}
	}
	public static long x, y;
	public static long gcd;
	public static void GCD(long m, long n)
	{
		if(n == 0)
		{
			x = 1;
			y = 0;
			gcd = m;
		}
		else
		{
			GCD(n, m%n);
			x = y;
			y = (gcd-x*m)/n;
		}
	}
}
