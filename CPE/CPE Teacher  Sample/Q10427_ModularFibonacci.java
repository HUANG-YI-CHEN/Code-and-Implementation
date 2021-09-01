import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;


public class Q10427_ModularFibonacci 
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		/*for(int i=0; i<100; i++)
		{
			int[][] m = matrix(new int[][]{{1, 1}, {1, 0}}, i, 10);
			System.out.println(i+"\t"+m[0][0]+"\t"+m[0][1]+"\t"+m[1][0]+"\t"+m[1][1]);
		}*/
		Scanner scn = new Scanner(System.in);
		while(scn.hasNext())
		{
			int n = scn.nextInt();
			int m = scn.nextInt();
			int[][] M = matrix(new int[][]{{1, 1}, {1, 0}}, n, (int)Math.pow(2, m));
			System.out.println(M[0][1]);
			
			/*BigInteger Mn = FIB(n).mod(new BigInteger((int)Math.pow(2, m)+""));
			System.out.println(Mn);*/
			/*if(n <= 1)
				System.out.println(n % (long)Math.pow(2, m));
			else
			{
				long[] f = new long[] {0, 1};
				for(long i=2; i<=n; i++)
				{
					long fn = f[0]+f[1];
					f[0] = f[1];
					f[1] = fn;
				}
				System.out.println(f[1] % (long)Math.pow(2, m));
			}*/
		}
	}
	public static BigInteger FIB(long n)
	{
		if (n <= 1)
			return new BigInteger(n+""); 
		if (n == 2) 
			return new BigInteger("1"); 
		else
		{ 
			long i = n/2; 
			BigInteger f1 = FIB(i+1); 
			BigInteger f2 = FIB(i); 

			if (n % 2 == 0)
				return f2.multiply(f1.shiftLeft(1).subtract(f2)); 
			else 
				return f1.multiply(f1).add(f2.multiply(f2));
		}
	}
	public static int[][] matrix(int[][] M, int n, int m)
	{
		if(n == 0)
			return new int[][] {{1, 0}, {0, 1}};
		else if(n%2 == 0)
		{
			int[][] Mk = matrix(M, n/2, m);
			int[][] Mn = new int[2][2];
			for(int i=0; i<2; i++)
				for(int j=0; j<2; j++)
				{					
					Mn[i][j] = 0;
					for(int r=0; r<2; r++)
						Mn[i][j] += Mk[i][r]*Mk[r][j];
					Mn[i][j] %= m;
				}
			return Mn;
		}
		else
		{
			int[][] M2k = matrix(M, n-1, m);
			int[][] Mn = new int[2][2];
			for(int i=0; i<2; i++)
				for(int j=0; j<2; j++)
				{					
					Mn[i][j] = 0;
					for(int r=0; r<2; r++)
						Mn[i][j] += M[i][r]*M2k[r][j];
					Mn[i][j] %= m;
				}
			return Mn;
		}
	}
}
