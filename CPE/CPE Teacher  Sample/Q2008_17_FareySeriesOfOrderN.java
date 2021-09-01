import java.util.Scanner;
import java.util.TreeMap;


public class Q2008_17_FareySeriesOfOrderN
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		boolean first = true;
		while(true)
		{
			String s = scn.nextLine();
			if(s.compareTo(".") == 0)
				break;
			if(first)
				first = false;
			else
				System.out.println();
			int n = Integer.parseInt(s);
			TreeMap<Double, String> Farey = new TreeMap<Double, String>();
			for(int i=1; i<=n; i++)
			{
				for(int j=0; j<=i; j++)
				{
					double v = (double)j/i;
					int gcd = GCD(i, j);
					s = j/gcd+"/"+i/gcd;
					if(!Farey.containsValue(s))
						Farey.put(v, j+"/"+i);
				}
			}
			System.out.println(Farey.size()+" terms");
			String ans = "";
			int cnt = 0;
			for(String tmp : Farey.values())
			{
				ans += tmp;
				cnt++;
				if(cnt % 100 == 0)
					ans += "\n";
				else
					ans += " ";
			}
			System.out.println(ans.trim());
		}
	}
	public static int GCD(int m, int n) 
	{ 
		if(n == 0)
			return m;
		else
			return GCD(n, m % n); 
	}

}
