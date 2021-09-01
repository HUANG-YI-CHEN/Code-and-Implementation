import java.util.Scanner;


public class Q10544_BirthdayCake
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
			int N = scn.nextInt();
			if(N == 0)
				break;
			int[] X = new int[2*N];
			int[] Y = new int[2*N];
			for(int i=0; i<2*N; i++)
			{
				X[i] = scn.nextInt();
				Y[i] = scn.nextInt();
			}
			
			boolean find = false;
			for(int A=-500; A<=500; A++)
			{
				for(int B=-500; B<=500; B++)
				{
					int sl=0, ss=0;
					for(int i=0; i<2*N; i++)
					{
						if(B*Y[i] > -1*A*X[i])
							sl++;
						else if(B*Y[i] < -1*A*X[i])
							ss++;
					}
					if(sl==N && ss==N)
					{
						System.out.println(A+" "+B);
						find = true;
						break;
					}
				}
				if(find)
					break;
			}
		}
	}

}
