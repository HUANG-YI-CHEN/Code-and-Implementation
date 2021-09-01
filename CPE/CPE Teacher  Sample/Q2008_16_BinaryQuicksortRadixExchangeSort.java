import java.util.Scanner;


public class Q2008_16_BinaryQuicksortRadixExchangeSort
{

	/**
	 * @param args
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
			str = str.substring(1, str.length()-1);
			String[] tmp = str.split(" ");
			long[] num = new long[tmp.length];
			for(int i=0; i<tmp.length; i++)
				num[i] = Long.parseLong(tmp[i]);
			for(int i=0; i<num.length; i++)
				for(int j=i+1; j<num.length; j++)
					if(num[i] > num[j])
					{
						long t = num[i];
						num[i] = num[j];
						num[j] = t;
					}
			System.out.print(num[0]);
			for(int i=1; i<num.length; i++)
				System.out.print(" "+num[i]);
			System.out.println();
		}
	}

}
