package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.ssafy.happyhouse.model.dto.AptDto;
import com.ssafy.happyhouse.model.dto.TopSearchDto;

public interface TopSearchService {

	List<TopSearchDto> getTopSearch();
	
}
