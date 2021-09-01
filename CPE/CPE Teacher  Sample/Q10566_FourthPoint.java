import java.util.Scanner;


public class Q10566_FourthPoint 
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
			double x1 = scn.nextDouble();
			double y1 = scn.nextDouble();
			double x2 = scn.nextDouble();
			double y2 = scn.nextDouble();
			double x3 = scn.nextDouble();
			double y3 = scn.nextDouble();
			double x4 = scn.nextDouble();
			double y4 = scn.nextDouble();
			if(x1==x3 && y1==y3)
			{
				double xt=x1; x1=x2; x2=xt;
				double yt=y1; y1=y2; y2=yt;
			}
			else if(x1==x4 && y1==y4)
			{
				double xt=x1; x1=x2; x2=xt;
				double yt=y1; y1=y2; y2=yt;
				xt=x3; x3=x4; x4=xt;
				yt=y3; y3=y4; y4=yt;
			}
			else if(x2==x4 && y2==y4)
			{
				double xt=x3; x3=x4; x4=xt;
				double yt=y3; y3=y4; y4=yt;
			}
			double x = x1 + x4 - x3;
			double y = y1 + y4 - y3;
			System.out.printf("%.3f %.3f\n", x, y);
		}
	}

}
