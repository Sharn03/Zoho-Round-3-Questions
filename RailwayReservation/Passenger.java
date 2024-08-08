package RailwayReservation;

public class Passenger {
	private int idProvider = 0;
	private int id;
	private String passengerName;
	private String passengerAge;
	private char preference;
	private int seatNo;
	private String ticketType;
	
	public Passenger(String name,String age,char preference)
	{
		this.id = idProvider++;
		this.passengerName = name;
		this.passengerAge = age;
		this.preference = preference;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public String getPassengerAge() {
		return passengerAge;
	}
	public void setPassengerAge(String passengerAge) {
		this.passengerAge = passengerAge;
	}
	public char getPreference() {
		return preference;
	}
	public void setPreference(char preference) {
		this.preference = preference;
	}
	public int getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	public String getTicketType() {
		return ticketType;
	}
	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}
	@Override
	public String toString() {
		return "Passenger [id=" + id + ", passengerName=" + passengerName + ", passengerAge=" + passengerAge
				+ ", preference=" + preference + ", seatNo=" + seatNo + ", ticketType=" + ticketType + "]";
	}
	
	
	
	
	
}
