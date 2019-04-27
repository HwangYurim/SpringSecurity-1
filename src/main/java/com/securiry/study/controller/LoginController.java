package com.securiry.study.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.securiry.study.vo.UserVo;

import SampleService.SampleService;
import lombok.extern.java.Log;

@Log
@Controller
public class LoginController {

	// #4 JDBC��������� ���� service ȣ�� �� �����Ͻ� ���� ������ ���Ͽ� ������ ����
	@Autowired
	private SampleService sampleService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String welcome(Model model) {
		
		model.addAttribute("msg", "Hi~~!~!~");
		return "home";
	}
	
	// #2 ����� Ŀ���� �α��� ������.
	@RequestMapping(value="/loginForm", method=RequestMethod.GET)
	public String goLoginForm(Model model, HttpServletRequest req) {
		
		if(req.getParameter("loggout") != null) {
			model.addAttribute("loggout", "loggout");
		}
		
		
		return "loginPage";
	}
	
	// #2 �α������Ŀ� ���Ѻ� �������� ������ ���� ����.
	@RequestMapping(value="/defaultPage", method=RequestMethod.GET)
	public String defaultPage(Model model, HttpServletRequest req) {
		
		if(req.isUserInRole("ADMIN")) {
			return "adminPage";
		}
		return "redirect:/";
	}
	
	
	// #4 DB connection test
	@RequestMapping(value="/jdbcTest", method=RequestMethod.GET)
	public @ResponseBody String cTest() {
	
		UserVo userVo = sampleService.getUser();
		
		log.info(userVo.getUserId());
		
		
		return "OK";
	}
}
