package tpBlackJack;

@SuppressWarnings("serial")
public class EmptyDeckException extends Exception 
{
	private String mes;
	public EmptyDeckException(String message)
	{
		mes = message;
		System.out.println(mes);
	}
	public String getMessage()
	{
		return mes;
	}
}
