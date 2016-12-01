package tpScrabble;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class Dictionnary 
{
	private ArrayList<String> wordsList = new ArrayList<>();
	
	public Dictionnary ()
	{
		FileReader f = null;
		try 
		{
			f = new FileReader("./ListeMots/MotsReconnus");
			BufferedReader br = new BufferedReader(f);
			String line;
			while((line=br.readLine())!=null)
			{
				wordsList.add(line);
			}
			br.close();
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("File not found");
		}
		catch (IOException e) 
		{
			
		}
	}
	
	public Dictionnary(String s) throws FileNotFoundException
	{
		try 
		{
			FileReader f = new FileReader(s);
			BufferedReader br = new BufferedReader(f);
			String line;
			while ((line=br.readLine())!=null)
			{
				wordsList.add(line);
			}
		} 
		catch (IOException e) 
		{
			System.out.println("File named "+s+" NOT FOUND");
		}
	}
	
	public boolean isValidWord(String testMot)
	{
		boolean found = false;
		for (String s : wordsList)
		{
			if (s.matches(testMot))
				found = true;
		}
		return found;
	}
	
	public String getWordsList()
	{
		String ch = "[";
		for (int i = 1; i<wordsList.size(); i++)
		{
			ch += " "+wordsList.get(i);
		}
		ch +="]";
		return ch;
	}
	
	 public boolean mayBeComposed(String word, char[] letters)
	 {
		boolean rep = true;
		boolean[] isUsed = new boolean[letters.length]; // isUsed is of the same size as letters 
		Arrays.fill(isUsed, false); // set all elements to false
		
		for (int i = 0; i < word.length(); i++)
		{
			for (int j = 0; j< letters.length; j++)
			{
				if (word.charAt(i) == letters[j] && !isUsed[j])
				{
					rep = true;
					isUsed[j] = true;
					j = letters.length;
				}	 
				else 
				{
					rep = false;
				}
			}	 
			if (rep == false)
			{
				i = word.length();
			}
		}
		 
		return rep; 
	 }	
	 
	 public static String replaceFrenchCharacter(String s)
	 {
		 String str;
		 
		 return str;
	 }
}
