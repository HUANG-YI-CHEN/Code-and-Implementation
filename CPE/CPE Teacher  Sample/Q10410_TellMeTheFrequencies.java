import java.util.Scanner;


public class Q10410_TellMeTheFrequencies 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int[] cnt = new int[256];
		int[] let = new int[256];
		for(int i=0; i<256; i++)
		{
			cnt[i] = 0;
			let[i] = i;
		}		
		String str = scn.nextLine();
		for(int i=0; i<str.length(); i++)
			cnt[str.charAt(i)]++;
		for(int i=0; i<256; i++)
		{
			for(int j=i+1; j<256; j++)
				if(cnt[i] > cnt[j] || (cnt[i] == cnt[j] && let[i] < let[j]))
				{
					int tmp=cnt[i];cnt[i]=cnt[j];cnt[j]=tmp;
					tmp=let[i];let[i]=let[j];let[j]=tmp;
				}
			if(cnt[i] == 0)
				continue;
			System.out.println(let[i]+" "+cnt[i]);
		}
		while(scn.hasNext())
		{
			System.out.println();
			for(int i=0; i<256; i++)
			{
				cnt[i] = 0;
				let[i] = i;
			}		
			str = scn.nextLine();
			for(int i=0; i<str.length(); i++)
				cnt[str.charAt(i)]++;
			for(int i=0; i<256; i++)
			{
				for(int j=i+1; j<256; j++)
					if(cnt[i] > cnt[j] || (cnt[i] == cnt[j] && let[i] < let[j]))
					{
						int tmp=cnt[i];cnt[i]=cnt[j];cnt[j]=tmp;
						tmp=let[i];let[i]=let[j];let[j]=tmp;
					}
				if(cnt[i] == 0)
					continue;
				System.out.println(let[i]+" "+cnt[i]);
			}
		}

	}

}
