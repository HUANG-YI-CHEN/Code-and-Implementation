import java.util.Scanner;


public class Q10453_OddSum 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int cs = scn.nextInt();
		for(int idx=1; idx<=cs; idx++)
		{
			int a = scn.nextInt();
			int b = scn.nextInt();
			int sum = 0;
			for(int i=a; i<=b; i++)
				if(i%2 == 1)
					sum += i;
			System.out.println("Case "+idx+": "+sum);
		}
	}

}
