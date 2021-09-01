import java.util.Scanner;


public class Q11011_Base64Decoding 
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String str = "";
		boolean eof = false;
		while(!eof)
		{
			do
			{
				str += scn.nextLine();
			}while(!str.contains("#"));
			do
			{
				if(str.compareTo("#") == 0)
				{
					eof = true;
					break;
				}
				int idx = str.indexOf("#");
				String proStr = str.substring(0, idx);
				if(idx+1<str.length())
					str = str.substring(idx+1);
				else
					str = "";
				String ansStr = "";
				for(int i=0; i<proStr.length(); i++)
				{
					int c = -1;
					if(proStr.charAt(i)>='A' && proStr.charAt(i)<='Z')
						c = proStr.charAt(i) - 'A';
					else if(proStr.charAt(i)>='a' && proStr.charAt(i)<='z')
						c = proStr.charAt(i) - 'a' + 26;
					else if(proStr.charAt(i)>='0' && proStr.charAt(i)<='9')
						c = proStr.charAt(i) - '0' + 52;
					else if(proStr.charAt(i)=='+')
						c = 62;
					else if(proStr.charAt(i)=='/')
						c = 63;
					else if(proStr.charAt(i)=='=')
						c = 0;
					if(c != -1)
					{
						String s = "";
						for(int j=0; j<6; j++)
						{
							s = (c%2)+s;
							c /= 2;
						}
						ansStr += s;
					}
				}
				//System.out.println(ansStr.length()+" "+ansStr);
				for(int i=0; i<ansStr.length(); i+=8)
				{
					int c = 0;
					for(int j=0; j<8; j++)
						c = c*2+(ansStr.charAt(i+j)-'0');
					if(c > 0)
						System.out.print((char)c);					
				}
				System.out.print("#");
			}while(str.contains("#"));
		}
	}

}
