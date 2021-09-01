import java.util.Scanner;


public class Q2008_04_GreatestCommonDivisor 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int cs = 1;
		while(scn.hasNext())
		{
			int a = scn.nextInt();
			int b = scn.nextInt();
			System.out.println("case "+cs+":");
			System.out.println(gcd(a, b));
			System.out.println();
			cs++;
		}
	}
	
	public static int gcd(int a, int b)
	{
		return b==0?a:gcd(b, a%b);
	}
}
