import java.util.ArrayList;
import java.util.Scanner;

public class Q21914_RotatingSentences 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		ArrayList<String> in = new ArrayList<String>();
		int maxLen = 0;
		while(scn.hasNext())
		{
			String str = scn.nextLine();
			in.add(str);
			if(str.length() > maxLen)
				maxLen = str.length();
		}
		for(int i=0; i<maxLen; i++)
		{
			for(int j=in.size()-1; j>=0; j--)
			{
				if(i < in.get(j).length())
					System.out.print(in.get(j).charAt(i));
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}

}
