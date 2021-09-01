import java.util.Scanner;


public class Q10441_LoveCalculator
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		while(scn.hasNext())
		{
			String str1 = scn.nextLine();
			String str2 = scn.nextLine();
			int sum1 = 0;
			int sum2 = 0;
			for(int i=0; i<str1.length(); i++)
				if(c2i(str1.charAt(i)) != -1)
					sum1 += c2i(str1.charAt(i));
			while(sum1 >= 10)
			{
				String tmp = sum1+"";
				sum1 = 0;
				for(int i=0; i<tmp.length(); i++)
					sum1 += (tmp.charAt(i)-'0');
			}
			for(int i=0; i<str2.length(); i++)
				if(c2i(str2.charAt(i)) != -1)
					sum2 += c2i(str2.charAt(i));
			while(sum2 >= 10)
			{
				String tmp = sum2+"";
				sum2 = 0;
				for(int i=0; i<tmp.length(); i++)
					sum2 += (tmp.charAt(i)-'0');
			}
			double out = sum1>sum2? (double)sum2/sum1:(double)sum1/sum2;
			System.out.printf("%.2f %%", out*100);
			if(scn.hasNext())
				System.out.println();
		}
	}
	public static int c2i(char ch)
	{
		if(ch>='A' && ch<='Z')
			return ch-'A'+1;
		else if(ch>='a' && ch<='z')
			return ch-'a'+1;
		else
			return -1;
	}
}
