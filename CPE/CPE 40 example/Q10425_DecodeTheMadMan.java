import java.util.Scanner;


public class Q10425_DecodeTheMadMan 
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
		String str = scn.nextLine().toUpperCase();
		String ans = "";
		for(int i=0; i<str.length(); i++)
		{
			boolean isFind = false;
			for(int j=0; j<key.length&&!isFind; j++)
				for(int k=2; k<key[j].length&&!isFind; k++)
					if(str.charAt(i) == key[j][k])
					{
						ans += key[j][k-2];
						isFind = true;
					}
			if(!isFind)
				ans += str.charAt(i);
		}
		System.out.println(ans.toLowerCase());
	}

}
