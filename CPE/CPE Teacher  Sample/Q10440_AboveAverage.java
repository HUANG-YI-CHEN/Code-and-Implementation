import java.util.Scanner;


public class Q10440_AboveAverage 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int c = scn.nextInt();
		while(c-- > 0)
		{
			int n = scn.nextInt();
			int[] num = new int[n];
			int sum = 0;
			for(int i=0; i<n; i++)
			{
				num[i] = scn.nextInt();
				sum += num[i];
			}
			int cnt = 0;
			for(int i=0; i<n; i++)
			{
				if(num[i]*n > sum)
					cnt ++;
			}
			System.out.printf("%.3f%%\n", (double)cnt*100.0/(double)n);
		}
	}

}
