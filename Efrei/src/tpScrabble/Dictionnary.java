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
	
	public ArrayList<String> getWordsList()
	{
//		String ch = "[";
//		for (int i = 1; i<wordsList.size(); i++)
//		{
//			ch += " "+wordsList.get(i);
//		}
//		ch +="]";
//		return ch;
		return wordsList;
	}
	
	 public boolean mayBeComposed(String word, char[] letters)
	 {
		boolean rep = true;
		//boolean[] isUsed = new boolean[letters.length]; // isUsed is of the same size as letters 
		//Arrays.fill(isUsed, false); // set all elements to false
		word = replaceFrenchCharacter(word);
		String chaineletters1 = new String(letters);
		char [] alphabetLetters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		if (chaineletters1.contains("*"))
		{
			int ind = chaineletters1.indexOf('*');
			for (int i = 0; i < alphabetLetters.length; i++)
			{
				 letters[ind] = alphabetLetters[i];
				StringBuilder chaineletters = new StringBuilder(letters);
				for (int j = 0; j < word.length(); j++)
				{

					int index = chaineletters1.indexOf(word.substring(j,j+1));
					if(index>=0)
					{
						chaineletters.deleteCharAt(index);
					}
					else 
					{
						return false;
					}
				}
				return true; 
			}
		}
		else
		{
			StringBuilder chaineletters = new StringBuilder(chaineletters1);
			for (int i = 0; i < word.length(); i++)
			{

				int index = chaineletters1.indexOf(word.substring(i,i+1));
				if(index>=0)
				{
					chaineletters.deleteCharAt(index);
				}
				else 
				{
					return false;
				}
			}
			return true;
		} 
	}
		
			/*for (int j = 0; j< letters.length; j++)
			{

				if (word.charAt(i) == letters[j] && !isUsed[j])
				{
					rep = true;
					isUsed[j] = true;
					//j = letters.length;
				}	 
				else 
				{
					rep = false;
				}
			}	 
			if (!rep)
			{
				i = word.length();
			}	*/
	 }	
	 
	 public static String replaceFrenchCharacter(String s)
	 {
		 String str = s;
		 if (s.contains("é")||s.contains("è")||s.contains("ê")||s.contains("ë"))
			str = str.replaceAll("[éèêë]", "e");
		 else if (s.contains("à")||s.contains("â")||s.contains("ä"))
			 str = str.replaceAll("[à,â,ä]", "a");
		 else if (s.contains("î")||s.contains("ï"))
			 str = str.replaceAll("[î,ï]", "i");
		 else if (s.contains("ô")||s.contains("ö"))
			 str = str.replaceAll("[ô,ö]", "o");
		 else if (s.contains("û")||s.contains("û")||s.contains("ü"))
			 str = str.replaceAll("[ù,û,ü]", "u");
		 else if (s.contains("ç"))
			 str = str.replaceAll("[ç]", "c");
		 else if (s.contains("œ"))
			 str = str.replaceAll("[œ]", "oe");
	     else if (s.contains("æ"))
	    	 str = str.replaceAll("[æ]", "ae");
		 return str;
	 }
	 
	 public String[]  getWordsThatCanBeComposed(char[] letters)
	 {
		 int count = 0;
		 for (int i = 0; i < getWordsList().size(); i++)
		 {
			 if (mayBeComposed(replaceFrenchCharacter(getWordsList().get(i).toLowerCase()),letters)){
				 count++;
			 }
		 }
		 String[] words = new String[count];
		 int i = 0;
		 for (String s : getWordsList())
		 {
			 if (mayBeComposed(replaceFrenchCharacter(s.toLowerCase()),letters))
			 {
				 words[i] = s; 
				 i++;
			 }
		 }
		 return words;
	 }
}
