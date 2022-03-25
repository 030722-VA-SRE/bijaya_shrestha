package com.revature.models;

import java.util.Objects;

public class Boba {


	private int id;
	private String flavor;
	private int price;
	public static int counter;
	
	public Boba() {
		 super();
		 this.id = counter;
		 counter++;
	 }
	public Boba(String flavor, int price) {
		super();
		this.flavor = flavor;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFlavor() {
		return flavor;
	}
	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Boba other = (Boba) obj;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return flavor + ":" + price ;
	}


}
