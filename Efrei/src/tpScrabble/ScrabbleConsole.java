package tpScrabble;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ScrabbleConsole 
{
	
	private Dictionnary dico;

	public ScrabbleConsole()
	{
		System.out.println("\t\tWELCOME TO THE SCRABBLE ASSISTANT!");
		//Dictionnary dico = new Dictionnary();
		try
		{
			dico = new Dictionnary("./ListeMots/Dico");
			System.out.println(dico.getWordsList().length()+"words loaded. From ADSL to oeuvée");
		}
		catch (FileNotFoundException ex)
		{
			System.err.println(ex.getMessage());
			System.exit(-1);
		}
	}
	
	public static void main(String[] args) 
	{
		ScrabbleConsole sce = new ScrabbleConsole();
		char [] lettres = new char[7];
		
		Scanner sc = new Scanner(System.in);
		System.out.println("please enter a word");
		String word = sc.nextLine();
		Scanner sc1 = new Scanner(System.in);
		System.out.println("please a letter list");
		String letters = sc1.nextLine();
		for (int i = 0; i < 7; i++)
		{
			lettres[i] = (letters.charAt(i));
		}
		if (sce.dico.mayBeComposed(word,lettres))
		{
			System.out.println(word +"may be composed by with letters"+lettres[0]+", "+lettres[1]+", "+lettres[2]+", "+lettres[3]+", "+lettres[4]+", "+lettres[5]+", "+lettres[6]);
		}
		else
			System.out.println("Impossible");
	}

}
