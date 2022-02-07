package com.kh.app25.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.app25.member.dao.MemberDao;
import com.kh.app25.member.entity.MemberDto;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDao dao;

	@Override
	public int join(MemberDto dto) throws Exception {
		return dao.join(dto);
	}

}
