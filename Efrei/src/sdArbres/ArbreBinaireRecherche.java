package sdArbres;

public class ArbreBinaireRecherche 
{
	
	public void ajouterNoeudreccursif(Noeud arb, int val)
	{
		if (arb == null)
			arb = new Noeud (val);
		else
		{
			if (val>arb.getval() && arb.getjilsd()==null)
			{
				arb.setfilsd(new Noeud(val));
			}
			else if (val>arb.getval() && arb.getjilsd()!=null)
			{
				ajouterNoeudreccursif (arb.getjilsd(), val);
			}
		
			if (val<arb.getval() && arb.getjilsg()==null)
			{
				arb.setfilsd(new Noeud(val));
			}
			else if (val<arb.getval() && arb.getjilsg()!=null)
			{
				ajouterNoeudreccursif (arb.getjilsg(), val);
			}
		}
	}
	
	public void ajouterNoeudIteratif(Noeud arb, int val)
	{
		if (arb == null)
			arb = new Noeud (val);
		else
		{
			while (arb != null)
			{
				if (val > arb.getval() && arb.getjilsd()==null)
					arb.setfilsd(new Noeud(val));
				else if (val > arb.getval() && arb.getjilsd()!=null)
					arb = arb.getjilsd();
				if (val < arb.getval() && arb.getjilsg()==null)
					arb.setfilsg(new Noeud(val));
				else if (val < arb.getval() && arb.getjilsg()!=null)
					arb = arb.getjilsg();
			}
		}
	}
	
	public boolean rechercherValreccursif(Noeud arb, int val)
	{
		if (val == arb.getval())
		{
			return true;
		}
		else if (val>arb.getval() && arb.getjilsd()!=null)
		{
			return rechercherValreccursif(arb.getjilsd(), val);
		}
		else if (val<arb.getval() && arb.getjilsg()!=null)
		{
			return rechercherValreccursif(arb.getjilsg(), val);
		}
		return false;
	}
	
	public boolean rechercherValiteratif(Noeud arb, int val)
	{
		if (arb == null)
			return false;
		if (val == arb.getval())
		{
			return true;
		}
		while (arb != null)
		{
			if (val>arb.getval() && arb.getjilsd()!=null)
			{
				arb = arb.getjilsd();
			}
			else if (val<arb.getval() && arb.getjilsg()!=null)
			{
				arb = arb.getjilsg();
			}
			if (val == arb.getval())
			{
				return true;
			}
		}
		
		return false;
	}
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}

}
