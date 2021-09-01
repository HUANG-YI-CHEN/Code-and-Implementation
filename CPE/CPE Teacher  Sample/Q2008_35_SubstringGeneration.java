import java.util.Scanner;


public class Q2008_35_SubstringGeneration 
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
			System.out.println("For s="+str+", the substrings are");
			ans = "";
			subset("", str.length(), str);
			System.out.println(ans.trim());
		}
	}
	public static String ans = "";
	public static void subset(String e, int n, String str)
	{
		if(n == 0)
			ans += "\""+e+"\" ";
		else
		{
			subset(e, n-1, str.substring(1));
			subset(e+str.charAt(0), n-1, str.substring(1));
		}
	}
}
