import java.util.ArrayList;
import java.util.Scanner;


public class Q10433_AverageSpeed 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		ArrayList<String> in = new ArrayList<String>();
		while(scn.hasNext())
		{
			String str = scn.nextLine();
			//if(str.compareTo("") == 0)
				//break;
			in.add(str);
		}
		String[] time = new String[in.size()];
		int[] speed = new int[in.size()];
		double[] dis = new double[in.size()];
		boolean[] show = new boolean[in.size()];
		int lastSpeed = -1;
		for(int i=0; i<in.size(); i++)
		{
			String[] tmp = in.get(i).split(" ");
			time[i] = tmp[0];
			if(tmp.length == 1)
			{
				speed[i] = lastSpeed;
				dis[i] = 0;
				show[i] = true;
			}
			else
			{
				speed[i] = Integer.parseInt(tmp[1]);
				lastSpeed = speed[i];
				dis[i] = 0;
				show[i] = false;
			}
		}
		int lastIdx = 0;
		for(int i=in.size()-1; i>=0; i--)
			if(show[i])
			{
				lastIdx = i;
				break;
			}
		double sum = 0;
		for(int i=1; i<in.size(); i++)
		{
			double st = time2hour(time[i-1]);
			double et = time2hour(time[i]);
			dis[i] = dis[i-1]+(et-st)*(double)speed[i-1];
			if(show[i])
			{
				System.out.print(time[i]+" ");
				System.out.printf("%.2f km", dis[i]);
				if(i != lastIdx)
					System.out.println();
			}
		}
		
	}
	public static double time2hour(String time)
	{
		String[] tmp = time.split(":");
		int sec = Integer.parseInt(tmp[0])*60*60+Integer.parseInt(tmp[1])*60+Integer.parseInt(tmp[2]);
		return (double)sec/60.0/60.0;
	}
}
