import java.util.Scanner;


public class Q2008_09_TheNextHigherInteger 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		while(true)
		{
			String str = scn.nextLine();
			if(str.compareTo("-1") == 0)
				break;
			if(str.length() == 1)
				System.out.println(str);
			else
			{
				int[] dig = new int[10];
				for(int i=0; i<10; i++)
					dig[i] = 0;			
				for(int i=str.length()-1; i>0; i--)
				{
					dig[str.charAt(i)-'0']++;
					if(str.charAt(i-1) < str.charAt(i))
					{
						System.out.print(str.substring(0, i-1));
						for(int j=str.charAt(i-1)-'0'+1; ; j++)
							if(dig[j] > 0)
							{
								System.out.print(j);
								dig[j]--;
								dig[str.charAt(i-1)-'0']++;
								break;
							}
						for(int j=0; j<10; j++)
							for(int k=0; k<dig[j]; k++)
								System.out.print(j);
						System.out.println();
						break;
					}
					else if(i == 1)
					{
						System.out.println(str);
					}
				}
			}
		}
	}

}
