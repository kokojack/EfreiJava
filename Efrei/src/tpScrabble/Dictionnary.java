package tpScrabble;

import java.util.ArrayList;
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
}
