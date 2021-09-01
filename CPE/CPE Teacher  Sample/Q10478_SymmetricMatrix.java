import java.util.Scanner;


public class Q10478_SymmetricMatrix
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int cs = scn.nextInt();
		for(int idx=1; idx<=cs; idx++)
		{
			scn.next();
			scn.next();
			int N = scn.nextInt();
			int[][] matrix = new int[N][N];
			for(int i=0; i<N; i++)
				for(int j=0; j<N; j++)
					matrix[i][j] = scn.nextInt();
			boolean sym = true;
			for(int i=0; i<N; i++)
			{
				for(int j=0; j<N; j++)
					if(matrix[i][j] != matrix[N-1-i][N-1-j])
					{
						sym = false;
						break;
					}
				if(!sym)
					break;
			}
			if(sym)
				System.out.println("Test #"+idx+": Symmetric.");
			else
				System.out.println("Test #"+idx+": Non-symmetric.");
		}
	}

}
