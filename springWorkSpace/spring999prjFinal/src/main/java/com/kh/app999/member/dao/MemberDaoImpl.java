package com.kh.app999.member.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.app999.member.entity.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao{

	@Autowired
	private SqlSession ss;
	
	@Override
	public int getMemberSeq() throws Exception {
		return ss.selectOne("member.getSeq");
	}

	@Override
	public int insertMember(MemberDto dto) throws Exception {
		return ss.insert("member.insertMember", dto);
	}

	@Override
	public void uploadProfile(MemberDto dto) throws Exception{
		ss.insert("member.insertProfile", dto);
	}

	@Override
	public MemberDto getMember(MemberDto dto) throws Exception {
		return ss.selectOne("member.getMember", dto);
	}

	@Override
	public int updateMember(MemberDto dto) throws Exception {
		return ss.update("member.updateMember", dto);
	}

}
