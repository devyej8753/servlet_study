package com.gn.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/createCookie")
public class CreateCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CreateCookieServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("=== 연결확인 ===");
		// 1. 쿠키 생성
		Cookie c = new Cookie("user_id","user01");
		// Age 지정
		c.setMaxAge(60*60*24);
		// 쿠키를 응답에 얹어주기
		response.addCookie(c);
		// 2. root 경로 이동 (무조건 생성 X 확인 빠르게 하는용도)
		response.sendRedirect("/");
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 습관적으로 할것
		request.setCharacterEncoding("UTF-8");
		doGet(request,response);
	}
 
}
