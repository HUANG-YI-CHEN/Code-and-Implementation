import java.util.Scanner;


public class Q10479_Cubes 
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
			long n = scn.nextLong();
			if(n == 0)
				break;
			boolean find = false;
			for(long y=1; ; y++)
			{
				if((y+1)*(y+1)*(y+1)-y*y*y > n)
					break;
				for(long x=y+1; ; x++)
				{
					if(x*x*x-y*y*y == n)
					{
						System.out.println(x+" "+y);
						find = true;
						break;
					}
					else if(x*x*x-y*y*y > n)
						break;
				}
			}
			if(!find)
				System.out.println("No solution");
		}
	}

}
