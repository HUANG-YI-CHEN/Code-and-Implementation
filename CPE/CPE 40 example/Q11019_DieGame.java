import java.util.Scanner;


public class Q11019_DieGame
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
			int nc = scn.nextInt();
			if(nc == 0)
				break;
			int t=1, n=2, w=3, e=4, s=5, b=6;
			for(int i=0; i<nc; i++)
			{
				String cmd = scn.next();
				if(cmd.compareTo("north") == 0)
				{
					int tmp = t;
					t = s;
					s = b;
					b = n;
					n = tmp;
				}
				else if(cmd.compareTo("east") == 0)
				{
					int tmp = t;
					t = w;
					w = b;
					b = e;
					e = tmp;
				}
				else if(cmd.compareTo("south") == 0)
				{
					int tmp = t;
					t = n;
					n = b;
					b = s;
					s = tmp;
				}
				else if(cmd.compareTo("west") == 0)
				{
					int tmp = t;
					t = e;
					e = b;
					b = w;
					w = tmp;
				}				
			}
			System.out.println(t);
		}
	}

}
