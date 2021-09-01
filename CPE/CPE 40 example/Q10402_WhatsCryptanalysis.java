import java.util.Scanner;

public class Q10402_WhatsCryptanalysis 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int cases = scn.nextInt();
		scn.nextLine();
		int[] cnt = new int[26];
		int[] let = new int[26];
		for(int i=0; i<26; i++)
		{
			cnt[i] = 0;
			let[i] = i;
		}
		while(cases>0)
		{
			String str = scn.nextLine();
			for(int i=0; i<str.length(); i++)
			{
				if(str.charAt(i)>='a' && str.charAt(i)<='z')
					cnt[str.charAt(i)-'a']++;
				else if(str.charAt(i)>='A' && str.charAt(i)<='Z')
					cnt[str.charAt(i)-'A']++;
			}
			cases--;
		}
		for(int i=0; i<26; i++)
		{
			for(int j=i+1; j<26; j++)
				if(cnt[i] < cnt[j] || (cnt[i] == cnt[j] && let[i] > let[j]))
				{
					int tmp=cnt[i];cnt[i]=cnt[j];cnt[j]=tmp;
					tmp=let[i];let[i]=let[j];let[j]=tmp;
				}
			if(cnt[i] == 0)
				break;
			char ch = (char)('A'+let[i]);
			System.out.println(ch+" "+cnt[i]);
		}
	}

}
