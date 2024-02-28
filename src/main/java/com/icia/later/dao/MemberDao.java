package com.icia.later.dao;

import com.icia.later.dto.MemberDto;


public interface MemberDao {
	//회원가입
	void insertMember(MemberDto member);

	//로그인
	MemberDto login(MemberDto member);
	
	//회원 정보 수정
	void updateMember(MemberDto member);

	//회원 탈퇴
	void deleteMember(int id);

	MemberDto selectMember(Integer memberId);
	
}