package com.icia.later.dao;

import com.icia.later.dto.CustomerDto;

public interface CustomerDao {
	
	// ����� ȸ������
	void insertCustomer(CustomerDto customer);
	
	// ����� �α���
	CustomerDto login(CustomerDto customer);
	
	// ������Ʈ
	void updateCustomer(CustomerDto customer);

}