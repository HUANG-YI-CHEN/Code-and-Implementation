import java.util.HashSet;
import java.util.Scanner;

public class Q10514_Freckles
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int cases = scn.nextInt();
		while(cases > 0)
		{
			int n = scn.nextInt();
			double[] x = new double[n];
			double[] y = new double[n];
			for(int i=0; i<n; i++)
			{
				x[i] = scn.nextDouble();
				y[i] = scn.nextDouble();
			}
			int nEdges = n*(n-1)/2; // n個點有n(n-1)/2個邊
			int[] s = new int[nEdges];
			int[] e = new int[nEdges];
			double[] dis = new double[nEdges];
			int idx = 0;
			for(int i=0; i<n; i++)
				for(int j=i+1; j<n; j++)
				{
					s[idx] = i;
					e[idx] = j;
					dis[idx] = Math.sqrt((x[i]-x[j])*(x[i]-x[j])+(y[i]-y[j])*(y[i]-y[j]));
					idx++;
				}
			//sorting
			for(int i=0; i<nEdges; i++)
				for(int j=i+1; j<nEdges; j++)
					if(dis[i]>dis[j])
					{
						int tmp1=s[i];s[i]=s[j];s[j]=tmp1;
						    tmp1=e[i];e[i]=e[j];e[j]=tmp1;
						double tmp2=dis[i];dis[i]=dis[j];dis[j]=tmp2;
					}
			double sum = 0;
			HashSet<HashSet<Integer>> disjointSet = new HashSet<HashSet<Integer>>();
			for(int i=0; i<nEdges; i++)
			{
				boolean selected = true;
				for(HashSet<Integer> element:disjointSet)
				{
					if(element.contains(s[i]) && element.contains(e[i])) //has cycle
					{
						selected = false;
						break;
					}
				}
				if(selected)
				{
					HashSet<Integer> newElement = new HashSet<Integer>();
					newElement.add(s[i]);
					newElement.add(e[i]);
					for(HashSet<Integer> element:disjointSet)
					{
						if(element.contains(s[i]) || element.contains(e[i]))
						{
							newElement.addAll(element);
							//disjointSet.remove(element);
						}
					}			
					sum += dis[i];
					if(newElement.size() == n) // 所有點都連起來
						break;
					disjointSet.add(newElement);
				}
			}
			System.out.printf("%.2f\n", sum);
			cases--;
			if(cases>0)
				System.out.println();
		}
	}

}
