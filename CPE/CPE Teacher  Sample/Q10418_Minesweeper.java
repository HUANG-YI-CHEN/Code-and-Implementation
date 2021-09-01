import java.util.Scanner;


public class Q10418_Minesweeper
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int cs = 1;
		boolean first = true;
		while(true)
		{
			int n = scn.nextInt();
			int m = scn.nextInt();
			if(n==0 && m==0)
				break;
			if(!first)
				System.out.println();
			first=false;
			System.out.println("Field #"+cs+++":");

			String[] map = new String[n+2];
			map[0] = "";
			map[n+1] = "";
			for(int i=0; i<=m+1; i++)
			{
				map[0] += ".";
				map[n+1] += ".";
			}
			for(int i=1; i<=n; i++)
				map[i] = "."+scn.next()+".";
			
			for(int i=1; i<=n; i++)
			{
				for(int j=1; j<=m; j++)
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
				System.out.println();
			}
		}
	}

}
