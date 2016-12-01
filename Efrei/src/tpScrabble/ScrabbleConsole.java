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
		
		Scanner sc = new Scanner(System.in);
		System.out.println("please enter a word");
		String word = sc.nextLine();
		Scanner sc1 = new Scanner(System.in);
		System.out.println("please a letter list");
		char[] letters = sc1.nextLine().toCharArray();
		if (sce.dico.mayBeComposed(word,letters) == true)
		{
			System.out.println(word +" may be composed by with letters "+Arrays.toString(letters));
		}
		else
			System.out.println(word +" may not be composed with "+Arrays.toString(letters));
	}

}
