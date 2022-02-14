package com.kh.app999.member.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.app999.member.entity.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao{

	@Autowired
	SqlSession ss;
	
	@Override
	public int getMemberSeq() throws Exception {
		return ss.selectOne("member.getSeq");
	}

	@Override
	public int insertMember(MemberDto dto) throws Exception {
		return ss.insert("member.insertMember", dto);
	}

}
