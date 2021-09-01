import java.util.ArrayList;
import java.util.Scanner;


public class Q2008_28_LongestMonotonicallyIncreasingSubsequence 
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
			int n = scn.nextInt();
			int[] m = new int[n];
			for(int i=0; i<n; i++)
				m[i] = scn.nextInt();
			for(int i=n; i>=1; i--)
			{
				ans = new ArrayList<ArrayList<Integer>>();
				comb(new ArrayList<Integer>(), m, i);
				if(!ans.isEmpty())
				{
					System.out.println(ans.size());
					for(ArrayList<Integer> e:ans)
					{
						System.out.print(m[e.get(0)]);
						for(int j=1; j<e.size(); j++)
							System.out.print(" "+m[e.get(j)]);
						System.out.println();
					}
					break;
				}
			}
		}
	}

	public static ArrayList<ArrayList<Integer>> ans;
	public static void comb(ArrayList<Integer> e, int[] m, int k)
	{
		if(e.size() == k && inc(e, m))
		{
			ans.add(new ArrayList<Integer>(e));	
		}
		else
		{
			for(int i=e.isEmpty()?0:e.get(e.size()-1)+1; i<m.length; i++)
			{
				e.add(i);
				comb(e, m, k);
				e.remove(e.size()-1);
			}
		}
	}
	public static boolean inc(ArrayList<Integer> e, int[] m)
	{
		for(int i=1; i<e.size(); i++)
			if(m[e.get(i)] < m[e.get(i-1)])
				return false;
		return true;
	}
}
