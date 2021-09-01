import java.util.Scanner;


public class Q10473_SummingDigits
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
			int n = scn.nextInt();
			if(n == 0)
				break;
			int fn = 0;
			while(n > 0)
			{
				fn += n%10;
				n /= 10;
			}
			int ffn = 0;
			while(fn > 0)
			{
				ffn += fn%10;
				fn /= 10;
			}
			int fffn = 0;
			while(ffn > 0)
			{
				fffn += ffn%10;
				ffn /= 10;
			}
			System.out.println(fffn);
		}
	}

}
