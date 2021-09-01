import java.util.Scanner;


public class Q24681_Perfection 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int in = 0;
		
		System.out.println("PERFECTION OUTPUT");
		while((in=scn.nextInt()) != 0)
		{
			int sum = 0;
			for(int i=1; i<in; i++)
			{
				if(in%i == 0)
					sum += i;
			}
			String str = String.format("%5d", in);
			if(sum < in)
				System.out.println(str+"  DEFICIENT");
			else if(sum == in)
				System.out.println(str+"  PERFECT");
			else 
				System.out.println(str+"  ABUNDANT");
		}
		System.out.println("END OF OUTPUT");
	}

}
