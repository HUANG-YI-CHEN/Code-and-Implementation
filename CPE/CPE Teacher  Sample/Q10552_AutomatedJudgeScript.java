import java.util.Scanner;


public class Q10552_AutomatedJudgeScript
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int run = 1;
		while(true)
		{
			int n = scn.nextInt();			
			if(n == 0)
				break;
			scn.nextLine();
			String[] sol = new String[n];
			for(int i=0; i<n; i++)
				sol[i] = scn.nextLine();
			int m = scn.nextInt();
			scn.nextLine();
			String[] out = new String[m];
			for(int i=0; i<m; i++)
				out[i] = scn.nextLine();			
			System.out.print("Run #"+run+": ");
			if(accepted(sol, out))
				System.out.println("Accepted");
			else if(presentationError2(sol, out))
				System.out.println("Presentation Error");
			else
				System.out.println("Wrong Answer");
			run++;
		}
	}
	public static boolean accepted(String[] s1, String[] s2)
	{
		if(s1.length != s2.length)
			return false;
		for(int i=0; i<s1.length; i++)
			if(s1[i].compareTo(s2[i]) != 0)
				return false;
		return true;
	}
	public static boolean presentationError2(String[] s1, String[] s2)
	{
		if(s1.length != s2.length)
			return false;
		String[] ns1 = new String[s1.length];
		for(int i=0; i<s1.length; i++)
		{
			ns1[i] = "";
			for(int j=0; j<s1[i].length(); j++)
				if(s1[i].charAt(j)>='0' && s1[i].charAt(j)<='9')
					ns1[i] += s1[i].charAt(j);
		}
		String[] ns2 = new String[s2.length];
		for(int i=0; i<s2.length; i++)
		{
			ns2[i] = "";
			for(int j=0; j<s2[i].length(); j++)
				if(s2[i].charAt(j)>='0' && s2[i].charAt(j)<='9')
					ns2[i] += s2[i].charAt(j);
		}
		return accepted(ns1, ns2);
	}
	public static boolean presentationError(String[] s1, String[] s2)
	{
		if(s1.length != s2.length)
			return false;
		String[] ns1 = new String[s1.length];
		for(int i=0; i<s1.length; i++)
			ns1[i] = "";
		String[] ns2 = new String[s2.length];
		for(int i=0; i<s2.length; i++)
			ns2[i] = "";
		//去空白
		for(int i=0; i<s1.length; i++)
			for(int j=0; j<s1[i].length(); j++)
			{
				if(s1[i].charAt(j) != ' ')
					ns1[i] += s1[i].charAt(j);
				else if(s1[i].charAt(j) == ' ' && j+1<s1[i].length() && s1[i].charAt(j+1) != ' ')
					ns1[i] += s1[i].charAt(j);
			}
		for(int i=0; i<s2.length; i++)
			for(int j=0; j<s2[i].length(); j++)
			{
				if(s2[i].charAt(j) != ' ')
					ns2[i] += s2[i].charAt(j);
				else if(s2[i].charAt(j) == ' ' && j+1<s2[i].length() && s2[i].charAt(j+1) != ' ')
					ns2[i] += s2[i].charAt(j);
			}
		//連接連續兩個數字
		for(int i=0; i<ns1.length; i++)
		{
			String[] tmp = ns1[i].split(" ");
			ns1[i] = tmp[0];
			for(int j=1; j<tmp.length; j++)
			{
				if(!isNumber(tmp[j-1]) || !isNumber(tmp[j]))
					ns1[i] += (" "+tmp[j]);
				else
					ns1[i] += tmp[j];
			}
		}
		for(int i=0; i<ns2.length; i++)
		{
			String[] tmp = ns2[i].split(" ");
			ns2[i] = tmp[0];
			for(int j=1; j<tmp.length; j++)
			{
				if(!isNumber(tmp[j-1]) || !isNumber(tmp[j]))
					ns2[i] += (" "+tmp[j]);
				else
					ns2[i] += tmp[j];
			}
		}
		int stringError = 0;
		for(int i=0; i<ns1.length; i++)
		{
			String[] tmp1 = ns1[i].split(" ");
			String[] tmp2 = ns2[i].split(" ");
			if(tmp1.length != tmp2.length)
				return false;
			for(int j=0; j<tmp1.length; j++)
			{
				if(isNumber(tmp1[j]) && !isNumber(tmp2[j]))
					return false;
				else if(!isNumber(tmp1[j]) && isNumber(tmp2[j]))
					return false;				
				else if(isNumber(tmp1[j]) && isNumber(tmp2[j]) && tmp1[j].compareTo(tmp2[j])!=0)
					return false;
				else if(!isNumber(tmp1[j]) && !isNumber(tmp2[j]) && tmp1[j].compareTo(tmp2[j])!=0)
				{
					stringError++;
					if(stringError > 1)
						return false;				
				}	
			}
		}
		/*for(int i=0; i<s1.length; i++)
			System.out.println(s1[i]+"\n"+ns1[i]);
		for(int i=0; i<s2.length; i++)
			System.out.println(s2[i]+"\n"+ns2[i]);
		*/
		return true;
	}
	public static boolean isNumber(String s)
	{
		try
		{
			int i = Integer.parseInt(s);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
}
