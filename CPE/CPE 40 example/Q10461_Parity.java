import java.util.Scanner;


public class Q10461_Parity 
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
			int I = scn.nextInt();
			if(I == 0)
				break;
			String bin = "";
			while(I > 0)
			{
				bin = (I%2) + bin;
				I /= 2;
			}
			int s1 = 0;
			for(int i=0; i<bin.length(); i++)
				if(bin.charAt(i) == '1')
					s1 ++;
			System.out.println("The parity of "+bin+" is "+s1+" (mod 2).");
		}
	}

}
