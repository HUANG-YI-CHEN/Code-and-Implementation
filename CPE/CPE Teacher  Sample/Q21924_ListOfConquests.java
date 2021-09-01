import java.util.Scanner;
import java.util.TreeMap;


public class Q21924_ListOfConquests
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		TreeMap<String, Integer> cnt = new TreeMap<String, Integer>(); 
		Scanner scn = new Scanner(System.in);		
		int cs = scn.nextInt();		
		while(cs > 0)
		{
			String country = scn.next();
			scn.nextLine();
			if(cnt.containsKey(country))
				cnt.put(country, cnt.get(country)+1);
			else
				cnt.put(country, 1);
			cs--;
		}
		Object[] keys = cnt.keySet().toArray();
		for(int i=0; i<cnt.size(); i++)
		{
			System.out.println(keys[i]+" "+cnt.get(keys[i]));
		}
	}

}
