package com.eeit48.webProject.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cookie")
public class CookieDemoController {

	@PostMapping("/setcookie")
	public void setCookie(HttpServletResponse response) {
		// New一個cookie的格式，以 key、value 的方式存進資料
		Cookie cookie = new Cookie("test", "123");
		// 設定哪些路徑可以娶到這個cookie，單獨斜線表示，這個服務內大家都可以取到
		cookie.setPath("/");
		// 只能用Http的方式去存取，就是透過ＡＰＩ的方式，禁止前端用ＪＳ去存取
		cookie.setHttpOnly(true);
		// 將cookie對象加入response響應
		response.addCookie(cookie);
	}

	@PostMapping("/getcookie")
	public void getCookie(HttpServletRequest request) {
		
		//取得所有cookie
		 Cookie cookies[] = request.getCookies();
		 	//用來裝cookie的value
		    String value = null;
		    //先判斷有沒有cookie
		    if(cookies != null){
		        Cookie cookie = null;
		        //用迴圈去遍歷cookie 陣列的每一個資料
		        for(int i = 0; i < cookies.length; i++){
		        	
		            cookie = cookies[i];
		            //設定要找的key是否存在
		            if(cookie.getName().equals("test")){
		                value = cookie.getValue();
		                break;
		            }
		        }
		    }

		System.out.println(value);

	}

}
