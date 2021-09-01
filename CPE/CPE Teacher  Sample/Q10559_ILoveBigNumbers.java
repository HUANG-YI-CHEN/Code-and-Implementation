import java.math.BigInteger;
import java.util.Scanner;


public class Q10559_ILoveBigNumbers
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
			BigInteger f = new BigInteger("1");
			for(int i=1; i<=n; i++)
				f = f.multiply(new BigInteger(i+""));
			int sum = 0;
			while(f.compareTo(BigInteger.ZERO) > 0)
			{
				sum += f.mod(BigInteger.TEN).intValue();
				f = f.divide(BigInteger.TEN);
			}
			System.out.println(sum);
		}
	}

}
