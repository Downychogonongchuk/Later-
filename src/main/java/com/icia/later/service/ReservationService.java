package com.icia.later.service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.icia.later.dao.ReservationDao;
import com.icia.later.dto.BoardDto;
import com.icia.later.dto.ReservationDto;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j

public class ReservationService {
	@Autowired
	private ReservationDao rDao;



	public String insertRev(List<MultipartFile> files, BoardDto board, HttpSession session, RedirectAttributes rttr) {
		
		return null;
	}



	
	
}
