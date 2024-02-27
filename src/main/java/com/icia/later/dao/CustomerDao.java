package com.icia.later.dao;

import com.icia.later.dto.CustomerDto;
import com.icia.later.dto.MemberDto;

public interface CustomerDao {
	
	// 사업자 회원가입
	void insertCustomer(CustomerDto customer);
	
	// 사업자 로그인
	CustomerDto login(CustomerDto customer);
	
	// 업데이트
	void updateCustomer(CustomerDto customer);
	
	// 사업자 회원 탈퇴
	void deleteCustomer(Integer customerId);
	
	// 이메일 중복체크
	int checkDuplicateId(String customerEmailCheck);

}
