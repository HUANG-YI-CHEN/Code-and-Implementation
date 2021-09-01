import java.util.Scanner;


public class Q10428_SimplyEmirp
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
			int n = scn.nextInt();
			int tmp = n;
			int m = 0;
			while(tmp > 0)
			{
				m = m*10 + tmp%10;
				tmp /= 10;
			}
			if(!isPrime(n))
				System.out.println(n+" is not prime.");
			else
			{
				if(n == m || !isPrime(m))
					System.out.println(n+" is prime.");
				else
					System.out.println(n+" is emirp.");
			}
		}
	}
	
	public static boolean isPrime(int n)
	{
		if(n < 2)
			return false;
		else if(n == 2 || n == 3)
			return true;
		else
			for(int i=2; i*i<=n; i++)
				if(n%i == 0)
					return false;
		return true;
	}
}
