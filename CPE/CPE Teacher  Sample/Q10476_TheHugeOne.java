import java.math.BigInteger;
import java.util.Scanner;


public class Q10476_TheHugeOne 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int cs = scn.nextInt();
		scn.nextLine();
		while(cs-- > 0)
		{
			BigInteger M = new BigInteger(scn.nextLine());
			String[] S = scn.nextLine().split(" ");
			for(int i=0; i<S.length; i++)
			{
				if(M.mod(new BigInteger(S[i])).compareTo(BigInteger.ZERO) != 0)
				{
					System.out.println(M+" - Simple.");
					break;
				}
				else if(i == S.length-1)
				{
					System.out.println(M+" - Wonderful.");
				}
			}
		}
	}
}
