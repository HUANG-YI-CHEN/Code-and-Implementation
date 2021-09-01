import java.util.Scanner;


public class Q2008_11_RadixConversion 
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
			long n = scn.nextLong();
			if(n == -1)
				break;
			int b = scn.nextInt();
			System.out.println(Long.toString(n, b).toUpperCase());
		}
	}

}
