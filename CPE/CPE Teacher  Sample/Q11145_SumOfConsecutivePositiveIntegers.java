import java.util.Scanner;


public class Q11145_SumOfConsecutivePositiveIntegers
{

	/**
	 * @param args
	 */
	/*public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		while(scn.hasNext())
		{
			long n = scn.nextLong();
			while(n % 2 == 0)
				n /= 2;
			int sum = 1;
			for(long i=3; i*i<=n; i++)
			{
				int c = 0;
				while(n%i == 0)
				{
					c++;
					n/=i;
				}
				sum *= (c+1);
			}
			if(n > 1)
				sum *= 2;
			System.out.println(sum);
		}
	}*/
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		while(scn.hasNext())
		{
			long n = scn.nextLong();
			int cnt = 0;
			for(long i=1; i<=n; i++)
			{
				long sum = 0;
				long j=i;
				while(sum < n)
				{
					sum += j++;
				}
				if(sum == n)
					cnt++;
			}			
			System.out.println(cnt);
		}
	}

}
