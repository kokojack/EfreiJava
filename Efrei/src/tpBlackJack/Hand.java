package tpBlackJack;

import java.util.LinkedList;
import java.util.List;

public class Hand 
{
	private LinkedList<Card>handList=null;
	public Hand()
	{
		handList = new LinkedList<Card>();
	}
	public String toString()
	{
		String ch;
		ch="[";
		for (Card c : handList)
		{
			ch = ch+" "+c;
		}
		ch = ch+"] \t:\t ["+best()+"]";
//		for (int i=0; i<count().size(); i++)
//		{
//			ch += +count().get(i);
//			if (i<count().size()-1)
//			{
//				ch += ",";
//			}
//		}
		//ch = ch+="]\nThe best score is "+best();
		
		return ch;
	}
	public void add (Card c)
	{
		handList.add(c);
	}
	public void clear()
	{
		handList.clear();
	}
	public List<Integer> count()
	{
		LinkedList<Integer>results = new LinkedList<Integer>();
		int nbResult = 1;
		results.add(0);
		for (Card c: handList)
		{
			for (int i=0; i<nbResult; i++)
			{
				results.set(i, results.get(i)+c.getpoint());
			}
				if (c.getpoint() == 1)
				{
					results.add(10 + results.get(nbResult-1));
					nbResult++;
				}
			
		}
		
		return results;
	}
	public int best()
	{
		int bestScore = count().get(0);
		for (int i =1; i<count().size(); i++)
		{
			if (count().get(i) < 21 && (21 - count().get(i) < 21 - bestScore))
				bestScore = count().get(i);
		}
		return bestScore;
	}
	 public List<Card> getCardList() 
	 {
		 LinkedList<Card> copyList = new LinkedList<Card>(handList); 
		 return copyList;
	 }
}
