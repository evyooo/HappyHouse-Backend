package com.ssafy.happyhouse.model.dto;

public class AptDto {
	private String name;
	private int price;
	private int builtYr;
	private int saleDate;
	private String address;
	private float aptArea;
	private int aptFloor;
	private String coord_x;
	private String coord_y;
	
	
	public AptDto() {
		
	}
	
	public AptDto(String name, int price, int builtYr, int saleDate, String address, float aptArea, int aptFloor, String coord_x, String coord_y) {
		super();
		this.name = name;
		this.price = price;
		this.builtYr = builtYr;
		this.saleDate = saleDate;
		this.address = address;
		this.aptArea = aptArea;
		this.aptFloor = aptFloor;
		this.coord_x = coord_x;
		this.coord_y = coord_y;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getBuiltYr() {
		return builtYr;
	}

	public void setBuiltYr(int builtYr) {
		this.builtYr = builtYr;
	}

	public int getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(int saleDate) {
		this.saleDate = saleDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public float getAptArea() {
		return aptArea;
	}

	public void setAptArea(float aptArea) {
		this.aptArea = aptArea;
	}

	public int getAptFloor() {
		return aptFloor;
	}

	public void setAptFloor(int aptFloor) {
		this.aptFloor = aptFloor;
	}

	public String getCoord_x() {
		return coord_x;
	}

	public void setCoord_x(String coord_x) {
		this.coord_x = coord_x;
	}

	public String getCoord_y() {
		return coord_y;
	}

	public void setCoord_y(String coord_y) {
		this.coord_y = coord_y;
	}

	@Override
	public String toString() {
		return "AptDto [name=" + name + ", price=" + price + ", builtYr=" + builtYr + ", saleDate=" + saleDate
				+ ", address=" + address + ", aptArea=" + aptArea + ", aptFloor=" + aptFloor + ", coord_x=" + coord_x
				+ ", coord_y=" + coord_y + "]";
	}


}
