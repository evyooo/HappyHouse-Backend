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
@RequestMapping("/api/topSearch")
@RestController
public class TopSearchController {
	private TopSearchService topSearchService;
	

	@Autowired
	public void setTopSearchService(TopSearchService topSearchService) {
		this.topSearchService = topSearchService;
	}
	
	
	@GetMapping("/get")
	public List<TopSearchDto> getTopSearch() {
		return topSearchService.getTopSearch();
	}

}
