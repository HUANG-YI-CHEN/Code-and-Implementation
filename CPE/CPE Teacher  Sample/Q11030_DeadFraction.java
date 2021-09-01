import java.util.Scanner;


public class Q11030_DeadFraction 
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
			String dig = str.substring(2, str.length()-3);
			int a = Integer.MAX_VALUE;
			int b = Integer.MAX_VALUE;
			for(int i=dig.length()-1; i>=0; i--)
			{
				int x = Integer.parseInt(dig) - Integer.parseInt(dig.substring(0, i).compareTo("")==0?"0":dig.substring(0, i));
				int y = 0;
				for(int j=dig.length()-1; j>=0; j--)
				{
					if(j >= i)
						y = y*10+9;
					else
						y = y*10;
				}
				int gcd = GCD(x, y);
				x /= gcd;
				y /= gcd;
				if(y<b)
				{
					a = x;
					b = y;
				}
			}
			System.out.println(a+"/"+b);
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
