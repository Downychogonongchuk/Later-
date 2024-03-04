package com.icia.later;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.icia.later.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class CategoryController {
	@Autowired
	private BoardService bServ;

	private String handleCategory(Integer pageNum, Model model, HttpSession session) {
		log.info("handleCategory()");

		return bServ.getCategoryList(pageNum, model, session);
	}

	@GetMapping("/category1")
	public String category1(Integer pageNum, Model model, HttpSession session) {
		return handleCategory(pageNum, model, session);

	}

	@GetMapping("/category2")
	public String category2(Integer pageNum, Model model, HttpSession session) {
		return handleCategory(pageNum, model, session);

	}

	@GetMapping("/category3")
	public String category3(Integer pageNum, Model model, HttpSession session) {
		return handleCategory(pageNum, model, session);

	}

	@GetMapping("/category4")
	public String category4(Integer pageNum, Model model, HttpSession session) {
		return handleCategory(pageNum, model, session);

	}

	@GetMapping("/category5")
	public String category5(Integer pageNum, Model model, HttpSession session) {
		return handleCategory(pageNum, model, session);

	}
}
