import java.util.Arrays;
import java.util.Scanner;


public class Q10409_AMidSummerNightsDream 
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
			Arrays.sort(num);
			if(n%2 == 1)
			{
				int mid = num[n/2];
				int c = 0;
				for(int i=0; i<n; i++)
					if(num[i] == mid)
						c++;
				System.out.println(mid+" "+c+" 1");
			}
			else
			{
				int min = num[n/2-1];
				int max = num[n/2];
				int c = 0;
				for(int i=0; i<n; i++)
					if(num[i] == min || num[i] == max)
						c++;
				System.out.println(min+" "+c+" "+(max-min+1));				
			}
		}
	}

}
