import java.math.BigInteger;
import java.util.Scanner;

public class Q10526_Product
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
			BigInteger X = new BigInteger(scn.nextLine());
			BigInteger Y = new BigInteger(scn.nextLine());
			System.out.println(X.multiply(Y));
		}
	}

}
