package com.icia.later.service;

import org.apache.catalina.tribes.Member;

public interface MemberRepository {

	boolean existsByEmail(String email);

	Member findByEmail(String email);

}