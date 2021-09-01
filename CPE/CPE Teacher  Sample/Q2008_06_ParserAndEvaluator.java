import java.util.ArrayList;
import java.util.Scanner;


public class Q2008_06_ParserAndEvaluator 
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
			String str = scn.nextLine();
			//System.out.println(E(str.trim()));
			System.out.println("case "+cs+":");
			if(E(str.trim()))
				System.out.println(calculate(new StringBuffer(str.trim())));
			else
				System.out.println("syntactically incorrect");
			System.out.println();
			cs++;
		}
	}
	public static int calculate(StringBuffer str)
	{
		//處理最後一個括號內的運算式，並將結果取代原字串，直到完全無括號為止
		int idx1 = 0;
		while((idx1=str.lastIndexOf("(")) >= 0)
		{			
			int idx2 = str.indexOf(")", idx1);
			int ans = value(new StringBuffer(str.substring(idx1+1, idx2)));
			str.replace(idx1, idx2+1, Integer.toString(ans));
		}

		return value(str);
	}
	public static int value(StringBuffer str)
	{
		//拆解運算子與運算元
		ArrayList<Character> op = new ArrayList<Character>();
		ArrayList<Integer> num = new ArrayList<Integer>();
		int idx1 = 0;
		for(int i=1; i<str.length(); i++)
			if(str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*' || str.charAt(i) == '/' || str.charAt(i) == '%')
			{
				op.add(str.charAt(i));
				num.add(Integer.parseInt(str.substring(idx1, i)));
				idx1 = ++i;
			}
		num.add(Integer.parseInt(str.substring(idx1)));
		
		//進行運算，先判斷乘除，再判斷加減
		for(int i=0; i<op.size(); i++)
			if(op.get(i) == '%')
			{
				num.set(i+1, num.get(i)%num.get(i+1));
				op.remove(i);
				num.remove(i--);
			}
		for(int i=0; i<op.size(); i++)
			if(op.get(i) == '*' || op.get(i) == '/')
			{
				num.set(i+1, op.get(i)=='*' ? num.get(i)*num.get(i+1) : num.get(i)/num.get(i+1));
				op.remove(i);
				num.remove(i--);
			}
		for(int i=0; i<op.size(); i++)
//			if(op.get(i) == '+' || op.get(i) == '-')
			{
				num.set(i+1, op.get(i)=='+' ? num.get(i)+num.get(i+1) : num.get(i)-num.get(i+1));
				op.remove(i);
				num.remove(i--);
			}
		
		return num.get(0);
	}
	
	public static boolean E(String str)
	{
		for(int i=1; i<str.length()-1; i++)
			if(str.charAt(i) == '+' && T(str.substring(0, i)) && E(str.substring(i+1)))
				return true;
		for(int i=str.length()-2; i>=1; i--)
			if(str.charAt(i) == '-' && T(str.substring(0, i)) && E(str.substring(i+1)))
				return true;
		
		return T(str);
	}
	public static boolean T(String str)
	{
		for(int i=str.length()-2; i>=1; i--)
			if(str.charAt(i) == '*' && F(str.substring(0, i)) && T(str.substring(i+1)))
				return true;
		for(int i=str.length()-2; i>=1; i--)
			if(str.charAt(i) == '/' && F(str.substring(0, i)) && T(str.substring(i+1)))
				return true;
		for(int i=1; i<str.length()-1; i++)
			if(str.charAt(i) == '%' && F(str.substring(0, i)) && T(str.substring(i+1)))
				return true;
		return F(str);
	}
	public static boolean F(String str)
	{
		boolean B = false, N = false, P = false;
		if(str.length() > 2 && str.charAt(0) == '(' && str.charAt(str.length()-1) == ')' && E(str.substring(1, str.length()-1)))
			return true;
		else if(str.length() > 1 && str.charAt(0) == '-' && F(str.substring(1)))
			return true;
		else if(str.length() > 1 && str.charAt(0) == '+' && F(str.substring(1)))
			return true;
		return N(str);		
	}
	public static boolean N(String str)
	{
		if(str.length() == 0)
			return false;
		else if(str.length() == 1 && D(str))
			return true;
		return D(str.substring(0, 1)) && N(str.substring(1));
	}
	public static boolean D(String str)
	{
		if(str.charAt(0) >= '0' && str.charAt(0) <= '9')
			return true;
		else
			return false;
	}
}
