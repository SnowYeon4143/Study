package com.kh.app25.member.dao;

import com.kh.app25.member.entity.MemberDto;

public interface MemberDao {

	int join(MemberDto dto) throws Exception;

}
