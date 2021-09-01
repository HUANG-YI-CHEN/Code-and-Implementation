import java.util.ArrayList;
import java.util.Scanner;


public class Q2008_25_Permutations 
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int cs = scn.nextInt();
		for(int c=1; c<=cs; c++)
		{
			int n = scn.nextInt();
			System.out.println("Case "+c+":");
			perm(new ArrayList<Integer>(), n);
		}
	}
	public static void perm(ArrayList<Integer> e, int n)
	{
		if(e.size() == n)
		{
			System.out.print(e.get(0));
			for(int i=1; i<e.size(); i++)
				System.out.print(" "+e.get(i));
			System.out.println();
		}
		else
		{
			for(int i=1; i<=n; i++)
				if(!e.contains(i))
				{
					e.add(i);
					perm(e, n);
					e.remove(e.size()-1);
				}
		}
	}
}
