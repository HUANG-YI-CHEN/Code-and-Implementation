import java.util.Scanner;


public class Q10468_MaximumProduct 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int cs = 1;
		while(scn.hasNext())
		{
			int n = scn.nextInt();
			int[] num = new int[n];
			for(int i=0; i<n; i++)
				num[i] = scn.nextInt();
			int max = Integer.MIN_VALUE;
			for(int i=0; i<n; i++)
				for(int j=i; j<n; j++)
				{
					int p = 1;
					for(int k=i; k<=j; k++)
						p *= num[k];
					if(p > max)
						max = p;
				}
			System.out.println("Case #"+cs+": The maximum product is "+max+".\n");
			cs++;
		}
	}

}
