import java.util.Scanner;


public class Q10644_TheTouristGuide 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		for(int round=1; ; round++)
		{
			int n = scn.nextInt();
			int r = scn.nextInt();
			if(n==0 && r==0)
				break;
			int[] x = new int[r];
			int[] y = new int[r];
			int[] cap = new int[r];
			
			for(int i=0; i<r; i++)
			{
				x[i] = scn.nextInt();
				y[i] = scn.nextInt();
				cap[i] = scn.nextInt();
			}
			int s = scn.nextInt();
			int e = scn.nextInt();
			int total = scn.nextInt();
			boolean[][] selected = new boolean[n+1][n+1];
			for(int i=1; i<n+1; i++)
				for(int j=1; j<n+1; j++)
					selected[i][j] = false;
			boolean[] visited = new boolean[n+1];
			for(int i=1; i<n+1; i++)
				visited[i] = false;
			while(!isConnected(selected, s, e, visited))
			{
				int max = 0;
				for(int i=0; i<r; i++)
					if(cap[i]>max && !selected[x[i]][y[i]])
						max = cap[i];
				for(int i=0; i<r; i++)
					if(cap[i]==max)
					{
						selected[x[i]][y[i]] = true;
						selected[y[i]][x[i]] = true;
					}
				for(int i=1; i<n+1; i++)
					visited[i] = false;
			}
			int min = Integer.MAX_VALUE;
			for(int i=0; i<r; i++)
				if(selected[x[i]][y[i]] && cap[i]<min)
					min = cap[i];
			System.out.println("Scenario #"+round);
			System.out.print("Minimum Number of Trips = ");
			if(total%(min-1) == 0)				
				System.out.println(total/(min-1));
			else
				System.out.println(total/(min-1)+1);
			System.out.println();
		}
	}
	public static boolean isConnected(boolean[][] selected, int s, int e, boolean[] visited)
	{
		visited[s] = true;
		if(selected[s][e])
			return true;
		else
		{
			for(int i=1; i<visited.length; i++)
				if(!visited[i] && selected[s][i] && isConnected(selected, i, e, visited))
					return true;
		}
		return false;
	}
}
