import java.util.Scanner;


public class Q11067_Cola 
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
			int max = 0;
			for(int i=0; i<=2; i++)
			{
				int sum = 0;
				int n1 = n;
				int n2=  i;
				do
				{
					//System.out.println(n1+" "+n2);
					sum += n1;
					int nt = n1+n2;
					n2 = nt%3;
					n1 = nt/3;
				}while(n1>0);
				if(n2 >= i && sum > max)
					max = sum;
			}
			System.out.println(max);
		}
		
	}

}
