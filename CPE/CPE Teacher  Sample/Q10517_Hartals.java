import java.util.Scanner;


public class Q10517_Hartals 
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int cs = scn.nextInt();
		while(cs > 0)
		{
			int[] day = new int[scn.nextInt()];
			for(int i=0; i<day.length; i++)
				day[i] = 0;
			int n = scn.nextInt();
			for(int i=0; i<n; i++)
			{
				int h = scn.nextInt();
				for(int j=h-1; j<day.length; j+=h)
					day[j] ++;				
			}
			int sum = 0;
			for(int i=0; i<day.length; i++)
				if(i%7!=6 && i%7!=5 && day[i]!=0 )
					sum++;
			System.out.println(sum);
			cs--;
		}
	}

}
