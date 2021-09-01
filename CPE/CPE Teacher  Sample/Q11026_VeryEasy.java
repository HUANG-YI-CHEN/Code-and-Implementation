import java.math.BigInteger;
import java.util.Scanner;


public class Q11026_VeryEasy
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		while(scn.hasNext())
		{
			BigInteger N = new BigInteger(scn.nextInt()+"");
			BigInteger A = new BigInteger(scn.nextInt()+"");
			BigInteger sum = new BigInteger("0");
			
			for(BigInteger i=new BigInteger("1"); i.intValue()<=N.intValue(); i=i.add(new BigInteger("1")))
			{
				sum = sum.add(i.multiply(A.pow(i.intValue())));				
			}
			
			System.out.println(sum);
		}
	}

}
