import java.util.Scanner;
import java.util.Vector;


public class Q23641_MutantFlatworldExplorers
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int maxX = scn.nextInt();
		int maxY = scn.nextInt();
		Vector<Integer> outRec = new Vector<Integer>();
		while(scn.hasNext())
		{
			int cx = scn.nextInt();
			int cy = scn.nextInt();
			String face = scn.next();
			int f = 0;
			if(face.compareTo("E") == 0)
				f = 0;
			else if(face.compareTo("S") == 0)
				f = 1;
			else if(face.compareTo("W") == 0)
				f = 2;
			else if(face.compareTo("N") == 0)
				f = 3;
			String cmd = scn.next();
			boolean out = false;
			for(int i=0; i<cmd.length(); i++)
			{
				if(cmd.charAt(i) == 'F')
				{
					if(f == 0)
					{
						if(cx == maxX && !outRec.contains(cy*100+cx+1))
						{
							outRec.add(cy*100+cx+1);
							cx++;
							out = true;
						}
						else if(cx < maxX)
							cx++;
					}
					else if(f == 1)
					{
						if(cy == 0 && !outRec.contains((cy-1)*100+cx))
						{
							outRec.add((cy-1)*100+cx);
							cy--;
							out = true;
						}
						else if(cy > 0)
							cy--;
					}
					else if(f == 2)
					{
						if(cx == 0 && !outRec.contains(cy*100+cx-1))
						{
							outRec.add(cy*100+cx-1);
							cx--;
							out = true;
						}
						else if(cx > 0)
							cx--;
					}
					else if(f == 3)
					{
						if(cy == maxY && !outRec.contains((cy+1)*100+cx))
						{
							outRec.add((cy+1)*100+cx);
							cy++;
							out = true;
						}
						else if(cy < maxY)
							cy++;
					}
				}
				else if(cmd.charAt(i) == 'R')
				{
					f = (f+1)%4;
				}
				else if(cmd.charAt(i) == 'L')
				{
					f = (f+3)%4;
				}				
			}
			System.out.print(cx+" "+cy+" ");
			if(f == 0)
				System.out.print("E");
			else if(f == 1)
				System.out.print("S");
			else if(f == 2)
				System.out.print("W");
			else if(f == 3)
				System.out.print("N");
			if(out)
				System.out.print(" LOST");
			System.out.println();
		}
	}

}
