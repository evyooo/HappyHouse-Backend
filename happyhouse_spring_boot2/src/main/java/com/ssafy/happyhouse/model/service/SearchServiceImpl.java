package com.ssafy.happyhouse.model.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dao.AptDao;
import com.ssafy.happyhouse.model.dto.AptDto;
import com.ssafy.happyhouse.model.dto.DetailDto;
import com.ssafy.happyhouse.model.dto.TopSearchDto;

@Service
public class SearchServiceImpl implements SearchService {
	private AptDao aptDao;

	@Autowired
	public void setQnaDao(AptDao aptDao) {
		this.aptDao = aptDao;
	}


	@Override
	public JSONArray getApt(String lat2, String lon2, int distance) {
		
		double lat = Double.parseDouble(lat2);
		double lon = Double.parseDouble(lon2);
		
		List<AptDto> raw = aptDao.getApt(lat, lon, distance);
		List<DetailDto> detail = aptDao.getDetail(lat, lon, distance);
		
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject0 = new JSONObject();

		int index = 0;

		// 공통: name, builtYr, address, coord_x, coord_y
		jsonObject0.put("name", raw.get(0).getName());
		jsonObject0.put("builtYr", raw.get(0).getBuiltYr());
		jsonObject0.put("address", raw.get(0).getAddress());
		jsonObject0.put("coord_x", raw.get(0).getCoord_x());
		jsonObject0.put("coord_y", raw.get(0).getCoord_y());
		jsonObject0.put("avgPrice", detail.get(index).getAvgPrice());
		jsonObject0.put("minPrice", detail.get(index).getMinPrice());
		jsonObject0.put("maxPrice", detail.get(index).getMaxPrice());
		jsonObject0.put("minArea", detail.get(index).getMinArea());
		jsonObject0.put("maxArea", detail.get(index++).getMaxArea());

		JSONArray dataArr0 = new JSONArray();
		JSONArray dataArr = dataArr0;
		
		JSONObject data0 = new JSONObject();
		JSONObject data = data0;
				

		//  첫번째 주소 
		String tempAddress = raw.get(0).getAddress();
		
		JSONObject jsonObject = jsonObject0;

		
		for (AptDto aptinfo : raw) {
						
			//  만약지금 주소가 첫번째 주소랑 다르면 갱신 후 리스트에추가 
			if (!aptinfo.getAddress().equals(tempAddress)) {
								
				jsonObject.put("data", dataArr);
				jsonArray.add(jsonObject);

				
				// 갱신
				tempAddress = aptinfo.getAddress();
				JSONObject newJSON = new JSONObject();
				jsonObject = newJSON;
				
				newJSON.put("name", aptinfo.getName());
				newJSON.put("builtYr", aptinfo.getBuiltYr());
				newJSON.put("address", aptinfo.getAddress());
				newJSON.put("coord_x", aptinfo.getCoord_x());
				newJSON.put("coord_y", aptinfo.getCoord_y());
				newJSON.put("avgPrice", detail.get(index).getAvgPrice());
				newJSON.put("minPrice", detail.get(index).getMinPrice());
				newJSON.put("maxPrice", detail.get(index).getMaxPrice());
				newJSON.put("minArea", detail.get(index).getMinArea());
				newJSON.put("maxArea", detail.get(index++).getMaxArea());
				
				
				JSONArray newDataArray = new JSONArray();
				dataArr = newDataArray;
				
			}
		
			JSONObject newData = new JSONObject();
			data = newData;
			
			// 개별: price, saleDate, aptArea, aptFloor
			data.put("price", aptinfo.getPrice());
			data.put("saleDate", aptinfo.getSaleDate());
			data.put("aptArea", aptinfo.getAptArea());
			data.put("aptFloor", aptinfo.getAptFloor());

			dataArr.add(data);			
			
		}
		
		// 마지막꺼 넣어주기
		jsonObject.put("data", dataArr);
		jsonArray.add(jsonObject);		
		
		
		// empty array의 경우에 'empty' 리턴 
		if (jsonArray.isEmpty()) {
			jsonArray.add("empty");
		}
		return jsonArray;
	}


	@Override
	public TopSearchDto check(String keyword) {
		// TODO Auto-generated method stub
		return aptDao.check(keyword);
	}


	@Override
	public void putKeyword(String keyword) {
		aptDao.putKeyword(keyword);	
	}


	@Override
	public void addCount(TopSearchDto topSearchDto) {
		aptDao.addCount(topSearchDto);	
	}

}
