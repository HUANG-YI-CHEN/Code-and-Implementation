import java.util.Scanner;
import java.util.TreeSet;


public class Q2008_02_SubsetGeneration
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
			int pow = (int)Math.pow(2, n);
			System.out.println("case "+cs+":");
			for(int i=0; i<pow; i++)
			{
				TreeSet<Integer> subset = new TreeSet<Integer>();
				int tmp = i;				
				for(int j=1; j<=n; j++)
				{
					if(tmp%2 == 1)
						subset.add(j);
					tmp/=2;
				}
				String str = subset.toString();
				str = str.replace("[", "{");
				str = str.replace("]", "}");
				str = str.replace(" ", "");
				System.out.println(str);
			}
			System.out.println();
			cs++;
		}
	}

}
