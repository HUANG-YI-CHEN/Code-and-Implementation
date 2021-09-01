import java.util.Scanner;


public class Q2008_13_MaximumContiguousSubsequence 
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
			str = str.substring(2, str.length()-2);
			String[] tmp = str.split(" ");
			double[] num = new double[tmp.length];
			boolean allNeg = true;
			for(int i=0; i<num.length; i++)
			{
				num[i] = Double.parseDouble(tmp[i]);
				if(num[i] >= 0)
					allNeg = false;
			}
			int bIdx = -1;
			int eIdx = -1;
			double max = Double.NEGATIVE_INFINITY;
			for(int i=0; i<num.length; i++)
				for(int j=i; j<num.length; j++)
				{
					double sum = 0;
					for(int k=i; k<=j; k++)
						sum += num[k];
					if(sum > max)
					{
						bIdx = i;
						eIdx = j;
						max = sum;						
					}
				}
			//if(max>=0)
			{
				System.out.print("Sum of A["+bIdx+"..."+eIdx+"] is max, which sum is ");
				if((int)max == max)
					System.out.println((int)max);
				else
					System.out.println(max);
			}
			//else
				//System.out.println("Sum of A[...] is max, which sum is 0");
		}
	}

}
