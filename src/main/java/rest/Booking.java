package rest;

import java.sql.Date;
import java.sql.Timestamp;

public class Booking {
	private int submissionId;
	private int costumerId;
	private String carRegistrationId;
	private Date dateSubmissed;
	private Timestamp dateDoneEst;
	private Timestamp dateDoneAct;
	private Timestamp datePickedUp;
	private Date datePaid;
	private int mechanic;
	private int estimatePrice;
	private int paidPrice;
	private Timestamp dateRepairEst;
	private Timestamp dateRepairAct;
	
	public Booking() {
		
	}
	
	public int getSubmissionId() {
		return submissionId;
	}
	public void setSubmissionId(int submissionId) {
		this.submissionId = submissionId;
	}
	public int getCostumerId() {
		return costumerId;
	}
	public void setCostumerId(int costumerId) {
		this.costumerId = costumerId;
	}
	public String getCarRegistrationId() {
		return carRegistrationId;
	}
	public void setCarRegistrationId(String carRegistrationId) {
		this.carRegistrationId = carRegistrationId;
	}
	public Date getDateSubmissed() {
		return dateSubmissed;
	}
	public void setDateSubmissed(Date dateSubmissed) {
		this.dateSubmissed = dateSubmissed;
	}
	public Timestamp getDateDoneEst() {
		return dateDoneEst;
	}
	public void setDateDoneEst(Timestamp dateDoneEst) {
		this.dateDoneEst = dateDoneEst;
	}
	public Timestamp getDateDoneAct() {
		return dateDoneAct;
	}
	public void setDateDoneAct(Timestamp dateDoneAct) {
		this.dateDoneAct = dateDoneAct;
	}
	public Timestamp getDatePickedUp() {
		return datePickedUp;
	}
	public void setDatePickedUp(Timestamp datePickedUp) {
		this.datePickedUp = datePickedUp;
	}
	public Date getDatePaid() {
		return datePaid;
	}
	public void setDatePaid(Date datePaid) {
		this.datePaid = datePaid;
	}
	public int getMechanic() {
		return mechanic;
	}
	public void setMechanic(int mechanic) {
		this.mechanic = mechanic;
	}
	public int getEstimatePrice() {
		return estimatePrice;
	}
	public void setEstimatePrice(int estimatePrice) {
		this.estimatePrice = estimatePrice;
	}
	public int getPaidPrice() {
		return paidPrice;
	}
	public void setPaidPrice(int paidPrice) {
		this.paidPrice = paidPrice;
	}

	public Timestamp getDateRepairEst() {
		return dateRepairEst;
	}

	public void setDateRepairEst(Timestamp dateRepairEst) {
		this.dateRepairEst = dateRepairEst;
	}

	public Timestamp getDateRepairAct() {
		return dateRepairAct;
	}

	public void setDateRepairAct(Timestamp dateRepairAct) {
		this.dateRepairAct = dateRepairAct;
	}
}
