import java.util.ArrayList;
import java.util.Scanner;


public class Q10606_HowBigIsIt 
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int cs = scn.nextInt();
		while(cs-- > 0)
		{
			int n = scn.nextInt();
			double[] r = new double[n];
			for(int i=0; i<n; i++)
				r[i] = scn.nextDouble();
			boolean[] selected = new boolean[n];
			for(int i=0; i<n; i++)
				selected[i] = false;
			min = Integer.MAX_VALUE;
			permutation(r, new ArrayList<Integer>(), selected, 0);
			System.out.printf("%.3f\n", min);
		}
	}
	public static double min = Integer.MAX_VALUE;
	public static void permutation(double[] r, ArrayList<Integer> idx, boolean[] selected, int level)
	{
		if(level == selected.length)
		{			
			double len = minLen(r, idx);
			//System.out.println(idx+" "+len);
			if(len < min)
				min = len;
		}
		else
		{
			for(int i=0; i<selected.length; i++)
			{
				if(!selected[i])
				{
					selected[i] = true;
					idx.add(i);
					permutation(r, idx, selected, level+1);
					selected[i] = false;
					idx.remove(idx.size()-1);
				}
			}
		}
	}
	public static double minLen(double[] r, ArrayList<Integer> idx)
	{
		double[] x = new double[idx.size()];
		x[0] = 0;
		for(int i=1; i<idx.size(); i++)
		{
			x[i] = Double.NEGATIVE_INFINITY;
			for(int j=i-1; j>=0; j--)				
				x[i] = Math.max(x[i], x[j] + Math.sqrt(4*r[idx.get(j)]*r[idx.get(i)]));
		}
		/*for(int i=0; i<idx.size(); i++)
			System.out.print(x[i]+" ");
		System.out.println();*/
		double minX = Double.POSITIVE_INFINITY;
		double maxX = Double.NEGATIVE_INFINITY;
		for(int i=0; i<idx.size(); i++)
		{
			if(x[i] - r[idx.get(i)] < minX)
				minX = x[i] - r[idx.get(i)];
			if(x[i] + r[idx.get(i)] > maxX)
				maxX = x[i] + r[idx.get(i)];			
		}
		//System.out.println(maxX-minX);
		double len = r[idx.get(0)] + r[idx.get(idx.size()-1)];
		for(int i=0; i<idx.size()-1; i++)
			len += Math.max(Math.max(Math.sqrt(4*r[idx.get(i)]*r[idx.get(i+1)]), r[idx.get(i)]), r[idx.get(i+1)]);
		//System.out.println(len);

		return maxX - minX;
	}
}
