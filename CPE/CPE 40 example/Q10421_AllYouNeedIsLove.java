import java.util.Scanner;


public class Q10421_AllYouNeedIsLove 
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int nTest = scn.nextInt();
		scn.nextLine();
		for(int nn=1; nn<=nTest ; nn++)
		{
			String s1 = scn.nextLine();
			String s2 = scn.nextLine();
			long n1 = 0;
			long n2 = 0;
			for(int i=0; i<s1.length(); i++)
				if(s1.charAt(i)=='1')
					n1+=Math.pow(2, s1.length()-1-i);
			for(int i=0; i<s2.length(); i++)
				if(s2.charAt(i)=='1')
					n2+=Math.pow(2, s2.length()-1-i);
			long gcd = gcd(n1,n2);
			if(gcd ==1)
				System.out.println("Pair #"+nn+": Love is not all you need!");
			else
				System.out.println("Pair #"+nn+": All you need is love!");
		}
	}
	
	public static long gcd(long n1, long n2)
	{
		if(n2 == 0)
			return n1;
		return gcd(n2, n1%n2);
	}
}
