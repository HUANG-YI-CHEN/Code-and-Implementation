import java.util.Scanner;


public class Q10533_TheTrip
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
			int n = scn.nextInt();
			if(n == 0)
				break;
			double[] m = new double[n];
			double avg = 0;
			for(int i=0; i<n; i++)
			{
				m[i] = scn.nextDouble();
				avg += m[i];
			}
			avg /= (double)n;
			double s1=0, s2=0;
			for(int i=0; i<n; i++)
			{
				if(m[i] <= avg)
					s1 += ((int)((avg-m[i])*100))/100.0;
				else
					s2 += ((int)((m[i]-avg)*100))/100.0;
			}
			//System.out.println(avg);
			System.out.printf("$%.2f\n", Math.max(s1, s2));
		}
	}

}
