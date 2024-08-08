package RailwayReservation;

import java.util.HashMap;
import java.util.Map;

public class TicketCancelling extends TicketBooking {
	
	//this is used to keep track of the cancelled ticket details in map\
	private static char preferenceTracker = '\0';
	private static int cancelledSeatNumber = 0;
	
	private static Map<Integer,Character>seatNumberWithBerth = new HashMap<>();
	
	//Method to search the particular ticket id and remove it from the list
	public static String cancelling(int id)
	{
		for(Passenger p : confirmedList)
		{
			if(p.getId() == id)
			{
				cancel(p);
				return "Success";
			}
			
		}
		
		for(Passenger p : racQueue)
		{
			if(p.getId() == id)
			{
				cancel(p);
				return "Success";
			}
			
		}
		
		for(Passenger p : waitingListQueue)
		{
			if(p.getId() == id)
			{
				cancel(p);
				return "Success";
			}
			
		}
		
		return "Invalid Ticket Id...";
	}

	//MEthod to cancel ticket
	private static void cancel(Passenger p) {
		
		
			if(p.getTicketType() == "Berth")
			{
				cancelledSeatNumber = p.getSeatNo();
				preferenceTracker = p.getPreference();
				
				//Adding the cancelled ticket details in the map
				seatNumberWithBerth.put(cancelledSeatNumber,preferenceTracker);
				
				addingRacToBerth(racQueue.poll());
				addingWaitingListToRac(waitingListQueue.poll());
				
			}
			
			// if Canceled Ticket is Rac -> Move the WaitingList person to RAC
			else if(p.getTicketType() == "RAC")
			{
				racQueue.remove(p);
				addingWaitingListToRac(waitingListQueue.poll());
			}
			
			//If cancelled Ticket is WaitingList -> Move the waitingList person from the waiting List queue
			else
			{
				waitingListQueue.remove(p);
			}
		
		
	}

	//Method to update passenger from WaitingList to Rac
	private static void addingWaitingListToRac(Passenger p) {
		
		if(p != null)
		{
			p.setTicketType("RAC");
			racQueue.add(p);
		}
		
	}

	//Method to update passenger from  Rac to Berth
	private static void addingRacToBerth(Passenger p) {
	
		if(p!=null)
		{
			p.setPreference(preferenceTracker);
			p.setSeatNo(cancelledSeatNumber);
			p.setTicketType("berth");
			
			if(preferenceTracker == 'U') {
				upperBerthList.add(p);
			}
			else if (preferenceTracker == 'M') {
				middleBerthList.add(p);
			}
			else {
				lowerBerthList.add(p);
			}
			
			confirmedList.add(p);
			seatNumberWithBerth.remove(cancelledSeatNumber);
			preferenceTracker = '\0';
			cancelledSeatNumber = 0;
		}
	}
}
