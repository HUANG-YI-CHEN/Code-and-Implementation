import java.util.Scanner;

public class Q10400_The3NAdd1Problem
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
			int a = scn.nextInt();
			int b = scn.nextInt();
			int max = Integer.MIN_VALUE;
			for(int i=(a<b?a:b); i<=(a>b?a:b); i++)
			{
				int len = 1;
				int tmp = i;
				while(tmp != 1)
				{
					if(tmp%2 == 0)
						tmp /= 2;
					else
						tmp = 3*tmp+1;
					len++;
				}
				if(len > max)
					max = len;
			}
			System.out.println(a+" "+b+" "+max);
		}
	}
}
