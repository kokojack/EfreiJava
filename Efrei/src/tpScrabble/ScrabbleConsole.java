package tpScrabble;

import java.util.Arrays;

public class ScrabbleConsole 
{
	
	public ScrabbleConsole()
	{
		System.out.println("\t\tWELCOME TO THE SCRABBLE ASSISTANT!");
		Dictionnary dico = new Dictionnary();
		System.out.println(dico.getWordsList());
	}
	
	public static void main(String[] args) 
	{
		ScrabbleConsole Sc = new ScrabbleConsole();
	}

}
