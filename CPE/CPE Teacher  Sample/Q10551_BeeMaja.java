import java.util.Scanner;


public class Q10551_BeeMaja 
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
			int n = scn.nextInt();
			int level = 0;
			int sum = 0;
			for(int i=0; sum<n; i++)
			{
				if(i == 0)
					sum += Math.pow(6, i);
				else
					sum += 6*i;
				level++;
			}
			//System.out.println(level+" "+sum);
			int x = level-1;
			int y = 0;
			for(int i=0; i<level-1; i++)
				if(sum > n)
				{
					y--;
					sum--;
				}
			for(int i=0; i<level-1; i++)
				if(sum > n)
				{
					x--;
					sum--;
				}
			for(int i=0; i<level-1; i++)
				if(sum > n)
				{
					x--;
					y++;
					sum--;
				}
			for(int i=0; i<level-1; i++)
				if(sum > n)
				{
					y++;
					sum--;
				}
			for(int i=0; i<level-1; i++)
				if(sum > n)
				{
					x++;
					sum--;
				}
			for(int i=0; i<level-1; i++)
				if(sum > n)
				{
					x++;
					y--;
					sum--;
				}
			System.out.println(x+" "+y);
		}
	}

}
