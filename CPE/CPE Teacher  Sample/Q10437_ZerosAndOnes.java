import java.util.Scanner;


public class Q10437_ZerosAndOnes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int c = 1;
		while(scn.hasNext())
		{
			System.out.println("Case "+c+":");
			String str = scn.nextLine();
			int round = scn.nextInt();
			for(int r=0; r<round; r++)
			{
				int i = scn.nextInt();
				int j = scn.nextInt();
				if(i>j)
				{int k=i; i=j; j=k;}
				int sum = 0;
				for(int k=i; k<=j; k++)
					sum += (str.charAt(k)-'0');
				if(sum == 0 || sum == (j-i+1))
					System.out.println("Yes");
				else
					System.out.println("No");
			}
			scn.nextLine();
			c++;
		}
	}

}
