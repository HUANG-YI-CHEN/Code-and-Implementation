import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Q10429_ContestScoreboard 
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
		while(cs > 0)
		{
			ArrayList<String> in = new ArrayList<String>();
			while(scn.hasNext())
			{
				String str = scn.nextLine();
				if(str.compareTo("") == 0)
					break;
				in.add(str);
			}
			HashMap<Integer, int[]> S = new HashMap<Integer, int[]>();
			for(int i=0; i<in.size(); i++)
			{
				String[] tmp = in.get(i).split(" ");
				if(!S.containsKey(Integer.parseInt(tmp[0])))
				{
					int[] score = new int[10];
					for(int j=1; j<=9; j++)
						score[j] = 0;
					S.put(Integer.parseInt(tmp[0]), score);
				}
				if(tmp[3].compareTo("I") == 0)
				{
					int[] score = S.get(Integer.parseInt(tmp[0]));
					if(score[Integer.parseInt(tmp[1])] <= 0)
						score[Integer.parseInt(tmp[1])] -= 20;
					S.put(Integer.parseInt(tmp[0]), score);
				}
				else if(tmp[3].compareTo("C") == 0)
				{
					int[] score = S.get(Integer.parseInt(tmp[0]));
					if(score[Integer.parseInt(tmp[1])] <= 0)
						score[Integer.parseInt(tmp[1])] = Integer.parseInt(tmp[2])-score[Integer.parseInt(tmp[1])];
					S.put(Integer.parseInt(tmp[0]), score);
				}
			}
			//¨ú¦¨ÁZ
			int[] id = new int[S.keySet().size()];
			int[] ns = new int[S.keySet().size()];
			int[] tm = new int[S.keySet().size()];
			int c = 0;
			for(int uid: S.keySet())
			{
				id[c] = uid;
				int[] score = S.get(uid);
				ns[c] = 0;
				tm[c] = 0;
				for(int j=1; j<=9; j++)
					if(score[j] > 0)
					{
						ns[c]++;
						tm[c]+=score[j];
					}
				c++;
			}
			//±Æ§Ç
			for(int i=0; i<id.length; i++)
			{
				for(int j=i+1; j<id.length; j++)
				{
					if(ns[i] < ns[j])
					{
						int tmp=id[i]; id[i]=id[j]; id[j]=tmp;
						    tmp=ns[i]; ns[i]=ns[j]; ns[j]=tmp;
						    tmp=tm[i]; tm[i]=tm[j]; tm[j]=tmp;						
					}
					else if(ns[i] == ns[j] && tm[i] > tm[j])
					{
						int tmp=id[i]; id[i]=id[j]; id[j]=tmp;
						    tmp=ns[i]; ns[i]=ns[j]; ns[j]=tmp;
						    tmp=tm[i]; tm[i]=tm[j]; tm[j]=tmp;						
					}
					else if(ns[i] == ns[j] && tm[i] == tm[j] && id[i] > id[j])
					{
						int tmp=id[i]; id[i]=id[j]; id[j]=tmp;
						    tmp=ns[i]; ns[i]=ns[j]; ns[j]=tmp;
						    tmp=tm[i]; tm[i]=tm[j]; tm[j]=tmp;						
					}						
				}
				System.out.println(id[i]+" "+ns[i]+" "+tm[i]);				
			}
			cs--;
			if(cs > 0)
				System.out.println();
		}
	}

}
