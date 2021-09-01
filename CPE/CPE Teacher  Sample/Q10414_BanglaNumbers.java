import java.math.BigInteger;
import java.util.Scanner;

public class Q10414_BanglaNumbers 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		BigInteger HUNDRED = new BigInteger("100");
		Scanner scn = new Scanner(System.in);
		int cases = 1;		
		while(scn.hasNext())
		{
			BigInteger num = new BigInteger(scn.nextLine());
			System.out.println(cases+". "+su(num.longValue()));
			cases++;
		}
	}

	public static String su(long in)
	{
		String key[] = { " shata ", " hajar ", " lakh ", " kuti " };
		int base[] = { 100, 10, 100, 100 };
		int i = 0;
		String out = "";
		while (in != 0) {
			out = in % base[i] + out;
			if (in >= base[i]) {
				out = key[i] + out;
			}
			in /= base[i];
			i = (i + 1) % 4;

		}
		return out;
	}
}
