import java.util.ArrayList;
import java.util.Scanner;
public class Q10001_Table 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		/*²£¥Í´ú¸ÕÀÉ*/
		char c1=192, c2=193, c3=217, c4=195, c5=197, c6=180, c7=218, c8=194, c9=191, cv=179, ch=196;
		//System.out.println(""+c7+ch+c8+ch+c9);
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		ArrayList<String> in = new ArrayList<String>();
		ArrayList<String[]> word = new ArrayList<String[]>();
		String str = scn.nextLine();
		in.add(str);
		int nCol = 1;
		for(int i=1; i<str.length(); i++)
			if(str.charAt(i) == c8)
				nCol++;
		word.add(new String[nCol]);
		
		while(true)
		{
			str = scn.nextLine();
			if(str.charAt(0) == c4)
			{
				in.add(str);
				word.add(new String[nCol]);				
			}
			else if(str.charAt(0) == c1)
			{
				in.add(str);
				word.add(new String[nCol]);
				break;
			}
			else
			{
				in.add(str);
				String[] tmp = new String[nCol];
				int idx = 0;
				for(int i=0; i<str.length(); i++)
					if(str.charAt(i)!=cv && str.charAt(i)!=' ')
					{
						int sidx = i;
						int eidx = str.indexOf(cv, sidx);
						while(str.charAt(eidx)==cv || str.charAt(eidx)==' ')
							eidx--;
						tmp[idx] = str.substring(sidx, eidx+1);
						i = str.indexOf(cv, sidx);
						idx++;
					}
				word.add(tmp);
			}
		}
		int[] len = new int[nCol];
		for(int i=0; i<nCol; i++)
			len[i] = 0;
		for(int i=0; i<in.size(); i++)
		{
			if(in.get(i).charAt(0) == cv)
			{
				for(int j=0; j<word.get(i).length; j++)
					if(word.get(i)[j].length() > len[j])
						len[j] = word.get(i)[j].length();
			}
		}
		for(int i=0; i<in.size(); i++)
		{
			if(in.get(i).charAt(0) == c7)
			{
				System.out.print(c7);
				for(int k=0; k<len[0]+2; k++)
					System.out.print(ch);
				for(int j=1; j<nCol; j++)
				{
					System.out.print(c8);
					for(int k=0; k<len[j]+2; k++)
						System.out.print(ch);
				}
				System.out.println(c9);
			}
			else if(in.get(i).charAt(0) == c4)
			{
				System.out.print(c4);
				for(int k=0; k<len[0]+2; k++)
					System.out.print(ch);
				for(int j=1; j<nCol; j++)
				{
					System.out.print(c5);
					for(int k=0; k<len[j]+2; k++)
						System.out.print(ch);
				}
				System.out.println(c6);
			}
			else if(in.get(i).charAt(0) == c1)
			{
				System.out.print(c1);
				for(int k=0; k<len[0]+2; k++)
					System.out.print(ch);
				for(int j=1; j<nCol; j++)
				{
					System.out.print(c2);
					for(int k=0; k<len[j]+2; k++)
						System.out.print(ch);
				}
				System.out.print(c3);
			}
			else
			{
				System.out.print(cv+" "+word.get(i)[0]);
				for(int k=word.get(i)[0].length(); k<len[0]+1; k++)
					System.out.print(" ");
				for(int j=1; j<nCol; j++)
				{
					System.out.print(cv+" "+word.get(i)[j]);
					for(int k=word.get(i)[j].length(); k<len[j]+1; k++)
						System.out.print(" ");					
				}
				System.out.println(cv);				
			}
		}
	}

}
