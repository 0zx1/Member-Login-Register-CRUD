package com.eeit48.webProject.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eeit48.webProject.dao.AccountDB;
import com.eeit48.webProject.service.Account;



@RestController
@RequestMapping("/login")

public class LoginController {

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
//	public boolean login(@RequestBody Account account) {
//
//		AccountDB accountDB = new AccountDB();
//
//		boolean result = accountDB.login(account.getAccount(),account.getPassword());
//
//		System.out.println(result);
//
//		return result;
//
//	}

	@PostMapping("/c")
	public boolean create(@RequestBody Account	account) {

		System.out.println(account.toString());
		AccountDB accountDB = new AccountDB();

		try {
			accountDB.Insert(account);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}



}
