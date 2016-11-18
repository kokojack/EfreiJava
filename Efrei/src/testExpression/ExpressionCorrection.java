package testExpression;

public class ExpressionCorrection {
	
	public static boolean estExpression(char chaine[], int pos)
	{
		boolean rep = true;
		if (!estTerme(chaine, pos))
			rep = false;
		if (pos != chaine.length)
		{
			if (chaine[pos] != '+')
				rep = false;
			pos++;
			if (!estTerme(chaine, pos))
				rep = false;
		}
		return rep;
	}
	
	public static boolean estTerme(char chaine[], int pos)
	{
		boolean rep = true;
		if (!estFacteur(chaine, pos))
			rep = false;
		if (pos != chaine.length)
		{
			if (chaine[pos] != '*')
				rep = false;
			pos++;
			if (!estFacteur(chaine, pos))
				rep = false;
		}
		return rep;
	}
	
	public static boolean estFacteur(char chaine[], int pos)
	{
		boolean rep = true;
		if (chaine.length == 1)
		{
			pos++;
			rep = true;
		}
		if (chaine[pos] != '(')
			rep = false;
		pos++;
		if (!estExpression(chaine, pos))
			rep = false;
		if (chaine[pos] != ')')
			rep = false;
		pos++;
		return rep;	
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
		
		if (estExpression(chaine, 0))
		{
			System.out.println("L'expression est bien une expression algébrique");
		}
		else
		{
			System.out.println("L'expression n'est pas une expression algébrique");
		}
	}

}
