import java.util.Scanner;


public class Q10405_JollyJumpers 
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
			int[] num = new int[n];
			for(int i=0; i<n; i++)
				num[i] = scn.nextInt();
			boolean[] find = new boolean[n];
			for(int i=1; i<n; i++)
				find[i] = false;
			for(int i=1; i<n; i++)
			{
				if(Math.abs(num[i]-num[i-1]) == 0 || Math.abs(num[i]-num[i-1]) >= n || find[Math.abs(num[i]-num[i-1])])
				{
					System.out.println("Not jolly");
					break;
				}
				find[Math.abs(num[i]-num[i-1])] = true;
				if(i == n-1)
					System.out.println("Jolly");
			}
			if(n < 2)
				System.out.println("Jolly");
		}
	}

}
