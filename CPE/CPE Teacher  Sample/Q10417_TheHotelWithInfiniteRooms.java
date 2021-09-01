import java.util.Scanner;


public class Q10417_TheHotelWithInfiniteRooms 
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
			long s = scn.nextLong();
			long d = scn.nextLong();
			long i = 1;
			while((s+s+i-1)*i/2 < d)
				i++;
			System.out.println(s+i-1);
		}
	}

}
