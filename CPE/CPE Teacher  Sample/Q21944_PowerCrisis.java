import java.util.Scanner;


public class Q21944_PowerCrisis 
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
			for(int m=1; true; m++)
			{
				boolean[] turnoff = new boolean[n+1];
				for(int j=1; j<=n; j++)
					turnoff[j] = false;
				int current = 1;
				turnoff[current] = true;
				int sum = 1;
				while(true)
				{
					for(int j=1; j<=m; j++)
					{
						do
						{
							current++;
							if(current > n)
								current = 1;
						}while(turnoff[current]);
					}
					if(current == 13)
						break;
					turnoff[current] = true;					
					sum++;
				}
				if(sum == n-1)
				{
					System.out.println(m);
					break;
				}
			}
		}
	}

}
