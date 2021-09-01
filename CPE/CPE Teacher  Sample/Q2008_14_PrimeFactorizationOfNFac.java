import java.util.Scanner;


public class Q2008_14_PrimeFactorizationOfNFac 
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
			String str = scn.nextLine();
			if(str.compareTo(".") == 0)
				break;
			int n = Integer.parseInt(str);
			int[] nPrimes = new int[n+1];
			for(int i=0; i<n+1; i++)
				nPrimes[i] = 0;
			for(int i=n; i>=2; i--)
			{
				int tmp = i;
				for(int j=2; j*j<=tmp; j++)
				{
					while(tmp%j == 0)
					{
						nPrimes[j]++;
						tmp /= j;
					}
				}
				if(tmp > 1)
					nPrimes[tmp]++;				
			}
			String ans = "";
			for(int i=2; i<n+1; i++)
			{
				if(nPrimes[i] > 0)
					ans += (nPrimes[i]+" ");
			}
			System.out.println(n+"! = ("+ans.trim()+")");
		}
	}

}
