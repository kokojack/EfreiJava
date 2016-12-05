package sdArbres;

public class Noeud 
{
	private int val;
	private Noeud filsg;
	private Noeud filsd;
	
	public Noeud (int val)
	{
		this.val = val;
		filsg = null;
		filsd = null;
	}
	
	
	public Noeud getjilsg()
	{
		return filsg;
	}
	public void setfilsg(Noeud n)
	{
		this.filsg = n;
	}
	
	public Noeud getjilsd()
	{
		return filsd;
	}
	public void setfilsd(Noeud n)
	{
		this.filsd = n;
	}
	
	public int getval()
	{
		return val;
	}
	public void setval (int val)
	{
		this.val = val;
	}

	
	public static void main (String args[])
	{
		
	}
}
