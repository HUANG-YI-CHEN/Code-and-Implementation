import java.util.Scanner;

public class Q24711_RareEasyProblem 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		long nm = 0;
		while((nm=scn.nextLong()) != 0)
		{
			String ans = "";
			for(long n=nm; n<nm*1.2; n++)
			{
				if(n - n/10 == nm)
					ans += n+" ";
			}
			System.out.println(ans.substring(0, ans.length()-1));
		}
	}

}
