import java.util.Scanner;


public class Q2008_36A_WellBalancedParentheses 
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
			int idx = -1;
			while((idx = str.lastIndexOf('(')) != -1)
			{
				if(idx+1<str.length() && str.charAt(idx+1)==')')
					str = str.substring(0, idx)+str.substring(idx+2, str.length());
				else
					break;
			}
			if(!str.contains("(") && !str.contains(")"))
				System.out.println("This string of parentheses is well-balanced !");
			else
				System.out.println("This string of parentheses is not well-balanced !");
		}
	}

}
