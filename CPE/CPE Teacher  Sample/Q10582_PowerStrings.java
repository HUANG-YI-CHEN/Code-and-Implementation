import java.util.Scanner;


public class Q10582_PowerStrings
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
			if(str.compareTo(".") == 0)
				break;
			for(int i=1; i<=str.length(); i++)
			{
				if(str.length()%i == 0)
				{
					boolean repeat = true;
					for(int j=0; j<str.length(); j++)
						if(str.charAt(j) != str.charAt(j%i))
						{
							repeat = false;
							break;
						}
					if(repeat)
					{
						System.out.println(str.length()/i);
						break;
					}
				}
			}
		}
	}

}
