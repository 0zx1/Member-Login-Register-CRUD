package com.eeit48.webProject.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eeit48.webProject.dao.AccountDB;
import com.eeit48.webProject.dto.*;
import com.eeit48.webProject.service.Account;

@RestController
@RequestMapping("/session")
public class SessionDemoController {

	@PostMapping("/setsession")
	public void setSession(HttpSession session, @RequestBody String a) {
		session.setAttribute("uid", a);
	}

	@PostMapping("/getsession")
	public void getSession(HttpSession session) {

		String sessionValue = (String) session.getAttribute("uid");
		System.out.println(sessionValue);

	}
	
	
	@PostMapping("/login")
	public boolean login(HttpSession session,@RequestBody Account account) {

		
		List<Account> accountList = new ArrayList<Account>();
		AccountDB accountDB = new AccountDB();
		boolean result = false;
		
		try {
			accountList = accountDB.login(account.getAccount(), account.getPassword());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(accountList.size() > 0) {
			session.setAttribute("login", true);
			session.setAttribute("account", accountList.get(0).getAccount());
			session.setAttribute("password", accountList.get(0).getPassword());
			result =true;
		}
		System.out.println(accountList.get(0).getAccount());

		return result;

	}	
	
	
	

//	@PostMapping("/login")
//	public String login(HttpSession session, LoginDto loginDto) {
//		String result = "false";
//
//		System.out.println(loginDto.getAcc());
//		System.out.println(loginDto.getPassword());
//
//		if (loginDto.getAcc().equals("test") && loginDto.getPassword().equals("123")) {
//			session.setAttribute("login", true);
//			result = "true";
//
//		}
//		return result;
//	}

	@PostMapping("/checklogin")
	public String checkLogin(HttpSession session) {
		String result = "false";
		if(session.getAttribute("login") == null) {
			session.setAttribute("login", false);
		}
		if ((boolean) session.getAttribute("login") == true) {
			result = "true";
		}
System.out.println(result);
		return result;
	}
	
	@PostMapping("/logout")
	public String logout(HttpSession session) {
		String result = "false";

		session.setAttribute("login", false);
		
		if ((boolean) session.getAttribute("login") == false) {
			result = "true";
		}

		return result;
	}

}
