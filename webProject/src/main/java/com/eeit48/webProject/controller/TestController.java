package com.eeit48.webProject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eeit48.webProject.dao.AccountDB;
import com.eeit48.webProject.dao.MemberDB;
import com.eeit48.webProject.service.Account;
import com.eeit48.webProject.service.Member;

@RestController
@RequestMapping("/item")

public class TestController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		List<Account> accounts = new ArrayList<Account>();
//		AccountDB accountDB = new AccountDB();
//		try {
//			accounts = accountDB.login("usename", "pd");
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
		
		List<Member> memberList = new ArrayList<Member>();		
		MemberDB memberDB = new MemberDB();
		
		try {
			memberList = memberDB.Select();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
		
		
		
	}

}
