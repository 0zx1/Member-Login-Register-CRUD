package com.eeit48.webProject.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.eeit48.webProject.dao.MemberDB;
import com.eeit48.webProject.service.Member;

@RestController
@RequestMapping("/member")

public class MemberController {

@PostMapping("/r")
public List<Member> read(){
	List<Member> memberliList = new ArrayList<Member>();
	MemberDB memberdb = new MemberDB();
	try {
		memberliList = memberdb.Select();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return memberliList;
}


	@PostMapping("/c")
	public boolean create(@RequestBody Member member) {

		System.out.println(member.toString());
		MemberDB memberdb = new MemberDB();

		try {
			memberdb.Insert(member);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@PostMapping("/d")
	public boolean delete(@RequestBody Member member) {

		MemberDB memberdb = new MemberDB();

		try {
			memberdb.Delete(member);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@PostMapping("/u")
	public boolean update(@RequestBody Member member) {

		MemberDB memberdb = new MemberDB();

		try {
			memberdb.Update(member);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	

//	@PostMapping("testpic")
//	public String testpic(MultipartFile file) {
//
//		System.out.println(file);
//		System.out.println(file.toString());
//
//		try {
//			// 儲存檔案
//			byte[] bytes = file.getBytes();
//			Path path = Paths.get("C:\\Users\\user\\Desktop\\照片一\\12321.jpg");
//
//			Files.write(path, bytes);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		return "123";
//
//	}

}
