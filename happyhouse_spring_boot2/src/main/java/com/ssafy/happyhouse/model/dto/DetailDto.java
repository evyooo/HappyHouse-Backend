package com.ssafy.happyhouse.model.dto;

public class DetailDto {
	private String name;
	private int maxPrice;
	private int minPrice;
	private int avgPrice;
	private double maxArea;
	private double minArea;
	
	
	public DetailDto() {
		
	}
	
	public DetailDto(String name, int maxPrice, int minPrice, int avgPrice, double maxArea, double minArea) {
		super();
		this.name = name;
		this.maxPrice = maxPrice;
		this.minPrice = minPrice;
		this.avgPrice = avgPrice;
		this.maxArea = maxArea;
		this.minArea = minArea;
	}
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(int maxPrice) {
		this.maxPrice = maxPrice;
	}

	public int getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(int minPrice) {
		this.minPrice = minPrice;
	}

	public int getAvgPrice() {
		return avgPrice;
	}

	public void setAvgPrice(int avgPrice) {
		this.avgPrice = avgPrice;
	}

	public double getMaxArea() {
		return maxArea;
	}

	public void setMaxArea(double maxArea) {
		this.maxArea = maxArea;
	}

	public double getMinArea() {
		return minArea;
	}

	public void setMinArea(double minArea) {
		this.minArea = minArea;
	}

	@Override
	public String toString() {
		return "DetailDto [name=" + name + ", maxPrice=" + maxPrice + ", minPrice=" + minPrice + ", avgPrice="
				+ avgPrice + ", maxArea=" + maxArea + ", minArea=" + minArea + "]";
	}


}
