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
public class AptDaoImpl implements AptDao {

	private SqlSession sqlSession;
	private static final String ns = "com.ssafy.happyhouse.model.dao.AptDao.";

	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}


	@Override
	public List<AptDto> getApt(double lat, double lon, int distance) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("lat", lat);
		map.put("lon", lon);
		map.put("distance", distance);
		return sqlSession.selectList(ns + "getApt", map);
	}


	@Override
	public List<DetailDto> getDetail(double lat, double lon, int distance) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("lat", lat);
		map.put("lon", lon);
		map.put("distance", distance);
		return sqlSession.selectList(ns + "getDetail", map);
	}


	@Override
	public TopSearchDto check(String keyword) {
		return sqlSession.selectOne(ns + "check", keyword);
	}

	@Override
	public boolean putKeyword(String keyword) {
		return sqlSession.insert(ns + "putKeyword", keyword) > 0;
	}

	@Override
	public boolean addCount(TopSearchDto topSearchDto) {
		return sqlSession.insert(ns + "addCount", topSearchDto) > 0;
	}


}
