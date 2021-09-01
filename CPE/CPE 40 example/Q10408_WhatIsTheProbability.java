import java.util.Scanner;


public class Q10408_WhatIsTheProbability 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int cs = scn.nextInt();
		while(cs > 0)
		{
			int n = scn.nextInt();
			double p = scn.nextDouble();
			int i = scn.nextInt();
			System.out.printf("%.4f\n", Math.pow(1.0-p, i-1)*p/(1-Math.pow(1.0-p, n)));
			cs--;
		}
	}

}
