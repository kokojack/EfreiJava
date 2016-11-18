package tpBlackJack;

public class Card 
{
	private Value v;
	private Color c;
	
	public Card(Value v, Color c)
	{
		this.v = v;
		this.c = c;
	}
	public String toString()
	{
		String ch;
		ch = getvalueymbol()+getcolorSymbol();
/*		if(getvalueymbol().matches("[JQK]")) 
		{ // Is the value symbol a J or a Q or a K ? 
			ch = ch+" and a face !"; 
		} 
		else 
		{ 
			ch = ch+" and it's not a face."; 
		}*/
		return ch;
	}
	public String getcolorSymbol()
	{
		return c.getsymbol();
	}
	public String getcolorName()
	{
		return c.name();
	}
	public String getvalueymbol()
	{
		return v.getsymbol();
	}
	public int getpoint()
	{
		return v.getpoint();
	}
}
