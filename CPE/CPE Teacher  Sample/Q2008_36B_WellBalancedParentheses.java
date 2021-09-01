import java.util.Scanner;


public class Q2008_36B_WellBalancedParentheses 
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
			String str = scn.nextLine();
			if(str.compareTo(".") == 0)
				break;
			int n = Integer.parseInt(str);
			if(n == 0)
				System.out.println();
			else
				gen("", n, 0, 0);			
		}
	}
	public static void gen(String e, int n, int l, int r)
	{
		if(l+r == 2*n)
			System.out.println(e);
		else
		{
			if(r<l)
				gen(e+")", n, l, r+1);
			if(l<n)
				gen(e+"(", n, l+1, r);
		}
	}

}
