import java.util.Scanner;


public class Q10465_Necklace 
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
			double vt = (double)scn.nextInt();
			double v0 = (double)scn.nextInt();
			if(vt==0 && v0==0)
				break;
			double maxLen = 0;
			int nDiscs = 0;
			boolean multiSolutions = false;
			for(int i=1; i<=vt/v0; i++)
			{
				double v = vt / i;
				if(v > v0)
				{
					double D = 0.3*Math.sqrt(v-v0);
					if(Math.abs(D*i - maxLen) < 0.0000001)
					{
						multiSolutions = true;
					}
					else if(D*i > maxLen)
					{
						maxLen = D*i;
						nDiscs = i;
						multiSolutions = false;
					}
				}
			}
			if(multiSolutions)
				System.out.println("0");
			else
				System.out.println(nDiscs);
		}
	}
}
