package com.nagarro.product_details;
import com.opencsv.bean.CsvBindByPosition;

@SuppressWarnings("all")
public class ProductDetails {

	
	private int preference;

	@CsvBindByPosition(position = 0)
	private  String ID;
	
	@CsvBindByPosition(position = 1)
	private String Name;
	
	@CsvBindByPosition(position = 2)
	private String color;
	
	@CsvBindByPosition(position = 3)
	private String gender;
	
	@CsvBindByPosition(position = 4)
	private String size;
	
	@CsvBindByPosition(position = 5)
	private String price;
	
	@CsvBindByPosition(position = 6)
	private double rating;
	
	@CsvBindByPosition(position = 7)
	private String availability;

	
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}
	
	public int getPreference() {
		return preference;
	}

	public void setPreference(int preference) {
		this.preference = preference;
	}

	@Override
	public String toString() {
		return(" ID : " + this.getID()+"\n"+
				" Name : " + this.getName()+"\n"+
				" Colour : " + this.getColor()+"\n"+
				" Gender : " + this.getGender()+"\n"+
				" Size : " + this.getSize()+"\n"+
				" Price : " + this.getPrice()+"\n"+
				" Rating : " + this.getRating()+"\n"+
				" Availability : " + this.getAvailability()+"\n");
				
	}
	
}
