import java.util.Scanner;


public class Q10431_498 
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
			int x = scn.nextInt();
			scn.nextLine();
			String[] a = scn.nextLine().split(" ");
			int sum = 0;
			for(int i=0; i<a.length-1; i++)
			{
				sum += (a.length-1-i)*Integer.parseInt(a[i])*Math.pow(x, (a.length-2-i));
			}
			System.out.println(sum);
		}
	}

}
