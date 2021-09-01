import java.util.ArrayList;
import java.util.Scanner;


public class Q2008_10_TheInversionVectorOfAPermutation 
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
			String letter = scn.next();
			ArrayList<Integer> n = new ArrayList<Integer>();
			while(true)
			{
				int t = scn.nextInt();
				if(t == -1)
					break;
				n.add(t);
			}
			if(letter.compareTo("A") == 0)
			{
				String ans = "";
				for(int i=0; i<n.size(); i++)
				{
					int less = 0;
					for(int j=0; j<i; j++)
						if(n.get(j) < n.get(i))
								less ++;
					ans += less+" "; 
				}
				System.out.println(ans.trim());
			}
			else
			{
				boolean[] used = new boolean[n.size()];
				for(int i=0; i<used.length; i++)
					used[i] = false;
				String ans = "";
				for(int i=n.size()-1; i>=0; i--)
				{
					int tmp = 0;
					while(used[tmp])
						tmp++;
					for(int j=0; j<n.get(i); j++)
					{
						do
						{
							tmp++;
						}while(used[tmp]);
					}
					used[tmp] = true;
					ans = tmp+" "+ans;
				}
				System.out.println(ans.trim());				
			}
		}
	}

}
