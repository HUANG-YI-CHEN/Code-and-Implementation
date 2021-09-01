import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;


public class Q10520_Conformity 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		while(true)
		{
			int n = scn.nextInt();
			if(n == 0)
				break;
			HashMap<TreeSet<Integer>, Integer> rank = new HashMap<TreeSet<Integer>, Integer>();
			for(int i=0; i<n; i++)
			{
				TreeSet<Integer> c = new TreeSet<Integer>();
				for(int j=0; j<5; j++)
					c.add(scn.nextInt());
				if(rank.containsKey(c))
					rank.put(c, rank.get(c)+1);
				else
					rank.put(c, 1);
			}
			int max = 0;
			for(int v:rank.values())
				if(v > max)
					max = v;
			int cnt = 0;
			for(int v:rank.values())
				if(v == max)
					cnt++;
					
			System.out.println(max*cnt);
		}
	}

}
