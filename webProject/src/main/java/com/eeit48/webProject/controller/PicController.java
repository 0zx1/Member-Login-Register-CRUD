package com.eeit48.webProject.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/pic")

public class PicController {

	@PostMapping("icon")
	public String testpic(MultipartFile file) {

		System.out.println(file);
		System.out.println(file.toString());

		try {
			// 儲存檔案
			byte[] bytes = file.getBytes();
			Path path = Paths.get("C:/icon/icon.png");

			Files.write(path, bytes);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "123";

	}

	
}
