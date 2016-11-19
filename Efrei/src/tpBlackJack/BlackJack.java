package tpBlackJack;

import java.util.LinkedList;
import java.util.List;

public class BlackJack 
{
	private Deck deck;
	private Hand playerHand;
	private Hand bankHand;
	private String rep ;
	
	
	public BlackJack()
	{
		deck = new Deck(4);
		playerHand = new Hand();
		bankHand = new Hand();
		rep = "n";
		try 
		{
			reset();
		} 
		catch (Exception e) {
			e = new EmptyDeckException("Error, the  deck has insufisient card!!");
		}
		
	}
	
	public boolean isGameFinished(String r)
	{
		return (getPlayerBest()>21 || r == "y");
	}
	
	public void reset() throws EmptyDeckException
	{
		playerHand.clear();
		playerHand.add(deck.draw());
		playerHand.add(deck.draw());
		
		deck.melange();
		
		bankHand.clear();
		bankHand.add(deck.draw());
	}
	
	public String getPlayerHandString()
	{
		return playerHand.toString();
	}
	
	public String getBankHandString()
	{
		return bankHand.toString();
	}
	
	public int getPlayerBest()
	{
		return playerHand.best();
	}
	
	public int getBankBest()
	{
		return bankHand.best();
	}
	
	public boolean isPlayerWinner()
	{
		boolean b = false;
		if (getPlayerBest()==21 && getBankBest()!=21)
			b = true;
		if (getBankBest()>21 && getPlayerBest()<21)
			b = true;
		if (getBankBest()<=21 && getPlayerBest() <=21 && getPlayerBest()>getBankBest())
			b = true;
		if (getPlayerBest()>21 && getBankBest()>21 && getPlayerBest()<getBankBest())
			b = true;
		return b;
	}
	
	public boolean isBankWinner()
	{
		boolean b = false;
		if (getBankBest()==21 && getPlayerBest()!=21)
			b = true;
		if (getPlayerBest()>21 && getBankBest()<21)
			b = true;
		if (getPlayerBest()<=21 && getBankBest() <=21 && getBankBest()>getPlayerBest())
			b = true;
		if (getBankBest()>21 && getPlayerBest()>21 && getBankBest()<getPlayerBest())
			b = true;
		return b;
	}
	
	public void playerDrawAnotherCard() throws EmptyDeckException
	{
		if (!isGameFinished(rep))
			playerHand.add(deck.draw());
		else
			System.out.println("Game finished!!");
		if (getPlayerBest()>21)
		{
			rep = "n";
		}
			
	}
	
	public void bankLastTurn() throws EmptyDeckException
	{
		deck.melange();
		bankHand.add(deck.draw());
		deck.melange();
		bankHand.add(deck.draw());
		deck.melange();
	}
	 public List<Card> getPlayerCardList() 
	 {
		 LinkedList<Card> copyList = new LinkedList<Card>(playerHand.getCardList()); 
		 return copyList;
	 }
	 
	 public List<Card> getBankCardList() 
	 {
		 LinkedList<Card> copyList = new LinkedList<Card>(bankHand.getCardList()); 
		 return copyList;
	 }
	 
	 public String getRep()
	 {
		 return rep;
	 }
}
