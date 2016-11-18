package tpSpaceTravel;

import java.util.*;
import java.util.Scanner;

public class SpaceTravel 
{
	public static final double LIGHT_SPEED_IN_KM_PER_S = 299792.458; // en Km/s
	public static double convertToMinute(double secondTime)
	{
		double i = 0;
		double j = secondTime;
		while(secondTime >= 60)
		{
			secondTime = secondTime - 60;
			i++;
		}
		return i + j - i*60;
	}
	public static double convertToHours(double minuteTime)
	{
		double i = 0; 
		double j = minuteTime;
		while(minuteTime >= 60)
		{
			minuteTime = minuteTime - 60;
			i++;
		}
		return i + j - i*60;
	}
	public static double convertToDays(double hoursTime)
	{
		double i = 0; 
		double j = hoursTime;
		while(hoursTime >= 24)
		{
			hoursTime = hoursTime- 24;
			i++;
		}
		return i + j - i*24;
	}
	private static Planet choosePlanet(Scanner sc)
	{
		boolean b = false;
		int ordinal = 0;
		Planet[] valuesArray = Planet.values();
		do 
		{
			System.out.println("\t\tVeuillez choisir une planète parmi les suivantes\n");
			for (int i = 0; i< valuesArray.length; i++)
			{
				System.out.println(valuesArray[i].getfrenchName());
			}
			String ch = sc.nextLine();
			for (int j = 0; j<valuesArray.length; j++)
			{
				if (valuesArray[j].getfrenchName().contains (ch))
				{
					b = true;
					ordinal = j;
				}
			}
		}
		while (b!= true);
		return valuesArray[ordinal];
	}
	

	public static void main (String args[])
	{
	
		String ch = "Welcome to the spaceTravel agency\n\n" ;
		System.out.println (ch);
		
		Scanner sc = new Scanner (System.in);
		String rep;
		char r;
		do
		{
			System.out.println ("What do you want to do ?\t [h for HELP]\n");
			rep = sc.nextLine();
			r = rep.charAt(0);
			switch (r)
			{
				case 'h':
					System.out.println (" h :\t print this help screen \n q: \t to quit the program\n l: \t to list the travel destinations\n d: \t simulate a travel \n");
				break;
			
				case 'l':
					Planet[] valuesArray = Planet.values();
					for (int i = 0 ; i < valuesArray.length ; i++) 
					{
						//System.out.println("Planète "+valuesArray[i].name()+" est la destination numéro "+valuesArray[i].ordinal());
						System.out.println ("\t" +valuesArray[i].name()+ "\t");
						System.out.println ("\t" +valuesArray[i].toString()+ "\t");
						/*
						System.out.println("\t" valuesArray[i]+" to " valuesArray[valuesArray.length-1]+" : "+valuesArray[i].distanceInUATo(valuesArray[valuesArray.length-1])+ "\t");
						System.out.println ("\t"valuesArray[i]+" to " valuesArray[valuesArray.length-1]+" : " +valuesArray[i].distanceInKMTo(valuesArray[valuesArray.length-1])+ "\t");
						System.out.println ("\t" +valuesArray[i].travelTimeInSTo(valuesArray[valuesArray.length-1])+ "\n");
						*/
					}
				break;
				
				case 'd' :
					System.out.println("what is your departure planet?");
					try
					{
						Scanner depa = new Scanner (System.in);
						Planet dep = choosePlanet (depa);
						System.out.println("Departure set to : " +dep.getfrenchName()+"\n");
					
						System.out.println("what is your arrival planet?");
						Scanner ari = new Scanner (System.in);
					
						Planet ar = choosePlanet (ari);
						System.out.println("Arrival set to : " +ar.getfrenchName()+"\n");
						
						Planet[] valueArray = Planet.values();
						System.out.println("\n");
						System.out.printf("--> The distance between "+dep.getfrenchName()+" and "+ar.getfrenchName()+" is %.2f"
								+"\n--> It is equivalent to %.2f km!"
								+"\n--> At the speed of light, you will need %.2f "
								+" seconds.\n--> But with our current technology it's more %.2f"
								+" seconds\n\n"
						,valueArray[dep.ordinal()].distanceInUATo(valueArray[ar.ordinal()])
						,valueArray[dep.ordinal()].distanceInKMTo(valueArray[ar.ordinal()])
						,valueArray[dep.ordinal()].distanceInKMTo(valueArray[ar.ordinal()])/SpaceTravel.LIGHT_SPEED_IN_KM_PER_S
						,valueArray[dep.ordinal()].travelTimeInSTo(valueArray[ar.ordinal()]));
					}
					catch (Exception e)
					{
						System.out.println("VALEUR ARRIVEE OU DEPART NON RECONNUE\n");
					}
					
				break;
				
				case 'q' :
					
				break;
				
				default :
					System.out.println ("Unknow Command \n");
				
			}
		}
		while (r != 'q');
		
		if (r == 'q')
		{
			System.out.println ("Bye Bye\n");
		}
	}



}