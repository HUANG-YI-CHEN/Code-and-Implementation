import java.util.Scanner;


public class Q10557_PrimeTime 
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
			int a = scn.nextInt();
			int b = scn.nextInt();
			double c = 0;
			for(int i=a; i<=b; i++)
				if(isPrime(i*i+i+41))
					c++;
			System.out.printf("%.2f\n", c*100/(double)(b-a+1));
		}
	}

	public static boolean isPrime(int k)
	{
		if(k<2)
			return false;
		for(int i=2; i*i<=k; i++)
			if(k%i==0)
				return false;
		
		return true;
	}
}
