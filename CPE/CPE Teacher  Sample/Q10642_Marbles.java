import java.util.Random;
import java.util.Scanner;


public class Q10642_Marbles 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		//dataGen();
		Scanner scn = new Scanner(System.in);
		while(true)
		{
			int sum = scn.nextInt();
			if(sum == 0)
				break;
			int c1 = scn.nextInt();
			int n1 = scn.nextInt();
			int c2 = scn.nextInt();
			int n2 = scn.nextInt();
			if((double)n1/c1 > (double)n2/c2)
			{
				for(int i=sum/n1; i>=0; i--)
				{
					if((sum-i*n1)%n2 == 0)
					{
						System.out.println(i+" "+(sum-i*n1)/n2);						
						break;
					}
					else if(i == 0)
						System.out.println("failed");						
				}
			}
			else
			{
				for(int i=sum/n2; i>=0; i--)
				{
					if((sum-i*n2)%n1 == 0)
					{
						System.out.println((sum-i*n2)/n1+" "+i);						
						break;
					}
					else if(i == 0)
						System.out.println("failed");						
				}
			}
		}
	}
	
	public static void dataGen()
	{
		Random rand = new Random();
		for(int i=0; i<10; i++)
		{
			System.out.println(Math.abs(rand.nextLong())%100+1);
			int c1 = Math.abs(rand.nextInt()%10)+1;
			int c2 = Math.abs(rand.nextInt()%10)+1;
			System.out.println(c1+" "+(int)(c1*(rand.nextDouble()+1)));
			System.out.println(c2+" "+(int)(c2*(rand.nextDouble()+1)));
		}
		for(int i=0; i<10; i++)
		{
			System.out.println(Math.abs(rand.nextLong())%2000000000+1);
			int c1 = Math.abs(rand.nextInt()%10000)+1;
			int c2 = Math.abs(rand.nextInt()%10000)+1;
			System.out.println(c1+" "+(int)(c1*(rand.nextDouble()+1)));
			System.out.println(c2+" "+(int)(c2*(rand.nextDouble()+1)));
		}
		System.out.println("0");
	}

}
