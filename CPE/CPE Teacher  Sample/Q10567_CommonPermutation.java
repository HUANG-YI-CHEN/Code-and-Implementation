import java.util.Scanner;


public class Q10567_CommonPermutation 
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
			String a = scn.nextLine();
			String b = scn.nextLine();
			int[] cnta = new int[26];
			int[] cntb = new int[26];
			for(int i=0; i<26; i++)
			{
				cnta[i] = 0;
				cntb[i] = 0;
			}
			for(int i=0; i<a.length(); i++)
				cnta[a.charAt(i)-'a']++;
			for(int i=0; i<b.length(); i++)
				cntb[b.charAt(i)-'a']++;
			for(int i=0; i<26; i++)
			{
				int cnt = Math.min(cnta[i], cntb[i]);
				for(int j=0; j<cnt; j++)
				{
					char ch = (char)(i+'a');
					System.out.print(ch);
				}
			}
			System.out.println();
		}
	}

}
