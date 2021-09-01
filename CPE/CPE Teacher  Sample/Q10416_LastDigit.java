import java.util.Scanner;


public class Q10416_LastDigit
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int[] ans = new int[100];
		for(int i=1; i<=100; i++)
		{
			ans[i%100] = 0;
			for(int j=1; j<=i; j++)
			{
				int tmp = 1;
				for(int k=1; k<=j; k++)
					tmp = (tmp*j) % 10;
				ans[i%100] = (ans[i%100]+tmp) % 10;
			}
		}
		Scanner scn = new Scanner(System.in);
		while(true)
		{
			String str = scn.nextLine();
			if(str.compareTo("0") == 0)
				break;
			if(str.length()>2)
				str = str.substring(str.length()-2);
			System.out.println(ans[Integer.parseInt(str)]);
		}
	}

}
