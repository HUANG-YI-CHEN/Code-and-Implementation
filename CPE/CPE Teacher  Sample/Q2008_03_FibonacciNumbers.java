import java.util.Scanner;


public class Q2008_03_FibonacciNumbers 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int cs = 1;
		while(scn.hasNext())
		{
			int n = scn.nextInt();
			System.out.println("case "+cs+":");
			long Fn = F(n);
			if(Fn < Math.pow(2, 32))
				System.out.println(Fn);
			else
				System.out.println("overflow");
			System.out.println();
			cs++;
		}
	}
	
	public static long F(int n)
	{
		if(n<=1)
			return n;
		long f0 = 0;
		long f1 = 1;
		for(int i=2; i<=n; i++)
		{
			long tmp = f0+f1;
			f0 = f1;
			f1 = tmp;
		}
		return f1;
	}

}
