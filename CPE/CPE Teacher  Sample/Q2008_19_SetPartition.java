import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;


public class Q2008_19_SetPartition 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		boolean first = true;
		Scanner scn = new Scanner(System.in);
		while(true)
		{
			String str = scn.nextLine();
			if(str.compareTo(".") == 0)
				break;
			if(first)
				first = false;
			else
				System.out.println();
			str = str.substring(1, str.length()-1);
			String[] tmp = str.split(" ");
			int n = tmp.length;
			long[] a = new long[n];			
			long sum = 0;
			for(int i=0; i<n; i++)
			{
				a[i] = Long.parseLong(tmp[i]);
				sum += a[i];
			}
			Arrays.sort(a);
			ArrayList<String> ans = new ArrayList<String>();
			for(int i=0; i<Math.pow(2, n); i++)
			{
				String set = "";
				long s = 0;				
				int idx = i;
				for(int j=0; j<n; j++)
				{
					if(idx%2 == 1)
					{
						s += a[j];
						set += a[j]+" ";
					}
					idx /= 2;
				}
				if(s*2 == sum)
				{
					ans.add(set.trim());
				}
			}
			if(ans.size() == 0)
				System.out.println("No such subset");
			else
			{
				if(ans.size() > 1)
					System.out.println(ans.size()+" subsets.");
				else
					System.out.println(ans.size()+" subset.");
				String[] sortedAns = new String[ans.size()];
				sortedAns = ans.toArray(sortedAns);
				for(int i=0; i<sortedAns.length; i++)
				{
					for(int j=i+1; j<sortedAns.length; j++)
					{
						String[] tmpi = sortedAns[i].split(" ");
						String[] tmpj = sortedAns[j].split(" ");
						if(tmpi.length > tmpj.length)
						{
							String tt = sortedAns[i];
							sortedAns[i] = sortedAns[j];
							sortedAns[j] = tt;
						}
						else if(tmpi.length == tmpj.length)
						{
							for(int k=0; k<tmpi.length; k++)
							{								
								if(Long.parseLong(tmpi[k]) < Long.parseLong(tmpj[k]))
									break;
								else if(Long.parseLong(tmpi[k]) > Long.parseLong(tmpj[k]))
								{
									String tt = sortedAns[i];
									sortedAns[i] = sortedAns[j];
									sortedAns[j] = tt;
									break;
								}
							}
						}
					}
					System.out.println("{"+sortedAns[i]+"}");
				}
			}
		}
	}

}
