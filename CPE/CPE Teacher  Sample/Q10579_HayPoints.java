import java.util.HashMap;
import java.util.Scanner;


public class Q10579_HayPoints 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int m = scn.nextInt();
		int n = scn.nextInt();
		HashMap<String, Integer> D = new HashMap<String, Integer>();
		for(int i=0; i<m; i++)
			D.put(scn.next(), scn.nextInt());
		for(int i=0; i<n; i++)
		{
			int sum = 0;
			String word = "";
			while(true)
			{
				word = scn.next();
				if(word.compareTo(".") == 0)
					break;
				if(D.containsKey(word))
					sum += D.get(word);
			}
			System.out.println(sum);
		}
	}

}
