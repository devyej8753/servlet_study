package com.gn.member.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gn.member.service.MemberService;
import com.gn.member.vo.Member;


@WebServlet(name="memberCreateEndServlet",urlPatterns="/memberCreateEnd")
public class MemberCreateEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberCreateEndServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("member_id");
		String pw = request.getParameter("member_pw");
		String name = request.getParameter("member_name");
		System.out.println("아이디 : "+id+"\n비밀번호 : "+pw+"\n닉네임 : "+name);
		
		Member m = new Member();
		m.setMemberId(id);
		m.setMemberPw(pw);
		m.setMemberName(name);
		
		// Service에 데이터 전달
		int result = new MemberService().createMember(m);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/member/create_fail.jsp");
		if(result > 0) {
			view = request.getRequestDispatcher("/views/member/create_success.jsp");
		}
		view.forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
		
		doGet(request, response);
	}
	
}
