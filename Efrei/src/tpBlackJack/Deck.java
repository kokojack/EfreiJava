package tpBlackJack;

import java.util.Collections;
import java.util.LinkedList;


public class Deck 
{
	private LinkedList <Card> cardList = new LinkedList<Card>();
	int nbBox;
	public 	Deck(int nbBox)
	{
		this.nbBox = nbBox;
		Color[] colorArray = Color.values();
		Value[] valueArray = Value.values();
		for (int nb=0; nb<nbBox; nb++)
		{
			for (int i=0; i < colorArray.length; i++ )
			{
				for (int j=0; j<valueArray.length; j++)
				{
					cardList.add(new Card(valueArray[j], colorArray[i]));
				}
			}
		}
	}
	
	public void melange()
	{
		Collections.shuffle(cardList);
		Collections.reverse(cardList);
	}
	public String toString()
	{
		String ch;
		int i =0;
		ch="[";
		for (Card c : cardList)
		{
			if (i%13 == 0)
				ch = ch+"\n";
			ch = ch+" "+c;
			i++;
		}
		ch = ch+"]";
		
		return ch;
	}
	public Card draw ()throws EmptyDeckException
	{
		melange();
		return cardList.pollFirst();
	}
	
	
}
