package tpBlackJack;

@SuppressWarnings("serial")
public class InsufisentDeckException extends Exception 
{
	public InsufisentDeckException(String message)
	{
		System.out.println(message);
	}
}
