import java.util.Scanner;
import java.util.TreeMap;


public class Q2008_08_PrimeFactorization
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
			long n = scn.nextLong();
			if(n == -1)
				break;
			TreeMap<Long, Integer> primes = new TreeMap<Long, Integer>();			
			for(long i=2; i*i<=n; i++)
			{
				int c = 0;
				while(n%i == 0)
				{
					n /= i;
					c++;
				}
				if(c != 0)
					primes.put(i, c);
			}
			if(n > 1)
				primes.put(n, 1);
			int nDiv = 1;
			long sum = 1;
			for(long p:primes.keySet())
			{
				System.out.print("("+p+","+primes.get(p)+")");
				nDiv *= (primes.get(p)+1);
				long s = 0;
				for(int j=0; j<=primes.get(p); j++)
					s += Math.pow(p,j);
				sum *= s;
			}
			System.out.println("\n"+nDiv+"\n"+sum+"\n===");
		}
	}

}
