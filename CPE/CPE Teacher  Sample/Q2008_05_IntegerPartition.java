import java.util.Scanner;


public class Q2008_05_IntegerPartition 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int cs = 1;
		while(scn.hasNext())
		{
			int n = scn.nextInt();
			System.out.println("case "+cs+":");
			partition(n, n, "");
			System.out.println();
			cs++;
		}
	}
	
	public static void partition(int n, int max, String str)
	{
		if(n == 0)
			System.out.println(str.trim());
		else
			for(int i=Math.min(n, max); i>=1; i--)
				partition(n-i, i, str+i+" ");
	}
}
