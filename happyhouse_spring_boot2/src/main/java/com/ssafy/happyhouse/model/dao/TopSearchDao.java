package com.ssafy.happyhouse.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssafy.happyhouse.model.dto.AptDto;
import com.ssafy.happyhouse.model.dto.DetailDto;
import com.ssafy.happyhouse.model.dto.TopSearchDto;

public interface TopSearchDao {
	List<TopSearchDto> getTopSearch();
}
