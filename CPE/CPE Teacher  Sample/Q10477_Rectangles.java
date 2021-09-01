import java.util.Scanner;


public class Q10477_Rectangles 
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		for(int cs=1; cs<=N; cs++)
		{
			int M = scn.nextInt();
			int xmin = Integer.MIN_VALUE;
			int xmax = Integer.MAX_VALUE;
			int ymin = Integer.MIN_VALUE;
			int ymax = Integer.MAX_VALUE;
			for(int i=0; i<M; i++)
			{
				int x1 = scn.nextInt();
				int y1 = scn.nextInt();
				int x2 = scn.nextInt();
				int y2 = scn.nextInt();
				if(x1 > xmin)
					xmin = x1;
				if(y1 > ymin)
					ymin = y1;
				if(x2 < xmax)
					xmax = x2;
				if(y2 < ymax)
					ymax = y2;
			}
			int xlen = Math.max(xmax-xmin, 0);
			int ylen = Math.max(ymax-ymin, 0);
			System.out.println("Case "+cs+": "+(xlen*ylen));
		}
	}

}
