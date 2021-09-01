import java.util.Scanner;


public class Q10466_CheapestBase
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int nTest = scn.nextInt();
		for(int i=1; i<=nTest; i++)
		{
			System.out.println("Case "+i+":");
			int[] cost = new int[36];			
			for(int j=0; j<36; j++)
				cost[j] = scn.nextInt();
			int n = scn.nextInt();
			for(int j=0; j<n; j++)
			{
				int min = Integer.MAX_VALUE;
				int[] sum = new int[37];
				int ans = -1;
				int num = scn.nextInt();
				for(int k=2; k<=36; k++)
				{
					int tmp = num;
					sum[k] = 0;
					while(tmp>0)
					{
						sum[k] += cost[tmp%k];
						tmp/=k;
					}
					if(sum[k] < min)
					{
						min = sum[k];								
					}
				}
				System.out.print("Cheapest base(s) for number "+num+": ");
				String str = "";
				for(int k=2; k<=36; k++)
					if(sum[k] == min)
						str += k+" ";
				System.out.println(str.substring(0, str.length()-1));
			}
			if(i < nTest)
				System.out.println();
		}
		
	}

}
