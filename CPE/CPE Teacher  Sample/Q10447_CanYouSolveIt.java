import java.util.Scanner;


public class Q10447_CanYouSolveIt 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int cs = scn.nextInt();
		for(int n=1; n<=cs; n++)
		{
			int x1 = scn.nextInt();
			int y1 = scn.nextInt();
			int n1 = 0;
			if(x1+y1 > 0)
				n1 = (1+x1+y1)*(x1+y1)/2 + x1;
			int x2 = scn.nextInt();
			int y2 = scn.nextInt();
			int n2 = 0;
			if(x2+y2 > 0)
				n2 = (1+x2+y2)*(x2+y2)/2 + x2;
			System.out.println("Case "+n+": "+(n2-n1));
		}
	}

}
