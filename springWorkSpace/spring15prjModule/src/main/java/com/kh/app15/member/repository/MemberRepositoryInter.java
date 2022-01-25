package com.kh.app15.member.repository;

import com.kh.app15.member.entity.MemberDto;

public interface MemberRepositoryInter {

	int join(MemberDto dto);

	MemberDto login(MemberDto dto);
	
}
