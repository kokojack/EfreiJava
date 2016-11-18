//package tpBlackJack;
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.FileNotFoundException;
//
//import javax.swing.JButton;
//import javax.swing.JOptionPane;
//
//public class GUI implements ActionListener {
//	
//	public GUI()
//	{
//		JButton button1 = new JButton("Bouton1"); 
//		button1.setActionCommand("key1"); button1.addActionListener(this); 
//		JButton button2 = new JButton("Bouton2"); 
//		button2.setActionCommand("key2"); button2.addActionListener(this);
//		JButton button3 = new JButton("Bouton2"); 
//		button3.setActionCommand("key3"); button2.addActionListener(this);
//
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) 
//	{
//		switch(e.getActionCommand()) 
//		{ // Valid since Java 1.7 
//		case "key1": /* do something */ 
//			try 
//			{
//				bj.playerDrawAnotherCard();
//				updatePlayerPanel();
//			} 
//			catch (EmptyDeckException | FileNotFoundException ex) 
//			{
//				JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); 
//				System.exit(-1); 
//			} 
//			break; 
//		case "key2": /* do something */ 
//			
//			break;
//		case "key3": /* do something */ 
//			
//			break;
//		}
//	}
//
//}
