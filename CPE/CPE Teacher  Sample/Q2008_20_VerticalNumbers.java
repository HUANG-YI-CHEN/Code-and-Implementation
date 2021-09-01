import java.util.Scanner;


public class Q2008_20_VerticalNumbers 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int cs = scn.nextInt();
		for(int c=1; c<=cs; c++)
		{
			System.out.println("Case "+c+":");
			String ta = scn.next();
			String da = scn.next();
			if(ta.compareTo("long") == 0)
			{
				int dal = da.length();
				for(int i=0; i<8-dal; i++)
					da = "0"+da;
			}
			else if(ta.compareTo("short") == 0)
			{
				int dal = da.length();
				for(int i=0; i<4-dal; i++)
					da = "0"+da;
			}
			String tb = scn.next();
			String db = scn.next();
			if(tb.compareTo("long") == 0)
			{
				int dbl = db.length();
				for(int i=0; i<8-dbl; i++)
					db = "0"+db;
			}
			else if(tb.compareTo("short") == 0)
			{
				int dbl = db.length();
				for(int i=0; i<4-dbl; i++)
					db = "0"+db;
			}
			int b = scn.nextInt();
			if(b == 2)
			{
				String nda = "";
				for(int i=0; i<da.length(); i++)
				{
 					     if(da.charAt(i) == '0') nda += "0000";
					else if(da.charAt(i) == '1') nda += "0001";
					else if(da.charAt(i) == '2') nda += "0010";
					else if(da.charAt(i) == '3') nda += "0011";
					else if(da.charAt(i) == '4') nda += "0100";
					else if(da.charAt(i) == '5') nda += "0101";
					else if(da.charAt(i) == '6') nda += "0110";
					else if(da.charAt(i) == '7') nda += "0111";
					else if(da.charAt(i) == '8') nda += "1000";
					else if(da.charAt(i) == '9') nda += "1001";
					else if(da.charAt(i) == 'a') nda += "1010";
					else if(da.charAt(i) == 'b') nda += "1011";
					else if(da.charAt(i) == 'c') nda += "1100";
					else if(da.charAt(i) == 'd') nda += "1101";
					else if(da.charAt(i) == 'e') nda += "1110";
					else if(da.charAt(i) == 'f') nda += "1111";
				}
				da = nda;
				String ndb = "";
				for(int i=0; i<db.length(); i++)
				{
 					     if(db.charAt(i) == '0') ndb += "0000";
					else if(db.charAt(i) == '1') ndb += "0001";
					else if(db.charAt(i) == '2') ndb += "0010";
					else if(db.charAt(i) == '3') ndb += "0011";
					else if(db.charAt(i) == '4') ndb += "0100";
					else if(db.charAt(i) == '5') ndb += "0101";
					else if(db.charAt(i) == '6') ndb += "0110";
					else if(db.charAt(i) == '7') ndb += "0111";
					else if(db.charAt(i) == '8') ndb += "1000";
					else if(db.charAt(i) == '9') ndb += "1001";
					else if(db.charAt(i) == 'a') ndb += "1010";
					else if(db.charAt(i) == 'b') ndb += "1011";
					else if(db.charAt(i) == 'c') ndb += "1100";
					else if(db.charAt(i) == 'd') ndb += "1101";
					else if(db.charAt(i) == 'e') ndb += "1110";
					else if(db.charAt(i) == 'f') ndb += "1111";
				}
				db = ndb;
			}
			//System.out.println(da+"\n"+db);
			String align = scn.next();	
			if(align.compareTo("true") == 0)
			{
				if(da.length() == db.length())
					for(int i=0; i<da.length(); i++)
						System.out.println(da.charAt(i)+""+db.charAt(i));					
				else if(da.length() > db.length())
				{
					for(int i=0; i<db.length(); i++)
						System.out.println(da.charAt(i)+""+db.charAt(i));
					for(int i=db.length(); i<da.length(); i++)
						System.out.println(da.charAt(i));					
				}
				else if(da.length() < db.length())
				{
					for(int i=0; i<da.length(); i++)
						System.out.println(da.charAt(i)+""+db.charAt(i));
					for(int i=da.length(); i<db.length(); i++)
						System.out.println(" "+db.charAt(i));					
				}
			}
			else if(align.compareTo("false") == 0)
			{
				if(da.length() == db.length())
					for(int i=0; i<da.length(); i++)
						System.out.println(da.charAt(i)+""+db.charAt(i));					
				else if(da.length() > db.length())
				{
					for(int i=0; i<db.length(); i++)
						System.out.println(da.charAt(i));
					for(int i=db.length(); i<da.length(); i++)
						System.out.println(da.charAt(i)+""+db.charAt(i-db.length()));					
				}
				else if(da.length() < db.length())
				{
					for(int i=0; i<da.length(); i++)
						System.out.println(" "+db.charAt(i));
					for(int i=da.length(); i<db.length(); i++)
						System.out.println(da.charAt(i-da.length())+""+db.charAt(i));					
				}
				
			}
		}
	}

}
