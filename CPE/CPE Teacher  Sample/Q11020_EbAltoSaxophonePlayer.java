import java.util.Scanner;


public class Q11020_EbAltoSaxophonePlayer 
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
		while(cs > 0)
		{			
			String str = scn.nextLine();
			if(str.compareTo("") == 0)
				System.out.println("0 0 0 0 0 0 0 0 0 0");
			else
			{
				int[] cnt = new int[10];
				for(int j=0; j<10; j++)
					cnt[j] = fin(str.charAt(0), j);
				for(int i=1; i<str.length(); i++)
					for(int j=0; j<10; j++)
						if(fin(str.charAt(i), j)==1 && fin(str.charAt(i-1), j)==0)
							cnt[j] ++;
				System.out.print(cnt[0]);
				for(int j=1; j<10; j++)
					System.out.print(" "+cnt[j]);
				System.out.println();
			}
			cs--;
		}
	}
	
	public static int fin(char ch, int idx)
	{
		if(ch == 'c')
		{
			int[] f = new int[] {0,1,1,1,0,0,1,1,1,1};
			return f[idx];
		}
		else if(ch =='d')		
		{
			int[] f = new int[] {0,1,1,1,0,0,1,1,1,0};
			return f[idx];
		}
		else if(ch =='e')
		{
			int[] f = new int[] {0,1,1,1,0,0,1,1,0,0};
			return f[idx];
		}
		else if(ch =='f')
		{
			int[] f = new int[] {0,1,1,1,0,0,1,0,0,0};
			return f[idx];
		}
		else if(ch =='g')
		{
			int[] f = new int[] {0,1,1,1,0,0,0,0,0,0};
			return f[idx];
		}
		else if(ch =='a')
		{
			int[] f = new int[] {0,1,1,0,0,0,0,0,0,0};
			return f[idx];
		}
		else if(ch =='b')
		{
			int[] f = new int[] {0,1,0,0,0,0,0,0,0,0};
			return f[idx];
		}
		else if(ch =='C')
		{
			int[] f = new int[] {0,0,1,0,0,0,0,0,0,0};
			return f[idx];
		}
		else if(ch =='D')
		{
			int[] f = new int[] {1,1,1,1,0,0,1,1,1,0};
			return f[idx];
		}
		else if(ch =='E')
		{
			int[] f = new int[] {1,1,1,1,0,0,1,1,0,0};
			return f[idx];
		}
		else if(ch =='F')
		{
			int[] f = new int[] {1,1,1,1,0,0,1,0,0,0};
			return f[idx];
		}
		else if(ch =='G')
		{
			int[] f = new int[] {1,1,1,1,0,0,0,0,0,0};
			return f[idx];
		}
		else if(ch =='A')
		{
			int[] f = new int[] {1,1,1,0,0,0,0,0,0,0};
			return f[idx];
		}
		else
		{
			int[] f = new int[] {1,1,0,0,0,0,0,0,0,0};
			return f[idx];
		}
	}

}
