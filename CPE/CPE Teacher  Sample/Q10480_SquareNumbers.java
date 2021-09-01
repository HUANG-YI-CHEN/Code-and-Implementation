import java.util.Scanner;


public class Q10480_SquareNumbers
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
			int a = scn.nextInt();
			int b = scn.nextInt();
			if(a==0 && b==0)
				break;
			int s = (int)Math.sqrt(a);
			int e = (int)Math.sqrt(b);
			if(s*s == a)
				System.out.println(e-s+1);
			else
				System.out.println(e-s);
		}
	}

}
