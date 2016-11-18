package tpSpaceTravel;

public enum Planet 
{
	MERCURY("Mercure", 0.387),
	VENUS("Venus", 0.722),
	EARTH("Terre", 1.0),
	MARS("Mars", 1.52),
	JUPITER("Jupiter", 5.2), 
	SATURN("Saturne", 9.58), 
	URANUS("Uranus", 19.2), 
	NEPTUNE("Neptune", 30.1);
	
	private String frenchName; 
	private double distanceFromTheSun;
	public static final double UA_IN_KM = 149597871.0; // valeur en Km pour 1UA
	public static final double ROCKET_SPEED_IN_KM_PER_S = 4.0; //correspondant à la vitesse d’une fusée en km/s
	
	
	public String getfrenchName() 
	{ 
		return frenchName;
	}
	
	public double getdistanceFromTheSun()
	{
		return distanceFromTheSun;
	}
	
	public String toString()
	{
		String ch = this.getfrenchName()+" ("+this.getdistanceFromTheSun()+" UA)";
		return ch;
	}
	
	 public double distanceInUATo(Planet otherPlanet) // qui fournit la distance en U.A. entre la planète et une autre planète. (NB : une distance est toujours positive!) 
	 {
		double dist = -this.distanceFromTheSun + otherPlanet.distanceFromTheSun;
		if (this.distanceFromTheSun >= otherPlanet.distanceFromTheSun)
			dist = this.distanceFromTheSun - otherPlanet.distanceFromTheSun;
		return dist;	
	 }
	 
	 public double distanceInKMTo(Planet otherPlanet) //qui fournit la distance en KM entre la planète et une autre planète. 
	 {
		return (this.distanceInUATo(otherPlanet) * UA_IN_KM);
	 }
	 
	 public double travelTimeInSTo(Planet otherPlanet) //qui calcule le temps de voyage en secondes de la planète à une autre planète en fonction de la vitesse (en km/s) passée en paramètre. 
	{ 
	  return (this.distanceInKMTo(otherPlanet)/ this.ROCKET_SPEED_IN_KM_PER_S);
	}
	
	
	private Planet (String frenchName, double distanceFromTheSun)
	{
		this.frenchName = frenchName;
		this.distanceFromTheSun = distanceFromTheSun;
	}
	
}