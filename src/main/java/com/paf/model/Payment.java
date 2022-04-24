package com.paf.model;

public class Payment {
	
	private String AccNumber;
	private String DateOfPayment;
	private Float Amount;
	private String TypeOfPayment;

	
	public Payment() {
		
	}
	
	public Payment(String AccNumber, String DateOfPayment, float Amount, String TypeOfPayment) {
		super();
		this.AccNumber = AccNumber;
		this.DateOfPayment = DateOfPayment;
		this.Amount = Amount;
		this.TypeOfPayment = TypeOfPayment;
		
	}

	public String getAccNumber() {
		return AccNumber;
	}

	public void setAccNumber(String AccNumber) {
		this.AccNumber = AccNumber;
	}

	public String getDateOfPayment() {
		return DateOfPayment;
	}

	public void setDateOfPayment(String DateOfPayment) {
		this.DateOfPayment = DateOfPayment;
	}

	public Float getAmount() {
		return Amount;
	}

	public void setAmount(Float Amount) {
		this.Amount = Amount;
	}

	public String getTypeOfPayment() {
		return TypeOfPayment;
	}

	public void setTypeOfPayment(String TypeOfPayment) {
		this.TypeOfPayment = TypeOfPayment;
	}



}
