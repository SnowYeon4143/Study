package com.kh.app15.member.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.kh.app15.member.entity.MemberDto;

@Component
public class MemberRepository implements MemberRepositoryInter{
	
	@Autowired
	SqlSession ss;
	
	public int join(MemberDto dto) {
		return ss.insert("member.join", dto);
	}

	@Override
	public MemberDto login(MemberDto dto) {
		return ss.selectOne("member.login", dto);
	}
	
}
