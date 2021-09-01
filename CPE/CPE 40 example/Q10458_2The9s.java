import java.util.Scanner;

public class Q10458_2The9s 
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
			if(str.compareTo("0") == 0)
				break;
			int sum = 0;
			for(int i=0; i<str.length(); i++)
				sum += (str.charAt(i)-'0');
			if(sum%9 != 0)
				System.out.println(str+" is not a multiple of 9.");
			else
			{
				int degree = 1;
				while(sum%9==0 && sum>=10)
				{
					degree++;
					String tmp = sum+"";
					sum = 0;
					for(int i=0; i<tmp.length(); i++)
						sum += (tmp.charAt(i)-'0');
				}
				System.out.println(str+" is a multiple of 9 and has 9-degree "+degree+".");
			}
		}
	}

}
