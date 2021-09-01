import java.util.Scanner;


public class Q24701_GleamingTheCubes 
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int n = 0;
		while((n=scn.nextInt())!=0)
		{
			int x = scn.nextInt();
			int y = scn.nextInt();
			int z = scn.nextInt();
			int len = scn.nextInt();
			int xs=x, xe=x+len, ys=y, ye=y+len, zs=z, ze=z+len;
			
			for(int i=1; i<n; i++)
			{
				x = scn.nextInt();
				y = scn.nextInt();
				z = scn.nextInt();
				len = scn.nextInt();
				if(x > xs)
					xs = x;
				if(x+len < xe)
					xe = x+len;
				if(y > ys)
					ys = y;
				if(y+len < ye)
					ye = y+len;
				if(z > zs)
					zs = z;
				if(z+len < ze)
					ze = z+len;
				
			}
			
			int xdd = Math.max(xe-xs, 0);
			int ydd = Math.max(ye-ys, 0);
			int zdd = Math.max(ze-zs, 0);
			System.out.println(xdd*ydd*zdd);
				
		}
	}

}
