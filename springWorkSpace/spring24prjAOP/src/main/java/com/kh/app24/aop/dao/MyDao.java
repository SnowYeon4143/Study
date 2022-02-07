package com.kh.app24.aop.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class MyDao {

	@Autowired
	private SqlSession ss;
	
	public void test() {
		log.info("test method called...");
	}
	
}
