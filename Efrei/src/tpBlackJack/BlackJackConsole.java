package tpBlackJack;

import java.util.Scanner;

public class BlackJackConsole 
{
	public BlackJackConsole()
	{
		System.out.println("Welcome to the Black Jack. Let's play!");
		
		Deck deck = new Deck(2);
		System.out.println("Here is the deck" +deck+ "\n");
		for (int i = 0; i< 2; i++)
		{
			try 
			{
				Card c = deck.draw();
				System.out.println("This card is a "+c+ " worth "+c.getpoint()+ " points");
				if(c.getvalueymbol().matches("[JQK]")) 
				{ // Is the value symbol a J or a Q or a K ? 
					System.out.println(" and a face !"); 
				} 
				else 
				{ 
					System.out.println(" and it's not a face."); 
				}
			}
			catch (EmptyDeckException ex)
			{
				System.err.println(ex.getMessage()); 
				System.exit(-1);
			}
		}
		
		Hand hand = new Hand(); 
		System.out.println("Your hand is currently : "+hand); 
		for(int i=0; i < 3 ; i++) 
		{ 
			try 
			{ 
				hand.add(deck.draw()); 
			} 
			catch (EmptyDeckException ex) 
			{
				System.err.println(ex.getMessage());
				System.exit(-1); 
			}
		}
		System.out.println( "Your hand is currently: " +hand);
		hand.clear(); 
		System.out.println( "Your hand is currently: " +hand);


//		// This is an array of two cards 
//		Card[] tab = {new Card(Value.TWO, Color.HEART), new Card(Value.JACK, Color.SPADE)};
//		for(Card c : tab) 
//		{ // For each card 
//			System.out.println("This card is a "+c+ " worth "+c.getpoint()+ " points"); 
//			System.out.print("It's a "); 
//			switch(c.getcolorSymbol()) 
//			{ // OK from Java 1.7 
//			case "♥": 
//				System.out.print("heart");
//				break; 
//			case "♠": 
//				System.out.print("spade"); 
//				break; 
//			case "♣": 
//				System.out.print("club"); 
//				break; 
//			case "♦": 
//				System.out.print("diamond"); 
//				break; 
//			}
//			if(c.getvalueymbol().matches("[JQK]")) 
//			{ // Is the value symbol a J or a Q or a K ? 
//				System.out.println(" and a face !"); 
//			} 
//			else 
//			{ 
//				System.out.println(" and it's not a face."); 
//			}
//		}

	}

	public static void main(String[] args) throws EmptyDeckException 
	{
		//BlackJackConsole B = new BlackJackConsole();
		
		BlackJack Bj = new BlackJack();
		System.out.println("\t\t Welcome to BlackJack table, Let's play");
		
		System.out.println("\nThe Bank draw : "+Bj.getBankHandString()+"\t");
		System.out.println("\nYour draw : "+Bj.getPlayerHandString()+"\t");
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner (System.in);
		String rep = "y" ;
		 while(rep.matches("y") && Bj.getPlayerBest()<=21)
		 {
			 System.out.println("Do you want another card [ y/n ] ?");
			 rep = sc.nextLine();
			 if (rep.matches("y"))
			 {
				 Bj.playerDrawAnotherCard();
				 System.out.println("Your new Hand"+Bj.getPlayerHandString());
			 }
		 }
		 
		 if (rep.matches("n"))
			 Bj.isGameFinished("n");
		 
		 if (Bj.getPlayerBest() > 21)
		 {
			System.out.println("You can't draw again because your best score is superior than 21"); 
			Bj.isGameFinished("y");
		 }
			
		 
		 Bj.bankLastTurn();
		 
		 System.out.println("\nThe bank draw cards. New hand:"+Bj.getBankHandString()+"\n");
		 System.out.println("Player Best :\t"+Bj.getPlayerBest());
		 System.out.println("Bank Best :\t"+Bj.getBankBest());
		 
		 if (Bj.isBankWinner())
		 {
			 System.out.println("Bank won");
		 } 
		 else if (Bj.isPlayerWinner())
		 {
			 System.out.println("You won");
		 } 
		 else
		 {
			 System.out.println("Draw"); 
		 } 


	}

}
