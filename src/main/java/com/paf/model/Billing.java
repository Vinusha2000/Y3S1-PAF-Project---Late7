package com.paf.model;

public class Billing {
	
	private String AccountNo;
	private String UserId;
	private String BillingStartDate;
	private String BillingEndDate;
	private float NoOfUnits;
	private float ArrearsAmount;
	
	public Billing() {
		
	}
	
	public Billing(String AccountNo, String UserId, String BillingStartDate, String BillingEndDate, Float NoOfUnits, Float ArrearsAmount) {
		super();
		this.AccountNo = AccountNo;
		this.UserId = UserId;
		this.BillingStartDate = BillingStartDate;
		this.BillingEndDate = BillingEndDate;
		this.NoOfUnits = NoOfUnits;
		this.ArrearsAmount = ArrearsAmount;
	}

	public String getAccountNo() {
		return AccountNo;
	}

	public void setAccountNo(String AccountNo) {
		this.AccountNo = AccountNo;
	}

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String UserId) {
		this.UserId = UserId;
	}

	public String getBillingStartDate() {
		return BillingStartDate;
	}

	public void setBillingStartDate(String BillingStartDate) {
		this.BillingStartDate = BillingStartDate;
	}

	public String getBillingEndDate() {
		return BillingEndDate;
	}

	public void setBillingEndDate(String BillingEndDate) {
		this.BillingEndDate = BillingEndDate;
	}

	public Float getNoOfUnits() {
		return NoOfUnits;
	}

	public void setNoOfUnits(float NoOfUnits) {
		this.NoOfUnits = NoOfUnits;
	}

	public Float getArrearsAmount() {
		return ArrearsAmount;
	}

	public void setArrearsAmount(float ArrearsAmount) {
		this.ArrearsAmount = ArrearsAmount;
	}

}
