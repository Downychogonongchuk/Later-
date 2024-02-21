package com.icia.later;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String loginPage() {
		return "login/loginPage";
	}

	@GetMapping("join")
	public String join() {
		return "login/join";
	}
    @PostMapping("select")
    public String selectMemberType(String type) {
//        if ("personal".equals(type)) {
//            return "redirect:/personal/main";
//        } else if ("business".equals(type)) {
//            return "redirect:/business/main";
//        } else {
//            return "error";
//        }
    return "login/member-join";
    }
}