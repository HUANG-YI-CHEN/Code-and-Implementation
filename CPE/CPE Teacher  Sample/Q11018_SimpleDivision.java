import java.util.Arrays;
import java.util.Scanner;


public class Q11018_SimpleDivision 
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
			if(str.compareTo("0") == 0)
				break;
			String[] tmp = str.split(" ");
			int[] dig = new int[tmp.length-1];
			for(int i=0; i<dig.length; i++)
				dig[i] = Integer.parseInt(tmp[i]);
			Arrays.sort(dig);
			int gcd = dig[1]-dig[0];
			for(int i=2; i<dig.length; i++)
				gcd = GCD(dig[i]-dig[0], gcd);
			System.out.println(gcd);
		}
	}
	public static int GCD(int m, int n)
	{
		if(n == 0)
			return m;
		else
			return GCD(n, m%n);
	}
}
