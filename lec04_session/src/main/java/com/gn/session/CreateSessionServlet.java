package com.gn.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/createSession")
public class CreateSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CreateSessionServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session 
			= request.getSession(); // 둘이 같음
//			= request.getSession(true);
//		if(session.isNew()) {
//			// true -> 새로운 세션 객체 생성
//			
//		}else{
//			// false -> 기존의 세션 객체가 반환  
//			if(session.getAttribute("memver_id")== null) {
//				
//			}
//		}
		// 일반적으로 이렇게 한번에 쓴다
		if(session.isNew() || session.getAttribute("member_id")==null) {
			session.setAttribute("member_id", "user01");
			session.setMaxInactiveInterval(60*30);
		}
		response.sendRedirect("/");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
