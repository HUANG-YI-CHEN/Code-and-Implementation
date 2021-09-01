import java.math.BigInteger;
import java.util.Scanner;


public class Q11487_FibonacciNumbers 
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
			System.out.println(F(n).toString());
		}
	}
	public static BigInteger F(int n)
	{
		if(n == 1 || n == 2)
			return BigInteger.ONE;
		BigInteger F1 = BigInteger.ONE;
		BigInteger F2 = BigInteger.ONE;
		for(int i=3; i<=n; i++)
		{
			BigInteger tmp = F1.add(F2);
			F1 = F2;
			F2 = tmp;
		}
		return F2;
	}
}
