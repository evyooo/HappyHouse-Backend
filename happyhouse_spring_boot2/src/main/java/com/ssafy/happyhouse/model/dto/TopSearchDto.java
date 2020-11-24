package com.ssafy.happyhouse.model.dto;

public class TopSearchDto {
	private String keyword;
	private int times;
	
	public TopSearchDto() {
		
	}
	
	public TopSearchDto(String keyword, int times) {
		super();
		this.keyword = keyword;
		this.times = times;
	}
	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getTimes() {
		return times;
	}
	public void setTimes(int times) {
		this.times = times;
	}
	
	@Override
	public String toString() {
		return "TopSearchDto [keyword=" + keyword + ", times=" + times + "]";
	}
	

}
