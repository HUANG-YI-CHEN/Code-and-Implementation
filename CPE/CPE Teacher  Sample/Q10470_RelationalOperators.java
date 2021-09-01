import java.util.Scanner;


public class Q10470_RelationalOperators 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int cs = scn.nextInt();
		while(cs-- > 0)
		{
			int n1 = scn.nextInt();
			int n2 = scn.nextInt();
			if(n1 > n2)
				System.out.println(">");
			else if(n1 < n2)
				System.out.println("<");
			else
				System.out.println("=");
		}
	}

}
