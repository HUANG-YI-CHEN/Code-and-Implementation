import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Q2008_31_mWayMerge 
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
			int m = scn.nextInt();
			int n = scn.nextInt();
			ArrayList<Integer> num = new ArrayList<Integer>(); 
			for(int i=0; i<m; i++)
				for(int j=0; j<n; j++)
					num.add(scn.nextInt());
			Integer[] sortednum = new Integer[num.size()];
			sortednum = num.toArray(sortednum);
			Arrays.sort(sortednum);
			System.out.print(sortednum[0]);
			for(int i=1; i<sortednum.length; i++)
				System.out.print(" "+sortednum[i]);
			System.out.println();
		}		
	}

}
