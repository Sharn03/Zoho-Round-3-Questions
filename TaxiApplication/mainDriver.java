package TaxiApplication;

import java.util.Scanner;



public class mainDriver {

	public static void main(String[] args) throws CloneNotSupportedException {
	
		Scanner s = new Scanner(System.in);
		boolean loop = true;
		while(loop)
		{
			System.out.println("1.Book Taxi");
			System.out.println("2.Booking Details");
			System.out.println("3.exit");
			
			int choice = s.nextInt();
			
			switch(choice)
			{
			case 1:
				{
					
					System.out.println("Enter the Pick-Up Location");
					char pickupPoint = s.next().charAt(0);
					System.out.println("Enter the Drop Location");
					char dropPoint = s.next().charAt(0);
					
					System.out.println("Enter the Pickup Time");
					int PickupTime = s.nextInt();
					
					
					String response = TaxiBooking.booking(pickupPoint, dropPoint, PickupTime);
					System.out.println(response);
					break;
				}
				
			case 2:
			{
				
				TaxiBooking.display();
				break;
			}
			
			case 3:
			{
				loop = false;
				
				System.out.println("Thank You for the Booking....");
				s.close();
				break;
			}
				
			}
		}

	}

}
