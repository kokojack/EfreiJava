package tpBlackJack;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.*;

public class BlackJackGUI 
{
	JPanel bankPanel;
	JPanel playerPanel;
	BlackJack bj;
	JFrame frame;
	public BlackJackGUI() throws FileNotFoundException
	{
		bj = new BlackJack();
		frame= new JFrame( ); 
			frame.setMinimumSize(new Dimension(640,480)); 
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.pack();
			frame.setVisible(true);
			frame.setTitle("BlackJackGUI");
			BorderLayout bl = new BorderLayout();
			frame.getContentPane().setLayout(bl);
			frame.setLocationRelativeTo(null);
		
		
		
		JPanel topPanel = new JPanel(new FlowLayout());
				JButton button1 = new JButton("Another Card");
				button1.addActionListener(new ActionListener() {
				
					@Override
					public void actionPerformed(ActionEvent e) {
					
						try 
						{
							if(!bj.isGameFinished(bj.getRep()))
							{
								bj.playerDrawAnotherCard();
								updatePlayerPanel();
							}
							else
							{
								button1.setEnabled(false);
								JOptionPane.showMessageDialog(null, "Votre score depasse 21! Vous ne pouvez plus tirer de cartes", "Error", JOptionPane.ERROR_MESSAGE);
							}
						} 
						catch (EmptyDeckException | FileNotFoundException ex) 
						{
							JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); 
							System.exit(-1); 
						} 
					}
			});
				
			JButton button2 = new JButton("No more Card");
			button2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					button1.setEnabled(false);
					button2.setEnabled(false);
					try 
					{
						bj.bankLastTurn();
						updateBankPanel();
					} 
					catch (EmptyDeckException | FileNotFoundException ex) 
					{
						JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); 
						System.exit(-1); 
					}
					
					bj.isGameFinished("y");
					if (bj.isBankWinner())
						bankPanel.add(new JLabel("\nBank Won"));
					else if (bj.isPlayerWinner())
						playerPanel.add(new JLabel("\nYou Won"));
					else
					{
						playerPanel.add(new JLabel("\nDRAW"));
						bankPanel.add(new JLabel("\nDRAW"));
					}
					
				}
			}) ;
			
			JButton button3 = new JButton("Reset");
			button3.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try 
					{
						//frame.setVisible(false);
						frame.dispose();
						new BlackJackGUI();
					} 
					catch (FileNotFoundException ex)
					{
						ex.printStackTrace();
					}
				}
			});
			topPanel.add(button1);
			topPanel.add(button2);
			topPanel.add(button3);
		
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(2,0));
				bankPanel = new JPanel();
				bankPanel.setBorder(BorderFactory.createTitledBorder("Bank"));
				for (Card c : bj.getBankCardList())
				{
					addToPanel(bankPanel, c.getcolorName()+"_"+c.getvalueymbol());
				}
				bankPanel.add(new JLabel("Bank Best: "+bj.getBankBest()));
			    playerPanel = new JPanel();
				playerPanel.setBorder(BorderFactory.createTitledBorder("You"));
				for (Card c : bj.getPlayerCardList())
				{
					addToPanel(playerPanel, c.getcolorName()+"_"+c.getvalueymbol());
				}
				playerPanel.add(new JLabel("You Best: "+bj.getPlayerBest()));
		centerPanel.add(bankPanel);
		centerPanel.add(playerPanel);
		
//		try
//		{ 
//			addToPanel(playerPanel, "club_j"); 
//			} 
//		catch(FileNotFoundException ex) 
//		{ 
//			System.out.println(ex.getMessage()); 
//		}

		frame.add(topPanel, BorderLayout.NORTH);
		frame.add(centerPanel, BorderLayout.CENTER);
		frame.pack();
	}
	
	public void updateBankPanel() throws FileNotFoundException
	 {
		bankPanel.removeAll();
		for(Card c : bj.getBankCardList())
		{
			addToPanel(bankPanel, c.getcolorName()+"_"+c.getvalueymbol());
		}
		bankPanel.add(new JLabel("Bank Best: "+bj.getBankBest()));
		bankPanel.updateUI();
	 }
	
	public void updatePlayerPanel() throws FileNotFoundException
	 {
		
		playerPanel.removeAll();
		for(Card c : bj.getPlayerCardList())
		{
			addToPanel(playerPanel, c.getcolorName()+"_"+c.getvalueymbol()); 
		}
		playerPanel.add(new JLabel("You Best: "+bj.getPlayerBest()));
		playerPanel.updateUI();
	 }
	
	public void addToPanel(JPanel p, String token) throws FileNotFoundException 
	{
		File file = new File("./src/tpBlackJack/img/card_"+token+".gif");
		if (!file.exists()) 
		{ 
			//throw new FileNotFoundException("Can't find "+file.getPath()); 
			throw new FileNotFoundException("Can't find "+file.getPath());
		} 
		ImageIcon icon = new ImageIcon(file.getPath()); 
		JLabel label = new JLabel(icon); 
		p.add(label);

	}
	
	 
	
	public static void main(String agrs[]) throws FileNotFoundException
	{
		new BlackJackGUI();
	}
}
