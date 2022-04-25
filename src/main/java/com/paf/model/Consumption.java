package com.paf.model;

public class Consumption {

	private String RangeOfUnit;
	private Float Price;
	private String Date;
	private String Comments;

	public Consumption() {

	}

	public Consumption(String RangeOfUnit, Float Price, String Date, String Comments) {
		super();
		this.RangeOfUnit = RangeOfUnit;
		this.Price = Price;
		this.Date = Date;
		this.Comments = Comments;

	}

	public String getRangeOfUnit() {
		return RangeOfUnit;
	}

	public void setRangeOfUnit(String RangeOfUnit) {
		this.RangeOfUnit = RangeOfUnit;
	}

	public Float getPrice() {
		return Price;
	}

	public void setPrice(Float Price) {
		this.Price = Price;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String Date) {
		this.Date = Date;
	}

	public String getComments() {
		return Comments;
	}

	public void setComments(String Comments) {
		this.Comments = Comments;
	}

}
