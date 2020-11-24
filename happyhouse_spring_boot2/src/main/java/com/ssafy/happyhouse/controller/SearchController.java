package com.ssafy.happyhouse.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.apache.tomcat.util.json.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.dto.AptDto;
import com.ssafy.happyhouse.model.dto.TopSearchDto;
import com.ssafy.happyhouse.model.service.SearchService;
import com.ssafy.happyhouse.model.service.TopSearchService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/search")
@RestController
public class SearchController {
	private SearchService searchService;
	private TopSearchService topSearchService;
	
	@Autowired
	public void setSearchService(SearchService searchService) {
		this.searchService = searchService;
	}
	
	
	@GetMapping("/get/{address}/{bdgType}/{saleType}/{distance}/{lat}/{lon}")
	public JSONArray getApt(@PathVariable String address, @PathVariable int bdgType, @PathVariable int saleType, @PathVariable int distance,
			@PathVariable String lat, @PathVariable String lon) {
		
		//  건물 종류: 1- 아파트 / 2- 오피스텔 / 3- 원룸투룸 / 4- 단독주택 
		//  매매 종류: 1- 매매 / 2- 전월세
		String typeCode = Integer.toString(bdgType) + Integer.toString(saleType);

		
		//  인기 검색어 
		TopSearchDto result = searchService.check(address);
		
		//  없으면 새로 추가 
		if (result == null) {
			System.out.println("없음");
			searchService.putKeyword(address);
		}
		//  있으면 번호 키우기 
		else {
			System.out.println("있음");
			
			TopSearchDto newTimes = new TopSearchDto();
			newTimes.setKeyword(address);
			newTimes.setTimes(result.getTimes()+1);
			
			searchService.addCount(newTimes);
		}

		switch(typeCode) {
		
			case "11": // 아파트 매매 
				return searchService.getApt(lat, lon, distance);
				
			// 여기부터 밑에 쭉 수정하기 
			case "12": // 아파트 전월세 
				return searchService.getApt(lat, lon, distance);
				
			case "21": // 오피스텔 매매 
				return searchService.getApt(lat, lon, distance);
				
			case "22": // 오피스텔 전월세 
				return searchService.getApt(lat, lon, distance);
				
			case "31": // 원룸투룸 매매 
				return searchService.getApt(lat, lon, distance);
				
			case "32": // 원룸투룸 전월세 
				return searchService.getApt(lat, lon, distance);
				
			case "41": // 단독주택 매매 
				return searchService.getApt(lat, lon, distance);
				
			case "42": // 단독주택 전월세 
				return searchService.getApt(lat, lon, distance);
				
			default:
				return searchService.getApt(lat, lon, distance);
		}
		
	}
	

}
