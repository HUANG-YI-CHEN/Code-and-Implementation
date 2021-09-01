import java.util.Scanner;


public class Q10502_ProductOfDigits
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int cs = scn.nextInt();
		while(cs > 0)
		{
			int n = scn.nextInt();
			if(n == 1)
				System.out.println("1");
			else
			{
				String ans = "";
				int c = 9;
				while(n>1)
				{
					if(n%c == 0)
					{
						ans = (c+"")+ans;
						n/=c;
					}
					else
					{
						c--;
						if(c == 1)
							break;
					}
				}
				if(c==1 && n>1)
					System.out.println("-1");
				else
					System.out.println(ans);
			}
			cs--;
		}
	}

}
