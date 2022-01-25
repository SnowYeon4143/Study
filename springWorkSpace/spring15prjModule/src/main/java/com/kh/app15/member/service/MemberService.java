package com.kh.app15.member.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.kh.app15.member.entity.MemberDto;
import com.kh.app15.member.repository.MemberRepository;
import com.kh.app15.member.repository.MemberRepositoryInter;

@Component
public class MemberService implements MemberServiceInter{
	
	@Autowired
	private MemberRepositoryInter repository;
	
	@Autowired
	private PasswordEncoder pe;
	
	public int join(MemberDto dto) {
		//��ȣȭ
		String newPwd = pe.encode(dto.getPwd()); //nullpointexception
		dto.setPwd(newPwd);
						
		//DB�� insert
		return repository.join(dto);
	}
	
}
