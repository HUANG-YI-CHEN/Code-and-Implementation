import java.math.BigInteger;
import java.util.Scanner;


public class Q10459_Krakovia 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int cs = 1;
		while(true)
		{
			int n = scn.nextInt();
			int f = scn.nextInt();
			if(n==0 && f==0)
				break;
			scn.nextLine();
			BigInteger sum = new BigInteger("0");
			for(int i=0; i<n; i++)
			{
				sum = sum.add(new BigInteger(scn.nextLine()));
			}
			BigInteger avg = sum.divide(new BigInteger(f+""));
			System.out.println("Bill #"+cs+" costs "+sum+": each friend should pay "+avg);
			System.out.println();
			cs++;
		}
	}

}
