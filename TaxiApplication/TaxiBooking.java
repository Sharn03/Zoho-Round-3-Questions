package TaxiApplication;

import java.util.ArrayList;

public class TaxiBooking {
	private static ArrayList<Taxi>taxiList = new ArrayList<>();
	
	private static int taxiListLimiter = 2;
	private static int idGenerator = 0;
	private static ArrayList<Taxi>taxiBookedHistory = new ArrayList<>();
	
	public static String booking(char pickupPoint,char dropPoint,int pickupTime) throws CloneNotSupportedException
	{
		if(taxiList.size()<taxiListLimiter)
		{
			taxiList.add(new Taxi());
		}
		
		//Checking the Constraints
		Taxi taxiReady = null;
		int min = Integer.MAX_VALUE;
		for(Taxi t : taxiList)
		{
			if(pickupTime>=t.getDropTime() && Math.abs(pickupPoint - (t.getCurrentLocation()))<= min)
			{
				// if Math.abs(..) is equal to min, the taxi with lowest earnings will be put in taxiReady object
				if(Math.abs(pickupPoint - t.getCurrentLocation()) == min)
				{
					if(taxiReady!=null && t.getEarning()<taxiReady.getEarning())
					{
						taxiReady = t;
					}
				}
				
				else
				{
					taxiReady = t;
					min = Math.abs(pickupPoint - t.getCurrentLocation());
					System.out.println("Min Location:"+ min);
					
				}
			}
		}
		
		if(taxiReady != null)
		{
			taxiReady.setCustomerId(idGenerator++);
			taxiReady.setTaxiId(taxiList.indexOf(taxiReady)+1);
			taxiReady.setPickupoint(pickupPoint);
			taxiReady.setDropPoint(dropPoint);
			taxiReady.setCurrentLocation(dropPoint);
			taxiReady.setPickupTime(pickupTime);
			taxiReady.setDropTime(taxiReady.getPickupTime()+ (Math.abs(dropPoint - pickupPoint)));
			taxiReady.setEarning(taxiReady.getEarning()+ Math.abs(dropPoint - pickupPoint)*100+(10*10));
			taxiBookedHistory.add((Taxi)taxiReady.clone());
		}
		
		return (taxiReady != null)? "Taxi Number" +" "+taxiReady.getTaxiId()+" "+"is Booked.." : "Taxi is not Available..";
	}
	
	public static void display()
	{
		System.out.println("-------------------------------");
		for(Taxi taxi:taxiBookedHistory)
		{
			System.out.println(taxi.toString());
			System.out.println("------------------------------");
		}
	}
	
	
	
}
