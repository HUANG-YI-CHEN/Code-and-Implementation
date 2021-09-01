import java.util.Scanner;


public class Q10510_SuperLongSums 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int cs = scn.nextInt();
		while(cs>0)
		{
			int n = scn.nextInt();
			int[] n1 = new int[n];
			int[] n2 = new int[n];
			for(int i=0; i<n; i++)
			{
				n1[i] = scn.nextInt();
				n2[i] = scn.nextInt();
			}
			int c = 0;
			String str = "";
			for(int i=n-1; i>=0; i--)
			{
				int tmp = n1[i]+n2[i]+c;
				str = (tmp%10) + str;
				if(tmp >= 10)
					c=1;
				else
					c=0;
			}
			System.out.println(str);
			cs--;
			if(cs>0)
				System.out.println();
		}
	}

}
