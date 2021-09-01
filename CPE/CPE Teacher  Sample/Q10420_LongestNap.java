import java.util.Scanner;


public class Q10420_LongestNap 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int cs = 1;
		while(scn.hasNext())
		{
			int s = scn.nextInt();
			String[] ft = new String[s];
			String[] tt = new String[s];
			for(int i=0; i<s; i++)
			{
				ft[i] = scn.next();
				tt[i] = scn.next();
				scn.nextLine();
			}
			int nap0 = time2int(ft[0]) - time2int("10:00"); 
			int napn = time2int("18:00") - time2int(tt[s-1]); 
			int maxnap = nap0>napn?nap0:napn;
			String srt = nap0>napn?"10:00":tt[s-1];
			for(int i=1; i<s; i++)
			{
				int nap = time2int(ft[i]) - time2int(tt[i-1]);
				if(nap > maxnap)
				{
					maxnap = nap;
					srt = tt[i-1];
				}
			}
			if(maxnap >= 60)
				System.out.println("Day #"+cs+": the longest nap starts at "+srt+" and will last for "+(maxnap/60)+" hours and "+(maxnap%60)+" minutes.");
			else
				System.out.println("Day #"+cs+": the longest nap starts at "+srt+" and will last for "+maxnap+" minutes.");
			cs++;
		}
	}
	public static int time2int(String str)
	{
		String[] tmp = str.split(":");
		return Integer.parseInt(tmp[0])*60+Integer.parseInt(tmp[1]);
	}
}
