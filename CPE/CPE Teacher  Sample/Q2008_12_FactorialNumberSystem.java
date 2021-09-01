import java.util.Scanner;


public class Q2008_12_FactorialNumberSystem 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		long[] Fac = new long[20];
		Fac[0] = 1;
		for(int i=1; i<Fac.length; i++)
		{
			Fac[i] = Fac[i-1]*i;
			//System.out.println(Fac[i]);
		}
		Scanner scn = new Scanner(System.in);
		while(true)
		{
			long n = scn.nextLong();
			if(n == -1)
				break;
			if(n == 0)
				System.out.println("0");
			else
			{
				n = (1+n)*n/2;
				String ans = "";
				int maxIdx = Fac.length-1;
				while(n < Fac[maxIdx])
					maxIdx--;
				for(int i=maxIdx; i>=0; i--)
				{
					ans += (n/Fac[i])+" ";
					n %= Fac[i];
				}
				System.out.println(ans.trim());
			}
		}
	}

}
