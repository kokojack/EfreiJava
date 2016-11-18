package testExpression;

import java.time.chrono.IsoChronology;

public class Expression {
	
	public static boolean estFacteur(char chF[])
	{
		boolean repF = true;
		if (chF.length>1)
		{
			if (chF[0] != '(' || chF[chF.length-1] != ')')
			{
				repF = false;
			}
			else
			{
				char ch2[] = null;
				int j = 0;
				for (int i = 1; i<chF.length-1; i++)
				{
					ch2[j] = chF[i];
					j++;
				}
				if (!estExpression(ch2))
				{
					repF = false;
				}
			}
			return repF;
		}
		return repF;
	}
		
		public static boolean estTerme(char chT[])
		{
			boolean repT = true;
			boolean etoile = false;
			int ind = -1;
			if (chT.length > 1)
			{
				for (int i = 0; i<chT.length; i++)
				{
					if (chT[i] == '*')
					{
						etoile = true;
						ind = i;
						i = chT.length-1;
					}
				}
				if (!etoile && !(estFacteur(chT)))
				{
					repT = false;
				}
				else if(etoile)
				{
					char T1 [] = null;
					char T2 [] = null;
					int j = 0;
				
					for (int i = 0; i < ind; i++)
					{
						T1[i] = chT[i];
					}
				
					for (int i= ind+1; i < chT.length; i++)
					{
						T2[j] = chT[i];
					}
					
				
					if (!estFacteur(T1) && !estFacteur(T2))
					{
					repT = false;
					}
				}
			}
			return repT;
		}
		
		public static boolean estExpression(char chE[])
		{
			boolean repE = true;
			boolean plus = false;
			int ind = -1;
			int taille = chE.length;
			for (int i = 0; i<chE.length; i++)
			{
				if (chE[i] == '+')
				{
					plus = true;
					ind = i;
					i = chE.length-1;
				}
			}
			if (!plus && !( estTerme(chE) ) )
			{
				repE = false;
			}
			else if(plus)
			{
				char T1 [] = new char[ind];
				char T2 [] = new char[taille-ind];
				int j = 0;
				if (ind == 1)
				{
					T1[0] = chE[0];
				}
				else
				{
					for (int i = 0; i < ind; i++)
					{
						T1[j] = chE[i];
					}
				}
				if (ind == chE.length-1)
				{
					T2[0] = chE[chE.length-1];
				}
				else
				{
					for (int i= ind+1; i < chE.length; i++)
					{
						T2[j] = chE[i];
					}
				}
				
				
				if (T1 != null && T2 != null)
				{
					if (!estFacteur(T1) && !estFacteur(T2))
					{
						repE = false;
					}
				}
				
			}
			return repE;
		}
		
		

	public static void main(String[] args) 
	{
		char chaine[] = new char[9];
		chaine[0] = 'a';
		chaine[1] = '+' ;
		chaine[2] = 'b';
		chaine[3] ='+';
		chaine[4] = '(';
		chaine[5] = 'c';
		chaine[6] = '*';
		chaine[7] = 'd';
		chaine[8] = ')';
		
		if (estExpression(chaine))
		{
			System.out.println("L'expression est bien une expression algébrique");
		}
		else
		{
			System.out.println("L'expression n'est pas une expression algébrique");
		}
	}
}
