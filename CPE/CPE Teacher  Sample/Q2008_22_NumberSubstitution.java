import java.util.Scanner;


public class Q2008_22_NumberSubstitution 
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
			StringBuffer n = new StringBuffer(scn.next());
			String a = scn.next();
			String b = scn.next();
			int idx = n.indexOf(a);
			if(idx >= 0)
				n.replace(idx, idx+a.length(), b);
			System.out.println("Case "+c+": "+n);
		}
	}

}
