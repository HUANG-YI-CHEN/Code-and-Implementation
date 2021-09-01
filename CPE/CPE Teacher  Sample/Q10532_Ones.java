import java.math.BigInteger;
import java.util.Scanner;

public class Q10532_Ones 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		/*for(int i=1; i<10000; i+=2)
		{
			if(i%5 != 0)
			{
				int cnt = 1;
				int p = 1;
				while(p%i != 0)
				{
					p = (p*10+1)%i;
					cnt++;
				}
				System.out.println(i+"\t"+cnt);				
			}
		}*/
		Scanner scn = new Scanner(System.in);
		while(scn.hasNext())
		{
			int num = scn.nextInt();
			if(num%2==0 || num%5==0)
			{
				System.out.println();
				continue;
			}
			/*
			BigInteger n = new BigInteger(num+"");
			String str = "1";
			while(new BigInteger(str).mod(n) != BigInteger.ZERO)
				str += "1";
			System.out.println(str.length());
			*/
			int cnt = 1;
			int p = 1;
			while(p%num != 0)
			{
				p = (p*10+1)%num;
				cnt++;
			}
			System.out.println(cnt);
		}
	}

}
