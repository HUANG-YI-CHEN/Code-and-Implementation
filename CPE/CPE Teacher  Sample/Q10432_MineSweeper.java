import java.util.Scanner;


public class Q10432_MineSweeper 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int cs = scn.nextInt();
		while(cs>0)
		{
			int n = scn.nextInt();

			String[] map = new String[n+2];
			map[0] = "";
			map[n+1] = "";
			for(int i=0; i<=n+1; i++)
			{
				map[0] += ".";
				map[n+1] += ".";
			}
			for(int i=1; i<=n; i++)
				map[i] = "."+scn.next()+".";
					
			for(int i=1; i<=n; i++)
			{
				String touch = scn.next();
				for(int j=1; j<=n; j++)
				{
					if(touch.charAt(j-1) == 'x')
					{
						if(map[i].charAt(j) == '*')
							System.out.print("*");
						else
						{
							int num = 0;
							if(map[i-1].charAt(j-1) == '*')
								num++;
							if(map[i-1].charAt(j) == '*')
								num++;
							if(map[i-1].charAt(j+1) == '*')
								num++;
							if(map[i].charAt(j-1) == '*')
								num++;
							if(map[i].charAt(j+1) == '*')
								num++;
							if(map[i+1].charAt(j-1) == '*')
								num++;
							if(map[i+1].charAt(j) == '*')
								num++;
							if(map[i+1].charAt(j+1) == '*')
								num++;
							System.out.print(num);
						}
					}
					else
						System.out.print(".");
				}
				System.out.println();
			}
			cs--;
			if(cs > 0)
				System.out.println();
		}

	}

}
