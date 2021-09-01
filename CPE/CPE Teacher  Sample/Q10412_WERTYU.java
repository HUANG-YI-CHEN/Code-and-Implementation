import java.util.Scanner;


public class Q10412_WERTYU 
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		char[][] key = new char[][]
		{{'`', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '-', '='},
		 {'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', '[', ']', '\\'},
		 {'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', ';', '\''},
		 {'Z', 'X', 'C', 'V', 'B', 'N', 'M', ',', '.', '/'}};
		Scanner scn = new Scanner(System.in);
		while(scn.hasNext())
		{
			String str = scn.nextLine();
			for(int i=0; i<str.length(); i++)
			{
				boolean isFind = false;
				for(int j=0; j<key.length&&!isFind; j++)
					for(int k=1; k<key[j].length&&!isFind; k++)
						if(str.charAt(i) == key[j][k])
						{
							System.out.print(key[j][k-1]);
							isFind = true;
						}
				if(!isFind)
					System.out.print(str.charAt(i));
			}
			System.out.println();
		}
	}

}
