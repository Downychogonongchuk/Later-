package com.icia.later.dao;

import com.icia.later.dto.MemberDto;

public interface MemberDao {

		
		// 회원가입
		void insertMember(MemberDto member);
		
		// 로그인
		MemberDto login(MemberDto member);
	
		// 회원정보 상세 가져오기
		MemberDto selectMember(Integer memberId);
		
		// 업데이트
		void updateMember(MemberDto member);
		
		// 삭제
		void deleteMember(Integer memberId);
}
