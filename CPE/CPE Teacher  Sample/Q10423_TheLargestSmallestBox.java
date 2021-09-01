import java.util.Scanner;


public class Q10423_TheLargestSmallestBox 
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
			double l = scn.nextDouble();
			double w = scn.nextDouble();
			double minx = 0;
			double maxx = Math.min(l, w)/2;
			double maxVol = 0;
			while(maxx-minx > 0.0001)
			{
				double x1 = minx;
				double x5 = maxx;
				double x3 = (x1+x5)/2;
				double x2 = (x1+x3)/2;
				double x4 = (x3+x5)/2;
				double v1 = vol(l, w, x1);
				double v2 = vol(l, w, x2);
				double v3 = vol(l, w, x3);
				double v4 = vol(l, w, x4);
				double v5 = vol(l, w, x5);
				if(v1 == max(v1,v2,v3,v4,v5))
				{	maxx = x3;	minx = x1;  }
				else if(v2 == max(v1,v2,v3,v4,v5))
				{	maxx = x3;	minx = x1;  }
				else if(v3 == max(v1,v2,v3,v4,v5))
				{	maxx = x4;	minx = x2;  }
				else if(v4 == max(v1,v2,v3,v4,v5))
				{	maxx = x5;	minx = x3;  }
				else if(v5 == max(v1,v2,v3,v4,v5))
				{	maxx = x5;	minx = x3;  }
			}
			System.out.printf("%.3f %.3f %.3f\n", (maxx+minx)/2, 0.0, Math.min(l, w)/2);
		}
	}
	public static double vol(double l, double w, double x)
	{
		return (l-2*x)*(w-2*x)*x;
	}
	public static double max(double v1, double v2, double v3, double v4, double v5)
	{
		return Math.max(v1, Math.max(v2, Math.max(v3, Math.max(v4, v5))));
	}
}
