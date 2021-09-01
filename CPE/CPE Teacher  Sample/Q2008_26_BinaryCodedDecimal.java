import java.util.Scanner;


public class Q2008_26_BinaryCodedDecimal 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int nTest = scn.nextInt();
		scn.nextLine();
		while(nTest>0)
		{
			String[] tmp = scn.nextLine().split(" ");
			if(tmp[0].compareTo("+") == 0)
				System.out.println(Long.parseLong(tmp[1])+Long.parseLong(tmp[2]));
			else if(tmp[0].compareTo("-") == 0)
				System.out.println(Long.parseLong(tmp[1])-Long.parseLong(tmp[2]));
			else if(tmp[0].compareTo("*") == 0)
				System.out.println(Long.parseLong(tmp[1])*Long.parseLong(tmp[2]));
			nTest--;
		}
		/*long i = 1234567;
		long j = 8765433;

		long a1 =  1234567 + 8765433;
		long a2 = 22334455 - 4456;
		long a3 = 219625 * 4237;
		
		String stri = int2bcd(i);
		String strj = int2bcd(j);
		long ii = bcd2int(stri);
		long jj = bcd2int(strj);
		long iii = bcd2norint(stri);
		long jjj = bcd2norint(strj);
		System.out.println(i+"\t"+stri+"\t"+iii);
		System.out.println(j+"\t"+strj+"\t"+jjj);
		long sss = iii+jjj;
		String strsss = int2bir(sss);
		long ans = bcd2int(strsss);
		System.out.println(ans+"\t"+strsss+"\t"+sss);
		System.out.println();*/
	}
	
	public static String int2bcd(long n)
	{
		String str = "";
		
		while(n > 0)
		{
			if(n%10 == 0)
				str = "0000"+str;
			else if(n%10 == 1)
				str = "0001"+str;
			else if(n%10 == 2)
				str = "0010"+str;
			else if(n%10 == 3)
				str = "0011"+str;
			else if(n%10 == 4)
				str = "0100"+str;
			else if(n%10 == 5)
				str = "0101"+str;
			else if(n%10 == 6)
				str = "0110"+str;
			else if(n%10 == 7)
				str = "0111"+str;
			else if(n%10 == 8)
				str = "1000"+str;
			else if(n%10 == 9)
				str = "1001"+str;
			n/=10;
		}
		return str;
	}
	public static long bcd2norint(String str)
	{
		long n = 0;
		for(int i=0; i<str.length(); i++)
			if(str.charAt(i)=='1')
				n+=Math.pow(2, str.length()-1-i);
		return n;
	}
	public static String int2bir(long n)
	{
		String str = "";
		while(n>0)
		{
			str = (n%2)+str;
			n/=2;
		}
		while(str.length() %4 !=0)
		{
			str = "0"+str;
		}
		return str;
	}
	public static long bcd2int(String str)
	{
		long n = 0;
		for(int i=0; i<str.length(); i+=4)
		{
			if(str.substring(i, i+4).compareTo("0000")==0)
				n=n*10+0;
			else if(str.substring(i, i+4).compareTo("0001")==0)
				n=n*10+1;
			else if(str.substring(i, i+4).compareTo("0010")==0)
				n=n*10+2;
			else if(str.substring(i, i+4).compareTo("0011")==0)
				n=n*10+3;
			else if(str.substring(i, i+4).compareTo("0100")==0)
				n=n*10+4;
			else if(str.substring(i, i+4).compareTo("0101")==0)
				n=n*10+5;
			else if(str.substring(i, i+4).compareTo("0110")==0)
				n=n*10+6;
			else if(str.substring(i, i+4).compareTo("0111")==0)
				n=n*10+7;
			else if(str.substring(i, i+4).compareTo("1000")==0)
				n=n*10+8;
			else if(str.substring(i, i+4).compareTo("1001")==0)
				n=n*10+9;
		}
		return n;		
	}
}
