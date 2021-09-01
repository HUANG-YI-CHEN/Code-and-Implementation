import java.util.Scanner;


public class Q2008_01_GenerationOfCombinations 
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
			int k = scn.nextInt();
			int[] c = new int[k];
			for(int i=0; i<k; i++)
				c[i] = i+1;
			System.out.println("case "+cs+":");
			while(n>0 && k>0)
			{
				for(int i=0; i<k; i++)
					System.out.print(c[i]);
				System.out.println();
				int idx = -1;
				for(int i=k-1; i>=0; i--)
					if(c[i] < n-(k-1-i))
					{
						idx = i;
						break;
					}
				if(idx == -1)
					break;
				c[idx]++;
				for(int i=idx+1; i<k; i++)
					c[i] = c[i-1]+1;
			}
			System.out.println();
			cs++;
		}
	}

}
