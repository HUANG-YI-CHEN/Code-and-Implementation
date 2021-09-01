import java.util.Scanner;


public class Q22811_TrainSwapping 
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
			int[] a = new int[n];
			for(int i=0; i<n; i++)
				a[i] = scn.nextInt();
			int s = 0;
			for(int i=0; i<n; i++)
				for(int j=i; j<n; j++)
					if(a[i] > a[j])
					{
						int tmp = a[i];
						a[i] = a[j];
						a[j] = tmp;
						s++;
					}
			System.out.println("Optimal train swapping takes "+s+" swaps.");
		}
	}

}
