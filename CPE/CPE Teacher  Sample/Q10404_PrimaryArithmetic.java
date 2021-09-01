import java.util.Scanner;

public class Q10404_PrimaryArithmetic 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int i1, i2;
		while((i1=scn.nextInt())!=0 && (i2=scn.nextInt())!=0)
		{
			int n=0, c=0;
			while(i1>0 || i2>0)
			{
				if((i1%10)+(i2%10)+c >= 10)
				{
					n++;
					c=1;
				}
				else
					c=0;
				i1 /= 10;
				i2 /= 10;
			}
			if(n == 0)
				System.out.println("No carry operation.");
			else if(n == 1)
				System.out.println(n+" carry operation.");			
			else
				System.out.println(n+" carry operations.");			
		}
	}
}
