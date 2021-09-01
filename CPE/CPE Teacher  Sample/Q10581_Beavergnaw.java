import java.util.Scanner;


public class Q10581_Beavergnaw 
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
			double D = scn.nextDouble();
			double V = scn.nextDouble();
			if(D==0 && V==0)
				break;
			double totalV = Math.PI*(D/2.0)*(D/2.0)*D;
			double remainV = totalV - V;
			System.out.printf("%.3f\n", remainV);
			double d = Math.pow(6.0*remainV/Math.PI - D*D*D/2.0, 1.0/3.0);
			System.out.printf("%.3f\n", d);
		}
	}

}
