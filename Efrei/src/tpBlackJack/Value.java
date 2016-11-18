package tpBlackJack;

public enum Value 
{
	AS("a",1 ),
	TWO("2",2 ),
	THREE("3", 3),
	FOUR("4",4 ),
	FIVE("5",5 ),
	SIX("6",6 ),
	SEVEN("7",7 ),
	EIGTH("8", 8),
	NINE("9",9 ),
	TEN("10",10 ),
	JACK("j",10),
	QUEEN("q",10),
	KING("k",10);
	
	private String symbol;
	private int point;
	
	Value (String symbol, int point)
	{
		this.symbol = symbol;
		this.point = point;
	}
	
	public String getsymbol()
	{
		return symbol;
	}
	
	public int getpoint()
	{
		return point;
	}
}
