import java.util.Scanner;


public class Q10435_EcologicalPremium 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int cs = scn.nextInt();
		while(cs-- > 0)
		{
			int f = scn.nextInt();
			int sum = 0;
			for(int i=0; i<f; i++)
			{
				int a = scn.nextInt();
				int b = scn.nextInt();
				int c = scn.nextInt();
				sum += (a*c);
			}
			System.out.println(sum);
		}
	}

}
