package com.kh.app24.aop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.app24.aop.dao.MyDao;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MyService {

	@Autowired
	private MyDao dao;
	
	public void test() {
		log.info("test method called...");
		dao.test();
	}
	
}
