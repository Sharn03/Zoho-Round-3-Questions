package RailwayReservation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

public class TicketBooking {
	
	private static int berthLimiter = 2;// totatl seats = 6 / total berths(3)
	private static int racLimit = 1;
	private static int waitingListLimit = 1;
	
	private static int upperSeatNo = 1;
	private static int middleSeatNo = 2;
	private static int lowerSeatNo = 3;
	
	 static ArrayList<Passenger>upperBerthList = new ArrayList<>();
	 static ArrayList<Passenger>middleBerthList = new ArrayList<>();
	 static ArrayList<Passenger>lowerBerthList = new ArrayList<>();
	
	 static ArrayList<Passenger>confirmedList = new ArrayList<>();
	
	 static Queue<Passenger>racQueue = new LinkedList<>();
	 static Queue<Passenger>waitingListQueue = new LinkedList<>();
	
	public static void BookTicket(Passenger p)
	{
		if(upperBerthList.size()== berthLimiter && lowerBerthList.size() ==  berthLimiter &&  middleBerthList.size() == berthLimiter)
		{
			
			if(updateRacQueue(p))
			{
				System.out.println("Added to RAC\nYour ticket id is "+p.getId());
			}
			
			else if(updateWaitingListQueue(p))
			{
				System.out.println("Added to Waiting List\nYour ticket id is "+p.getId());
			}
			
			else
			{
				//Ticket Not Available
				p.setId(p.getId()-1);
				System.out.println("Ticket Not Available....");
			}
			
		}
		
		else if(checkAvailability(p))
		{
			System.out.println("Booking confirmed\nYour ticket id is "+p.getId());
			p.setTicketType("Berth");
			confirmedList.add(p);
		}
		
		else
		{
			System.out.println(p.getPreference()+" is not available");
			p.setId(p.getId()-1);
			availableList();
		}
		
		
	}
	
	
	
	//MEthod to update Waiting List
	private static boolean updateWaitingListQueue(Passenger p) {

		if(waitingListQueue.size()<waitingListLimit)
		{
			p.setTicketType("WaitingList");
			waitingListQueue.add(p);
			return true;
		}
		return false;
	}


	//Method to update RaceQueue
	private static boolean updateRacQueue(Passenger p) {
		if(racQueue.size()<racLimit)
		{
			p.setTicketType("RAC");
			racQueue.add(p);
			return true;
			
		}
		return false;
	}
	
	
	//Method to check availability
	private static boolean checkAvailability(Passenger p) {
		
		HashMap<Integer,Character>map =  TicketCanceling.getSeatNumberWithBerth();
		
		if(p.getPreference() == 'U')
		{
			if(upperBerthList.size()<berthLimiter)
			{
				
				if(!map.isEmpty())
				{
					getSeatDetails(map, p);

				}
				
				else
				{
					
					p.setSeatNo(upperSeatNo);
					upperSeatNo = upperSeatNo+3;
				}
				
				upperBerthList.add(p);
				return true;
			}
		}
		
		else if(p.getPreference() == 'M')
		{
			if(middleBerthList.size()<berthLimiter)
			{
				
				if(!map.isEmpty())
				{
					getSeatDetails(map, p);

				}
				
				else
				{
					
					p.setSeatNo(middleSeatNo);
					middleSeatNo = middleSeatNo+3;
				}
				
				lowerBerthList.add(p);
				return true;
			}
		}
		
		else if(p.getPreference() == 'L')
		{
			if(lowerBerthList.size()<berthLimiter)
			{
				
				if(!map.isEmpty())
				{
					getSeatDetails(map, p);

				}
				
				else
				{
					
					p.setSeatNo(lowerSeatNo);
					lowerSeatNo = lowerSeatNo+3;
				}
				
				lowerBerthList.add(p);
				return true;
			}
		}
		
		
		return false;
	}
	
	//Method to print No. of available Seat in the Each Berth
	public static void availableList()
	{
		System.out.println("Check out the No. of Seats");
		System.out.println("UpperBerth :" + (berthLimiter - upperBerthList.size()) );
		System.out.println("MiddleBerth :" + (berthLimiter - middleBerthList.size()) );
		System.out.println("LowerBerth :" + (berthLimiter - lowerBerthList.size()) );
	}
	
	
	//Method to get Seat Details
	public static void getSeatDetails(Map<Integer,Character>map,Passenger p)
	{
		int seatNumber = checkForPreferenceAvailability(map,p.getPreference());
		p.setSeatNo(seatNumber);
		map.remove(seatNumber);
	}

	
	//Method to check preference
	private static int checkForPreferenceAvailability(Map<Integer, Character> map, char preference) {
		
		int seatNumber = 0;
		for(Entry<Integer, Character> entry : map.entrySet())
		{
			if(preference == (char)entry.getValue())
			{
				seatNumber = (int)entry.getKey();
				break;
			}
		}
		return seatNumber;
	}
	
	//Method to display confirmed list
	public static void displayConfirmed()
	{
		System.out.println("-------------------------");
		for(Passenger p : confirmedList)
		{
			System.out.println(p.toString());
			System.out.println("-------------------------");
		}
	}
	
	public static void displayRAC()
	{
		System.out.println("-------------------------");
		for(Passenger p : racQueue)
		{
			System.out.println(p.toString());
			System.out.println("-------------------------");
		}
	}
	public static void displayWaiting()
	{
		System.out.println("-------------------------");
		for(Passenger p : waitingListQueue)
		{
			System.out.println(p.toString());
			System.out.println("-------------------------");
		}
	}

	
}


