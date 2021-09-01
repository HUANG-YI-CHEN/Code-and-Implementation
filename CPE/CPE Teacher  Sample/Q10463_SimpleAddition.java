import java.util.Scanner;


public class Q10463_SimpleAddition 
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
			long p = scn.nextLong();
			long q = scn.nextLong();
			if(p<0 && q<0)
				break;
			long sum = 0;
			for(long i=p; i<=q; i++)
				sum += F(i);
			System.out.println(sum);
		}
	}
	public static long F(long n)
	{
		if(n%10 > 0)
			return n%10;
		else if(n == 0)
			return 0;
		return F(n/10);
	}
}
