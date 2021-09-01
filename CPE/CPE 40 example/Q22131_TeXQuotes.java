import java.util.Scanner;


public class Q22131_TeXQuotes 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int first = 0;
		while(scn.hasNext())
		{
			String str = scn.nextLine();
			for(int i=0; i<str.length(); i++)
			{
				if(str.charAt(i) == '"')
				{
					if(first == 0)
						System.out.print("``");
					else
						System.out.print("''");
					first = 1-first;
				}
				else
					System.out.print(str.charAt(i));
			}
			System.out.println();
		}
	}

}
