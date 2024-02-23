package com.icia.later.dao;

import com.icia.later.dto.BoardDto;
import com.icia.later.dto.MemberDto;

public interface MemberDao {
	

	// ȸ������
	void insertMember(MemberDto member);
	// �α���
	MemberDto login(MemberDto member);
	
	// ȸ������ �� �������� (���������� ������)
	MemberDto selectMember(Integer memberId);
			
	// ������Ʈ
	void updateMember(MemberDto member);
		
	// ����
	void deleteMember(Integer memberId);
	
}
