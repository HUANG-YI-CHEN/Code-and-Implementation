import java.util.Scanner;


public class Q2008_15_FibonacciNumberSystem 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		long[] f = new long[50];
		f[0] = 1;
		f[1] = 2;
		for(int i=2; i<f.length; i++)
			f[i] = f[i-1] + f[i-2];
		//System.out.print(f[f.length-1]);
		Scanner scn = new Scanner(System.in);
		while(true)
		{
			String str = scn.nextLine();
			if(str.compareTo(".") == 0)
				break;
			long num = Long.parseLong(str);
			int idx = 0;
			while(f[idx]<=num)
				idx++;
			for(int i=idx-1; i>=0; i--)
			{
				if(num>=f[i])
				{
					System.out.print("1");
					num -= f[i];
				}
				else
					System.out.print("0");
			}
			System.out.println();
		}
	}

}
