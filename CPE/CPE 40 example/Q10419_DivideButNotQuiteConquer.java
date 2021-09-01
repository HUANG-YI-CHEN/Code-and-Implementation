import java.util.Scanner;


public class Q10419_DivideButNotQuiteConquer 
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		while(scn.hasNext())
		{
			int n = scn.nextInt();
			int m = scn.nextInt();
			if(m <= 1)
				System.out.println("Boring!");
			else
			{
				String str = n+"";
				while(n>1)
				{
					if(n%m==0)
					{
						n/=m;
						str += " "+n;
					}
					else
						break;
				}
				if(n == 1)
					System.out.println(str);
				else
					System.out.println("Boring!");
			}
		}
	}

}
