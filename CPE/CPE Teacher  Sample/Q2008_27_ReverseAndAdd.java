import java.util.Scanner;


public class Q2008_27_ReverseAndAdd
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int cs = scn.nextInt();
		while(cs-- > 0)
		{
			long n = scn.nextLong();
			String ans = n+"";
			while(true)
			{
				n += reverse(n);
				if(n > Math.pow(2, 32)-1)
				{
					ans += " overflow";
					break;
				}
				else if(palindrome(n))
				{
					ans += " "+n;
					break;
				}
				else
					ans += " "+n;
			}
			System.out.println(ans);
		}
	}
	public static long reverse(long n)
	{
		String str = "";
		while(n > 0)
		{
			str += (n%10);
			n /= 10;
		}
		return Long.parseLong(str);
	}
	public static boolean palindrome(long n)
	{
		if(n == reverse(n))
			return true;
		else
			return false;
	}
}
