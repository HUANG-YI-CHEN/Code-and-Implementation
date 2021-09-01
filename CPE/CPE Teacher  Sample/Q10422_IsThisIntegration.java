import java.util.Scanner;


public class Q10422_IsThisIntegration 
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
			double a = scn.nextDouble();
			double A1B4C4 = a*a;
			double A1B3C2 = Math.PI*a*a/4;
			double A1B2C1 = 2*(Math.PI*a*a/6)-a*a*Math.sqrt(3)/4;
			double B1C2 = A1B4C4 - A1B3C2;
			double B1C1 = A1B3C2 - A1B2C1;
			double C1 = B1C2 - B1C1;
			double B1 = B1C1 - C1;
			double A1 = A1B2C1 - 2*B1 - C1;
			System.out.printf("%.3f %.3f %.3f\n", A1, B1*4, C1*4);
		}
	}

}
