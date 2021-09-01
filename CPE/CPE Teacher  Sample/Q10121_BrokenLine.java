import java.util.Scanner;


public class Q10121_BrokenLine {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int k = scn.nextInt();
		int[] p1x = new int[k];
		int[] p1y = new int[k];
		int[] p2x = new int[k];
		int[] p2y = new int[k];
		for(int i=0; i<k; i++)
		{
			p1x[i] = scn.nextInt();
			p1y[i] = scn.nextInt();
			p2x[i] = scn.nextInt();
			p2y[i] = scn.nextInt();			
		}
		/*int[] nCross = new int[k];		
		for(int i=0; i<k; i++)
		{
			nCross[i] = 0;
			for(int j=0; j<k; j++)
				if(CalCrossPoint(p1x[i], p1y[i], p2x[i], p2y[i], p1x[j], p1y[j], p2x[j], p2y[j]) != null)
					nCross[i]++;
		}*/
		int ans = 1;
		for(int i=0; i<k; i++)
		{
			//if(nCross[i] >= 2)
			{
				int cross = 0;
				for(int j=0; j<k; j++)
					if(/*nCross[j] >= 2 && */CalCrossPoint(p1x[i], p1y[i], p2x[i], p2y[i], p1x[j], p1y[j], p2x[j], p2y[j]) != null)
						cross++;
				if(cross < 2)
				{
					ans = 0;
					break;
				}
			}
		}
		
		//double[] pp = CalCrossPoint(0, 0, 1, 1, 0, -2, 1, 0);
		//System.out.println(pp==null?"不相交":pp[0]+","+pp[1]);
		System.out.println(ans);
	}

	// 計算兩條二維直線的交點，結果在參數P中返回
	// 傳回值說明了兩條直線的位置關係
	// COLINE -- 共線
	// PARALLEL -- 平行
	// CROSS -- 相交
	public static double[] CalCrossPoint(int L1P1X, int L1P1Y, int L1P2X, int L1P2Y, int L2P1X, int L2P1Y, int L2P2X, int L2P2Y)
	{
		double A1, B1, C1, A2, B2, C2;
		A1 = L1P2Y - L1P1Y;
		B1 = L1P1X - L1P2X;
		C1 = L1P2X * L1P1Y - L1P1X * L1P2Y;
		A2 = L2P2Y - L2P1Y;
		B2 = L2P1X - L2P2X;
		C2 = L2P2X * L2P1Y - L2P1X * L2P2Y;
		if (EQ(A1 * B2, B1 * A2)) 
		{
			if (EQ( (A1 + B1) * C2, (A2 + B2) * C1 )) 
			{
				// COLINE -- 共線
				return null;
			}
			else
			{
				// PARALLEL -- 平行
				return null;
			}
		}
		else 
		{
			// CROSS -- 相交
			double[] P = new double[2];
			P[0] = (B2 * C1 - B1 * C2) / (A2 * B1 - A1 * B2);
			P[1] = (A1 * C2 - A2 * C1) / (A2 * B1 - A1 * B2);
			if(between(P[0], L1P1X, L1P2X) && between(P[0], L2P1X, L2P2X) &&
					between(P[1], L1P1Y, L1P2Y) && between(P[1], L2P1Y, L2P2Y))
				return P;
			else
				return null;
		}
	}
	public static boolean EQ(double x, double y) // eqaul, x == y
	{
		double EPS = 1e-5; // 計算精度
		return (Math.abs(x - y) < EPS);
	}
	public static boolean between(double n, double r1, double r2)
	{
		if(r1 > r2)
		{double tmp=r1; r1=r2; r2=tmp;}
		if(n>=r1 && n<=r2)
			return true;
		return false;
	}
}
