import java.util.Scanner;


public class Q10430_Soundex 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[] coding = new int[] {0, 1, 2, 3, 0, 1, 2, 0, 0, 2, 2, 4, 5, 5, 0, 1, 2, 6, 2, 3, 0, 1, 0, 2, 0, 2};
		Scanner scn = new Scanner(System.in);
		while(scn.hasNext())
		{
			String str = scn.next();
			String ans = "";
			int last = -1;
			for(int i=0; i<str.length(); i++)
			{
				if(coding[str.charAt(i)-'A'] == 0)
					last = -1;
				else if(coding[str.charAt(i)-'A'] != last)
				{
					ans += (coding[str.charAt(i)-'A']);
					last = coding[str.charAt(i)-'A'];
				}
			}
			System.out.println(ans);
		}
	}

}
