import java.math.BigInteger;
import java.util.Scanner;


public class Q10460_YouCanSay11 
{

	/**
	 * @param args
	 */
/*	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String str = "";
		while((str=scn.nextLine()).compareTo("0")!=0)
		{
			int s1=0, s2=0;
			for(int i=0; i<str.length(); i++)
			{
				if(i%2==0)
					s1 += (str.charAt(i)-'0');
				else
					s2 += (str.charAt(i)-'0');
			}
			if(Math.abs(s1-s2)%11 == 0)
				System.out.println(str+" is a multiple of 11.");
			else
				System.out.println(str+" is not a multiple of 11.");
		}
	}
*/
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String str = "";
		while((str=scn.nextLine()).compareTo("0")!=0)
		{
			BigInteger bi = new BigInteger(str);
			if(bi.mod(new BigInteger("11")).compareTo(BigInteger.ZERO) == 0)
				System.out.println(str+" is a multiple of 11.");
			else
				System.out.println(str+" is not a multiple of 11.");
		}
	}
}
