package com.icia.later.dao;

import org.springframework.ui.Model;

import com.icia.later.dto.MemberDto;

public interface MemberDao {
	
		// ȸ������
		void insertMember(MemberDto member);
		
		// �α���
		MemberDto login(MemberDto member);
	
		// ȸ������ �� ��������
		MemberDto selectMember(Integer memberId);
		
		// ������Ʈ
		void updateMember(MemberDto member);
		
		// ����
		void deleteMember(Integer memberId);
		
		// �̸��� �ߺ�üũ
		int checkDuplicateId(String memberEmailCheck);
		
		// �̸��� ã��
		MemberDto FindById(MemberDto member);
		
		// ��й�ȣ ã��
		MemberDto FindByPass(MemberDto member);
		
		// ��й�ȣ ������Ʈ
		void mUpdatePassProc(MemberDto member);
}