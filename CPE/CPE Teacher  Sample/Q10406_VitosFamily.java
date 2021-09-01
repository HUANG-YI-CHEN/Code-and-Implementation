import java.util.Arrays;
import java.util.Scanner;

public class Q10406_VitosFamily 
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int nTesting = scn.nextInt();
		while(nTesting > 0)
		{
			int r = scn.nextInt();
			int[] s = new int[r];
			for(int i=0; i<r; i++)
				s[i] = scn.nextInt();
			Arrays.sort(s);
			int dis=0;
			for(int i=0; i<r; i++)
				dis += Math.abs(s[i]-s[r/2]);
			System.out.println(dis);
			nTesting--;
		}
	}
}
