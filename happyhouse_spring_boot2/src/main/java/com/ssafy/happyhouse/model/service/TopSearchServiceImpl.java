package com.ssafy.happyhouse.model.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dao.AptDao;
import com.ssafy.happyhouse.model.dao.TopSearchDao;
import com.ssafy.happyhouse.model.dto.AptDto;
import com.ssafy.happyhouse.model.dto.DetailDto;
import com.ssafy.happyhouse.model.dto.TopSearchDto;

@Service
public class TopSearchServiceImpl implements TopSearchService {
	private TopSearchDao topSearchDao;

	@Autowired
	public void setTopSearchDao(TopSearchDao topSearchDao) {
		this.topSearchDao = topSearchDao;
	}


	@Override
	public List<TopSearchDto> getTopSearch() {		
		return topSearchDao.getTopSearch();
	}



}
