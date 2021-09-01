import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;


public class Q2008_34_HammingSequence 
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
			int n = Integer.parseInt(str);
			TreeSet<Integer> T = new TreeSet<Integer>();
			TreeSet<Integer> U = new TreeSet<Integer>();
			T.add(1);
			while(U.size() < n)
			{
				int x = T.first();
				U.add(x);
				T.remove(x);
				T.add(2*x);
				T.add(3*x);
				T.add(5*x);
			}
			System.out.println("For n = "+n+", the first "+n+" elements of the Hamming sequence are");
			Iterator<Integer> it = U.iterator();			
			System.out.print(it.next());
			while(it.hasNext())
				System.out.print(","+it.next());
			System.out.println();
		}
	}

}
