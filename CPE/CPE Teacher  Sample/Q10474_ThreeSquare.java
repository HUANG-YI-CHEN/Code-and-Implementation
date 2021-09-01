import java.util.Scanner;


public class Q10474_ThreeSquare 
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int cs = scn.nextInt();
		while(cs-- > 0)
		{
			int K = scn.nextInt();
			boolean find = false;
			for(int a=0; a<=Math.sqrt(K)&&!find; a++)
				for(int b=0; b<=Math.sqrt(K-a*a)&&!find; b++)
					for(int c=0; c<=Math.sqrt(K-a*a-b*b)&&!find; c++)
						if(a*a+b*b+c*c == K)
						{
							System.out.println(a+" "+b+" "+c);
							find = true;
						}
			if(!find)
				System.out.println("-1");
		}
	}

}
