import java.util.Scanner;
import java.util.Vector;


public class Q10015_FalseCoin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int k = scn.nextInt();
		Vector<Integer> candidate = new Vector<Integer>();
		for(int i=1; i<=n; i++)
			candidate.add(i);
		boolean hasFalse = false;
		for(int i=0; i<k; i++)
		{
			int c = scn.nextInt();
			int[] left = new int[c];
			int[] right = new int[c];
			for(int j=0; j<c; j++)
				left[j] = scn.nextInt();
			for(int j=0; j<c; j++)
				right[j] = scn.nextInt();
			scn.nextLine();
			String str = scn.nextLine();
			if(str.compareTo("=") == 0)
			{
				for(int j=0; j<c; j++)
					candidate.removeElement(left[j]);
				for(int j=0; j<c; j++)
					candidate.removeElement(right[j]);
			}
			else
			{
				Vector<Integer> del = new Vector<Integer>();
				for(int o:candidate)
				{
					boolean isFind = false;
					for(int j=0; j<c; j++)
						if(o == left[j])
						{
							isFind = true;
							break;
						}
					if(!isFind)
						for(int j=0; j<c; j++)
							if(o == right[j])
							{
								isFind = true;
								break;
							}
					if(!isFind)	
						del.add(o);
				}
				for(int o:del)
					candidate.removeElement(o);
				hasFalse = true;
			}
			
		}
		if(!hasFalse)
			System.out.println("0");
		else
			System.out.println(candidate.get(0));
	}

}
