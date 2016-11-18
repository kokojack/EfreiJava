package tpBlackJack;

public enum Color 
{
	

	heart("♥") ,
	spade("♠"),
	diamond("⋄"),
	club("♣");
	
	private String symbol;
	
	
	Color (String symbol)
	{
		this.symbol = symbol;
	}
	
	public String getsymbol()
	{
		return symbol;
	}
	
	
}
