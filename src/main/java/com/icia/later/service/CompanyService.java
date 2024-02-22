package com.icia.later.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.later.dao.CompanyDao;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CompanyService {
	@Autowired CompanyDao cDao;

}
