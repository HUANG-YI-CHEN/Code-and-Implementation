import java.util.Scanner;


public class Q2008_33_UNIXLikeCommandRecho 
{

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		while(true)
		{
			String str = scn.nextLine();
			if(str.compareTo(".") == 0)
				break;
			String[] cmd = str.split(" ");
			//if(cmd.length == 1 && cmd[0].compareTo("recho") == 0)
			//{
				//System.out.println();
			//}
			if(cmd.length >= 1 && cmd[0].compareTo("recho") == 0)
			{
				int a = 0;
				int c = 0;
				String errorCmd = "";
				boolean[] print = new boolean[cmd.length];
				for(int i=1; i<cmd.length; i++)
				{
					print[i] = false;
					if(cmd[i].compareTo("-a") == 0)
						a++;
					else if(cmd[i].compareTo("-c") == 0)
						c++;
					else if(cmd[i].startsWith("¡V"))
					{
						errorCmd = cmd[i];
						break;
					}
					else
						print[i] = true;
				}
				//if(errorCmd.length() > 2)
					//print[10000] = true;
				if(errorCmd.compareTo("") != 0)
				{
					System.out.println("Illegal switches on \""+errorCmd+"\"");
				}
				else
				{
					String ans = "";
					if(a % 2 == 0)
					{
						for(int i=1; i<cmd.length; i++)
							if(print[i])
							{
								if(c % 2 == 0)
									ans += cmd[i]+" ";
								else
									ans += reverse(cmd[i])+" ";
							}
					}
					else
					{
						for(int i=cmd.length-1; i>=1; i--)
							if(print[i])
							{
								if(c % 2 == 0)
									ans += cmd[i]+" ";
								else
									ans += reverse(cmd[i])+" ";
							}
					}
					System.out.println(ans.trim());
				}
			}
			else
			{
				System.out.println("Command error !!");
			}
		}
	}
	
	public static String reverse(String s)
	{
		String ret = "";
		for(int i=s.length()-1; i>=0; i--)
			ret += s.charAt(i);
		return ret;
	}
}
