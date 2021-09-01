import java.util.HashMap;
import java.util.Scanner;


public class Q10415_SalaMaSondANiceLittlePond 
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
			int N = scn.nextInt();
			int M = scn.nextInt();
			int T = scn.nextInt();
			int K = scn.nextInt();
			int[][] pond = new int[N][M];
			for(int i=0; i<N; i++)
				for(int j=0; j<M; j++)
					pond[i][j] = 0;
			HashMap<Integer, Integer> idMap = new HashMap<Integer, Integer>(); 
			int[] ty = new int[T];
			int[] tx = new int[T];
			for(int i=0; i<T; i++)
			{
				int id = scn.nextInt();
				idMap.put(id, i);
				ty[i] = scn.nextInt();
				tx[i] = scn.nextInt();
				pond[ty[i]][tx[i]] = id;
			}
			for(int i=0; i<K; i++)
			{
				int id = scn.nextInt();
				int idx = idMap.get(id);
				String dir = scn.next();
				if(dir.compareTo("N") == 0)
				{
					if(ty[idx]>0 && pond[ty[idx]-1][tx[idx]]==0)
					{
						pond[ty[idx]][tx[idx]] = 0;
						ty[idx]--;
						pond[ty[idx]][tx[idx]] = id;
					}
				}
				else if(dir.compareTo("S") == 0)
				{
					if(ty[idx]<N-1 && pond[ty[idx]+1][tx[idx]]==0)
					{
						pond[ty[idx]][tx[idx]] = 0;
						ty[idx]++;
						pond[ty[idx]][tx[idx]] = id;
					}
				}
				else if(dir.compareTo("E") == 0)
				{
					if(tx[idx]<M-1 && pond[ty[idx]][tx[idx]+1]==0)
					{
						pond[ty[idx]][tx[idx]] = 0;
						tx[idx]++;
						pond[ty[idx]][tx[idx]] = id;
					}
				}
				else if(dir.compareTo("W") == 0)
				{
					if(tx[idx]>0 && pond[ty[idx]][tx[idx]-1]==0)
					{
						pond[ty[idx]][tx[idx]] = 0;
						tx[idx]--;
						pond[ty[idx]][tx[idx]] = id;
					}
				}
				else if(dir.compareTo("NE") == 0)
				{
					if(ty[idx]>0 && tx[idx]<M-1 && pond[ty[idx]-1][tx[idx]+1]==0)
					{
						pond[ty[idx]][tx[idx]] = 0;
						ty[idx]--;
						tx[idx]++;
						pond[ty[idx]][tx[idx]] = id;
					}
				}
				else if(dir.compareTo("NW") == 0)
				{
					if(ty[idx]>0 && tx[idx]>0 && pond[ty[idx]-1][tx[idx]-1]==0)
					{
						pond[ty[idx]][tx[idx]] = 0;
						ty[idx]--;
						tx[idx]--;
						pond[ty[idx]][tx[idx]] = id;
					}
				}
				else if(dir.compareTo("SE") == 0)
				{
					if(ty[idx]<N-1 && tx[idx]<M-1 && pond[ty[idx]+1][tx[idx]+1]==0)
					{
						pond[ty[idx]][tx[idx]] = 0;
						ty[idx]++;
						tx[idx]++;
						pond[ty[idx]][tx[idx]] = id;
					}
				}
				else if(dir.compareTo("SW") == 0)
				{
					if(ty[idx]<N-1 && tx[idx]>0 && pond[ty[idx]+1][tx[idx]-1]==0)
					{
						pond[ty[idx]][tx[idx]] = 0;
						ty[idx]++;
						tx[idx]--;
						pond[ty[idx]][tx[idx]] = id;
					}
				}
			}
			
			for(int i=0; i<N; i++)
			{
				String str = "";
				for(int j=0; j<M; j++)
				{					
					if(pond[i][j] == 0)
						str += " ";
					else
						str += "*";
				}
				while(str.compareTo("")!=0 && str.charAt(str.length()-1)==' ')
					str = str.substring(0, str.length()-1);
				System.out.println(str);
			}
			
			System.out.println();
		}
	}
}
