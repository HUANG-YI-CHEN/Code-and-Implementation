import java.math.BigInteger;
import java.util.Scanner;

public class Q10681_HowManyFibs 
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
			if(str.compareTo("0 0") == 0)
				break;
			String[] n = str.split(" ");
			BigInteger n1 = new BigInteger(n[0]);
			BigInteger n2 = new BigInteger(n[1]);
			BigInteger f1 = new BigInteger("1");
			BigInteger f2 = new BigInteger("2");
			int cnt = 0;
			while(true)
			{
				if(f1.compareTo(n1) >= 0 && f1.compareTo(n2) <= 0)
					cnt++;
				BigInteger tmp = new BigInteger(f2.toString());
				f2 = f2.add(f1);
				f1 = tmp;
				if(f1.compareTo(n2) > 0)
					break;
			}
			System.out.println(cnt);
		}
	}
}
