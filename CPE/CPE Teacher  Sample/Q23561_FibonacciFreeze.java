import java.math.BigInteger;
import java.util.Scanner;


public class Q23561_FibonacciFreeze 
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
			BigInteger f0 = new BigInteger("0");
			BigInteger f1 = new BigInteger("1");
			if(n == 0)
				System.out.println("The Fibonacci number for 0 is 0");
			else if(n == 1)
				System.out.println("The Fibonacci number for 1 is 1");
			else
			{
				for(int i=2; i<=n; i++)
				{
					BigInteger tmp = new BigInteger(f1.toString());
					f1 = f1.add(f0);
					f0 = tmp;
				}
				System.out.println("The Fibonacci number for "+n+" is "+f1);
			}
		}
	}

}
