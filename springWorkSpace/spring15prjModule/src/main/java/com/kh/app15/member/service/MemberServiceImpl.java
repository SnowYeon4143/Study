package com.kh.app15.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.kh.app15.member.entity.MemberDto;
import com.kh.app15.member.repository.MemberRepositoryInter;

//@Component
public class MemberServiceImpl implements MemberServiceInter{

	@Autowired
	private MemberRepositoryInter repository;
	
	@Autowired
	private PasswordEncoder pe;
	
	@Override
	public int join(MemberDto dto) {
		//암호화
//		String newPwd = pe.encode(dto.getPwd()); //nullpointexception
//		dto.setPwd(newPwd);
								
		//DB에 insert
		return repository.join(dto);
	}

}
