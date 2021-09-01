import java.util.Scanner;


public class Q10403_FunnyEncryptionMethod 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int cases = scn.nextInt();
		while(cases>0)
		{
			int num = scn.nextInt();
			int tmp = num;
			int b1=0;
			while(tmp>0)
			{
				if(tmp%2 == 1)
					b1++;
				tmp/=2;
			}
			tmp = num;
			int b2=0;
			while(tmp>0)
			{
				if(tmp%10==1 || tmp%10==2 || tmp%10==4 || tmp%10==8)
					b2++;
				else if(tmp%10==3 || tmp%10==5 || tmp%10==6 || tmp%10==9)
					b2+=2;
				else if(tmp%10==7)
					b2+=3;
				tmp/=10;
			}
			System.out.println(b1+" "+b2);
			cases--;
		}
	}

}
