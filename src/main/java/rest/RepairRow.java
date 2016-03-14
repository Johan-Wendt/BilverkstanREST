package rest;

import java.sql.Timestamp;

public class RepairRow {
	private int booking;
	private int reparation;
	private Timestamp timestamp;
	
	public RepairRow() {
		
	}
	
	public int getBooking() {
		return booking;
	}
	public void setBooking(int booking) {
		this.booking = booking;
	}
	public int getReparation() {
		return reparation;
	}
	public void setReparation(int reparation) {
		this.reparation = reparation;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

}
