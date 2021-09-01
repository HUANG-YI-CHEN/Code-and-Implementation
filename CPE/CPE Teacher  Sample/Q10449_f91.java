import java.util.Scanner;


public class Q10449_f91 
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
			int n = scn.nextInt();
			if(n == 0)
				break;
			System.out.println("f91("+n+") = "+F91(n));
		}
	}
	public static int F91(int n)
	{
		if(n <= 100)
			return F91(F91(n+11));
		else
			return n-10;
	}
}
