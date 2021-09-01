import java.util.Scanner;


public class Q10401_FibonaccimalBase 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[] f = new int[41];
		f[0] = 0;
		f[1] = 1;
		for(int i=2; i<f.length; i++)
			f[i] = f[i-1] + f[i-2];
		//System.out.print(f[f.length-1]);
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		while(N>0)
		{
			int num = scn.nextInt();
			System.out.print(num+" = ");
			int idx = 0;
			while(f[idx]<=num)
				idx++;
			for(int i=idx-1; i>=2; i--)
			{
				if(num>=f[i])
				{
					System.out.print("1");
					num -= f[i];
				}
				else
					System.out.print("0");
			}
			System.out.println(" (fib)");
			N--;
		}
	}

}
