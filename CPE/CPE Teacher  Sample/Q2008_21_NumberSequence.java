import java.util.Scanner;


public class Q2008_21_NumberSequence 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int cs = scn.nextInt();
		for(int c=1; c<=cs; c++)
		{
			int n = scn.nextInt();
			int i = 1;
			int si = 1;
			int sum = 1;
			while(sum < n)
			{
				i++;
				int tmp = i;
				while(tmp > 0)
				{
					si ++;
					tmp /= 10;
				}
				sum += si;
			}
			sum -= si;
			
			//System.out.println(i+" "+sum);
			String ans = ""; 
			for(int j=1; j<=i; j++)
				ans += j;
			System.out.println("Case "+c+": "+ans.charAt(n-sum-1));
		}
	}

}
