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
			System.out.println(dico.getWordsList().size()+"words loaded. From ADSL to oeuvée");
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
		
		/*Scanner sc = new Scanner(System.in);
		System.out.println("please enter a word");
		String word0 = sc.nextLine();
		String word1 = word0.toLowerCase();
		
		Scanner sc1 = new Scanner(System.in);
		System.out.println("please a letter list");
		char[] letters = sc1.nextLine().toLowerCase().toCharArray();
		String word2 = sce.dico.replaceFrenchCharacter(word1);
		
		
		if (sce.dico.mayBeComposed(word2,letters) == true)
		{
			System.out.println(word0 +" may be composed by with letters "+Arrays.toString(letters));
		}
		else
			System.out.println(word0 +" may not be composed with "+Arrays.toString(letters));*/
		
		Scanner sc1 = new Scanner(System.in);
		System.out.println("please a letter list");
		char[] letters = sc1.nextLine().toLowerCase().toCharArray();
		System.out.print("[");
		for (String s : sce.dico.getWordsThatCanBeComposed(letters))
		{
			System.out.print(s+", ");
		}
		System.out.println("]");
		//System.out.println(sce.dico.getWordsThatCanBeComposed(letters));
		
	}

}
