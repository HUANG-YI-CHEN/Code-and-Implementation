import java.util.Scanner;


public class Q11028_DigitPrimes {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		int round = input.nextInt();
		for(int i=0; i<round; i++)
		{
			int n1, n2, count=0;
			n1=input.nextInt();
			n2=input.nextInt();
			count=0;
			for(;n1<=n2;++n1)
			{
				if(is_prime(n1))
					if(is_prime(sumOfDigi(n1)))
						count++;
			} 
			System.out.println(count);	
		}
	}
	
	public static boolean is_prime(int k)
	{
		if(k<2)
			return false;
		for(int i=2;i<=Math.sqrt(k);++i)
		{
			if(k%i==0)
				return false;
		}
		
		return true;
	}
	public static int sumOfDigi(int n)
	{
		String temp=n+"";
		String[] str=temp.split("");
		int sum=0;
		for(int i=1;i<str.length;++i){
			sum+=Integer.parseInt(str[i]);
		}
		return sum;
	}


}
