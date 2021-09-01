import java.util.Scanner;


public class Q22351_QuirksomeSquares 
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
			int n = scn.nextInt();
			int divide = (int)Math.pow(10, n/2);
			for(int i=0; i<Math.pow(10, n/2); i++)
			{
				int square = i*i;
				int a = square/divide;
				int b = square%divide;
				if(a+b == i)
				{
					if(n == 2)
						System.out.printf("%02d\n", square);
					else if(n == 4)
						System.out.printf("%04d\n", square);
					else if(n == 6)
						System.out.printf("%06d\n", square);
					else if(n == 8)
						System.out.printf("%08d\n", square);
				}
			}
		}
	}

}
