import java.util.Scanner;


public class Q24691_KindergartenCountingGame 
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
			String str = scn.nextLine();
			int sum = 0;
			for(int i=0; i<str.length(); i++)
			{
				if(isL(str.charAt(i)))
				{
					for(int j=i+1; j<str.length(); j++)
						if(!isL(str.charAt(j)) || j==str.length()-1)
						{
							sum++;
							i = j;
							break;
						}
				}
			}
			System.out.println(sum);
		}
	}
	
	public static boolean isL(char c)
	{
		if(c>='A'&&c<='Z')
			return true;
		if(c>='a'&&c<='z')
			return true;
		return false;
	}

}
