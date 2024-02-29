package com.icia.later.dao;

import com.icia.later.dto.CustomerDto;


public interface CustomerDao {
	
	// ����� ȸ������
		void insertCustomer(CustomerDto customer);
		
		// ����� �α���
		CustomerDto login(CustomerDto customer);
		
		// ������Ʈ
		void updateCustomer(CustomerDto customer);
		
		// ����� ȸ�� Ż��
		void deleteCustomer(Integer customerId);
		
		// �̸��� �ߺ�üũ
		int checkDuplicateId(String customerEmailCheck);

		// ����� �̸��� ã��
		CustomerDto FindById(CustomerDto customer);
		
		// ��й�ȣ ã��
		CustomerDto FindByPass(CustomerDto customer);
				
		// ��й�ȣ ������Ʈ
		void cUpdatePassProc(CustomerDto customer);

	}