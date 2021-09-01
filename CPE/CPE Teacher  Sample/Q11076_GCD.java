import java.util.Scanner;


public class Q11076_GCD 
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
			int N = scn.nextInt();
			if(N == 0)
				break;
			int sum = 0;
			for(int i=1; i<N; i++)
				for(int j=i+1; j<=N; j++)
					sum += GCD(i, j);
			System.out.println(sum);
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
