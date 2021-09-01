import java.util.Scanner;
import java.util.Vector;


public class Q23621_B2Sequence 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int cs = 1;
		while(scn.hasNext())
		{
			int n = scn.nextInt();
			int[] b = new int[n];
			for(int i=0; i<n; i++)
				b[i] = scn.nextInt();
			if(b2(b))
				System.out.println("Case #"+cs+": It is a B2-Sequence.\n");
			else
				System.out.println("Case #"+cs+": It is not a B2-Sequence.\n");
			cs++;
		}
	}
	public static boolean b2(int[] b)
	{
		for(int i=0; i<b.length-1; i++)
			if(b[i] > b[i+1])
				return false;
		Vector<Integer> v = new Vector<Integer>();
		for(int i=0; i<b.length; i++)
			for(int j=i; j<b.length; j++)
			{
				int sum = b[i] + b[j];
				//System.out.println(sum);
				if(v.contains(sum))
					return false;
				else
					v.add(sum);
			}
		return true;
		
	}

}
