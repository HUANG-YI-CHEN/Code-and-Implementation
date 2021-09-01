import java.util.Scanner;


public class Q10023_Divisibility 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int k = scn.nextInt();
		int [] num = new int[n];
		for(int i=0; i<n; i++)
			num[i] = scn.nextInt();
		
		int round = (int)Math.pow(2, n-1);
		for(int i=0; i<round; i++)
		{
			int tmp = i;
			int sum = num[0];
			for(int j=1; j<n; j++)
			{
				if(tmp%2 == 0)
					sum += num[j];
				else
					sum -= num[j];
				tmp /= 2;
			}
			if(sum%k == 0)
			{
				System.out.println("Divisible");
				break;
			}
			else if(i == round-1)
				System.out.println("Not divisible");
		}
	}

}
