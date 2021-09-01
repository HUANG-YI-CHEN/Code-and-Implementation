import java.math.BigInteger;
import java.util.Scanner;


public class Q10413_AnEasyProblem
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
			String str = scn.nextLine();
			int maxB = 1;
			for(int i=0; i<str.length(); i++)
				if(c2b(str.charAt(i)) > maxB)
					maxB = c2b(str.charAt(i));
			maxB++;
			while(maxB <= 62)
			{
				if(value(str, new BigInteger(maxB+"")).mod(new BigInteger((maxB-1)+"")).compareTo(BigInteger.ZERO) == 0)
					break;
				maxB++;
			}
			if(maxB > 62)
				System.out.println("such number is impossible!");
			else
				System.out.println(maxB);
		}
	}
	
	public static int c2b(char ch)
	{
		if(ch>='0' && ch<='9')
			return ch-'0';
		else if(ch>='A' && ch<='Z')
			return ch-'A'+10;
		else
			return ch-'a'+36;
	}
	
	public static BigInteger value(String str, BigInteger base)
	{
		BigInteger sum = new BigInteger("0");
		
		for(int i=str.length()-1; i>=0; i--)
		{
			sum = sum.multiply(base).add(new BigInteger(c2b(str.charAt(i))+""));
		}
		
		return sum;
	}
}
