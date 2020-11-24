package com.ssafy.happyhouse.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssafy.happyhouse.model.dto.AptDto;
import com.ssafy.happyhouse.model.dto.DetailDto;
import com.ssafy.happyhouse.model.dto.TopSearchDto;

public interface AptDao {
	List<AptDto> getApt(@Param("lat") double lat, @Param("lon") double lon, @Param("distance") int distance);
	List<DetailDto> getDetail(@Param("lat") double lat, @Param("lon") double lon, @Param("distance") int distance);
	

	TopSearchDto check(String keyword);
	boolean putKeyword(String keyword);
	boolean addCount(TopSearchDto topSearchDto);
}
