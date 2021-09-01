import java.util.Scanner;


public class Q10471_CountingChaos 
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int cs = scn.nextInt();
		while(cs-- >0)
		{
			String[] str = scn.next().split(":");
			int hh = Integer.parseInt(str[0]);
			int mm = Integer.parseInt(str[1]);
			do
			{
				if(++mm == 60)
				{
					mm = 0;
					hh = (hh+1)%24;
				}
			}while(!palindromic(hh, mm));
			System.out.printf("%02d:%02d\n",hh, mm);
		}
	}
	public static boolean palindromic(int hh, int mm)
	{
		String str = "";
		if(hh > 0)
		{
			str = hh+"";
			if(mm<10)
				str += "0"+mm;
			else
				str += mm;
		}
		else
			str = mm+"";
		for(int i=0; i<str.length(); i++)
			if(str.charAt(i) != str.charAt(str.length()-1-i))
				return false;
		return true;
	}
}
