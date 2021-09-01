import java.util.Scanner;


public class Q10535_PrimeDistance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		while(scn.hasNext())
		{
			int L = scn.nextInt();
			int U = scn.nextInt();
			int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
			String strMax = "", strMin = "";
			int first = -1;
			for(int i=L; i<=U; i++)
			{
				if(isPrime(i))
				{
					if(first == -1)
					{
						first = i;
					}
					else
					{
						if(i-first > max)
						{
							max = i-first;
							strMax = first+","+i;
						}
						if(i-first < min)
						{
							min = i-first;
							strMin = first+","+i;
						}
						first = i;
					}
				}
			}
			if(strMax.compareTo("") == 0)
				System.out.println("There are no adjacent primes.");
			else
				System.out.println(strMin+" are closest, "+strMax+" are most distant.");
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
