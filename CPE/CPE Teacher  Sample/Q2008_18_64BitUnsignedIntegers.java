import java.math.BigInteger;
import java.util.Scanner;


public class Q2008_18_64BitUnsignedIntegers
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
			String str = scn.nextLine();
			if(str.compareTo(".") == 0)
				break;
			String[] n = str.split(" ");
			BigInteger b1 = new BigInteger(n[0]);
			BigInteger b2 = new BigInteger(n[1]);
			BigInteger b32 = new BigInteger("2");
			b32 = b32.pow(32);
			BigInteger ans = b1.multiply(b32).add(b2);
			System.out.println(ans.toString());
		}
	}

}
