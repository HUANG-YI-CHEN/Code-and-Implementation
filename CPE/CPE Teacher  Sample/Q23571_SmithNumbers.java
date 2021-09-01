import java.util.Scanner;


public class Q23571_SmithNumbers
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
			int n = scn.nextInt();
			n++;
			while(true)
			{
				if(!isPrime(n))
				{
					int s1 = sumOfDig(n);
					int s2 = sumOfPrimeDig(n);
					if(s2 == s1)
						break;
				}
				n++;
			}
			System.out.println(n);
			cs--;
		}
	}
	
	public static int sumOfDig(int n)
	{
		int sum = 0;
		
		while(n > 0)
		{
			sum += n%10;
			n /= 10;
		}
		
		return sum;
	}
	public static int sumOfPrimeDig(int n)
	{
		int sum = 0;
		for(int p=2; p*p<=n; p++)
		{
			while(n%p == 0)
			{
				sum += sumOfDig(p);
				n/=p;
				//System.out.print(p+" ");
			}
		}
		if(n > 1)
		{
			sum += sumOfDig(n);
			//System.out.print(n+" ");
		}
		return sum;
	}
	
	public static boolean isPrime(int n)
	{
		if(n<2)
			return false;
		for(int i=2; i*i<=n; i++)
			if(n%i == 0)
				return false;
		return true;
	}
}
