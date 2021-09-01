import java.util.Scanner;


public class Q10424_Satellites 
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
			double s = (double)scn.nextInt();
			double a = (double)scn.nextInt();
			String unit = scn.next();
			if(unit.compareTo("min") == 0)
				a /= 60.0;
			double arc = 2*Math.PI*(6440+s)*a/360.0;
			if(a > 180.0)
				a -= 180.0;
			double chord = 2*(6440+s)*Math.sin((a/2)/360.0*2*Math.PI);
			System.out.printf("%.6f %.6f\n", arc, chord);
		}
	}

}
