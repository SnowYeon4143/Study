package com.kh.app23;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyDao {

	@Autowired
	private SqlSession ss;
	
	public void testA() {
		ss.insert("test.a");
	}

	public void testB() {
		ss.insert("test.b");
	}

}
