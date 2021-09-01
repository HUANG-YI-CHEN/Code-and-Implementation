import java.util.Scanner;


public class Q11009_AllInAll
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
			String s = scn.next();
			String t = scn.next();
			int j = 0;
			for(int i=0; i<s.length(); i++)
			{
				int idx = t.indexOf(s.charAt(i), j);
				if(idx == -1)
				{
					System.out.println("No");
					break;
				}
				else if(i==s.length()-1)
				{
					System.out.println("Yes");
					break;					
				}
				j = idx+1;
			}
		}
	}

}
