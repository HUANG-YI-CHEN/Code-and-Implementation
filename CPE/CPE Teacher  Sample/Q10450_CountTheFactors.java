import java.util.Scanner;


public class Q10450_CountTheFactors 
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
			System.out.print(n+" : ");
			int c = 0;
			for(int p=2; p*p<=n; p++)
			{
				if(n%p == 0)
				{
					c++;
					while(n%p == 0)
						n /= p;
				}
			}
			if(n!=1)
				c++;
			System.out.println(c);
		}
	}

}
