import java.util.Scanner;
import java.util.TreeMap;


public class Q10426_HardwoodSpecies
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int cs = scn.nextInt();
		scn.nextLine();
		scn.nextLine();
		while(cs-- > 0)
		{
			TreeMap<String, Integer> T = new TreeMap<String, Integer>();
			double sum = 0;
			while(scn.hasNext())
			{
				String str = scn.nextLine();
				if(str.compareTo("") == 0)
					break;
				if(T.containsKey(str))
					T.put(str, T.get(str)+1);
				else
					T.put(str, 1);
				sum++;
			}
			Object[] keys = T.keySet().toArray();
			for(int i=0; i<keys.length; i++)
				System.out.printf("%s %.4f\n", keys[i], T.get(keys[i])*100/sum);
			if(cs > 0)
				System.out.println();
		}
	}

}
