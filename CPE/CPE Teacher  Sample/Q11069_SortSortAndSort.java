import java.util.Scanner;


public class Q11069_SortSortAndSort
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		while(true)
		{
			int N = scn.nextInt();
			int M = scn.nextInt();
			System.out.println(N+" "+M);
			if(N==0 && M==0)
				break;
			int[] num = new int[N];
			for(int i=0; i<N; i++)
				num[i] = scn.nextInt();
			for(int i=0; i<N; i++)
				for(int j=i+1; j<N; j++)
				{
					if(num[i]%M > num[j]%M)
					{
						int tmp=num[i]; num[i]=num[j]; num[j]=tmp;
					}
					else if(num[i]%M == num[j]%M)
					{
						if(num[i]%2 < num[j]%2)
						{
							int tmp=num[i]; num[i]=num[j]; num[j]=tmp;
						}
						else if(num[i]%2==1 && num[j]%2==1 && num[i]<num[j])
						{
							int tmp=num[i]; num[i]=num[j]; num[j]=tmp;
						}
						else if(num[i]%2==0 && num[j]%2==0 && num[i]>num[j])
						{
							int tmp=num[i]; num[i]=num[j]; num[j]=tmp;
						}
					}
				}
			for(int i=0; i<N; i++)
				System.out.println(num[i]);			
		}
	}

}
