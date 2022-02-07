package com.kh.app25.member.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.app25.member.entity.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao{
	
	@Autowired
	private SqlSession ss;

	@Override
	public int join(MemberDto dto) throws Exception {
		return ss.insert("member.join", dto);
	}
	
	
}
