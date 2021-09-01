import java.math.BigInteger;
import java.util.Scanner;


public class Q10548_OceanDeepMakeItShallow 
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
			BigInteger num = new BigInteger("0");
			while(true)
			{
				String str = scn.nextLine();
				for(int i=0; i<str.length(); i++)
				{
					if(str.charAt(i) == '1')
						num = num.shiftLeft(1).add(BigInteger.ONE);
					else if(str.charAt(i) == '0')
						num = num.shiftLeft(1);
					else if(str.charAt(i) == '#')
						break;
				}
				if(str.contains("#"))
					break;
			}
			if(num.mod(new BigInteger("131071")).compareTo(BigInteger.ZERO) == 0)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}

}
