package com.ssafy.happyhouse.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.model.dto.AptDto;
import com.ssafy.happyhouse.model.dto.DetailDto;
import com.ssafy.happyhouse.model.dto.TopSearchDto;

@Repository
public class TopSearchDaoImpl implements TopSearchDao {

	private SqlSession sqlSession;
	private static final String ns = "com.ssafy.happyhouse.model.dao.TopSearchDao.";

	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	// 인기검색어 불러오기 
	@Override
	public List<TopSearchDto> getTopSearch() {
		return sqlSession.selectList(ns + "getTopSearch");	
	}



}
