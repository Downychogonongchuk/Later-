package com.icia.later.dao;

import com.icia.later.dto.MemberDto;


public interface MemberDao {
	//ȸ������
	void insertMember(MemberDto member);

	//�α���
	MemberDto login(MemberDto member);
	
	//ȸ�� ���� ����
	void updateMember(MemberDto member);

	//ȸ�� Ż��
	void deleteMember(int id);

	MemberDto selectMember(Integer memberId);
	
}