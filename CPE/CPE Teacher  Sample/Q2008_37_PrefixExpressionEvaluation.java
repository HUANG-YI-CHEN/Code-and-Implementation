import java.util.ArrayList;
import java.util.Scanner;


public class Q2008_37_PrefixExpressionEvaluation
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
			String str = scn.nextLine();
			if(str.compareTo(".") == 0)
				break;
			String[] tmp = str.split(" ");
			ArrayList<String> dat = new ArrayList<String>();
			for(int i=0; i<tmp.length; i++)
				dat.add(tmp[i]);
			while(true)
			{
				boolean find = false;
				for(int i=dat.size()-1; i>=0; i--)
				{
					if(dat.get(i).compareTo("+") == 0 && i+2 < dat.size())
					{
						try
						{
							int n1 = Integer.parseInt(dat.get(i+1));
							int n2 = Integer.parseInt(dat.get(i+2));
							dat.set(i, (n1+n2)+"");
							dat.remove(i+2);
							dat.remove(i+1);
							find = true;
							break;
						}
						catch(Exception e)
						{							
						}
					}
					else if(dat.get(i).compareTo("-") == 0 && i+2 < dat.size())
					{
						try
						{
							int n1 = Integer.parseInt(dat.get(i+1));
							int n2 = Integer.parseInt(dat.get(i+2));
							dat.set(i, (n1-n2)+"");
							dat.remove(i+2);
							dat.remove(i+1);
							find = true;
							break;
						}
						catch(Exception e)
						{							
						}
					}
					else if(dat.get(i).compareTo("*") == 0 && i+2 < dat.size())
					{
						try
						{
							int n1 = Integer.parseInt(dat.get(i+1));
							int n2 = Integer.parseInt(dat.get(i+2));
							dat.set(i, (n1*n2)+"");
							dat.remove(i+2);
							dat.remove(i+1);
							find = true;
							break;
						}
						catch(Exception e)
						{							
						}
					}
					else if(dat.get(i).compareTo("/") == 0 && i+2 < dat.size())
					{
						try
						{
							int n1 = Integer.parseInt(dat.get(i+1));
							int n2 = Integer.parseInt(dat.get(i+2));
							dat.set(i, (n1/n2)+"");
							dat.remove(i+2);
							dat.remove(i+1);
							find = true;
							break;
						}
						catch(Exception e)
						{							
						}
					}
					else if(dat.get(i).compareTo("%") == 0 && i+2 < dat.size())
					{
						try
						{
							int n1 = Integer.parseInt(dat.get(i+1));
							int n2 = Integer.parseInt(dat.get(i+2));
							dat.set(i, (n1%n2)+"");
							dat.remove(i+2);
							dat.remove(i+1);
							find = true;
							break;
						}
						catch(Exception e)
						{							
						}
					}
				}
				//System.out.println(dat);
				if(!find)
					break;
			}
			if(dat.size() == 1)
			{
				try
				{
					int n1 = Integer.parseInt(dat.get(0));
					System.out.println(n1);
				}
				catch(Exception e)
				{
					System.out.println("illegal");
				}
			}
			else
			{
				System.out.println("illegal");
			}
		}
	}

}
