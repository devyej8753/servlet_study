package com.gn.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.gn.member.service.MemberService;
import com.gn.member.vo.Member;

@WebServlet(name="memberUpdateEndServlet",urlPatterns="/memberUpdateEnd")
public class MemberUpdateEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberUpdateEndServlet() {
        super();
    }

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pw = request.getParameter("member_pw");
		String name = request.getParameter("member_name");
		int no = Integer.parseInt(request.getParameter("member_no"));

		
		Member m = new Member();
		m.setMemberPw(pw);
		m.setMemberName(name);
		m.setMemberNo(no);
		
		int result = new MemberService().memberUpdateEnd(m);
		JSONObject obj = new JSONObject();
		obj.put("res_code", "500");
		obj.put("res_msg", "정보수정 오류가 발생하였습니다.");
		
		m = new MemberService().MemberselectOne(no);
		
		if(result > 0) {
			HttpSession session = request.getSession(false);
			session.setAttribute("member", m);
			session.setMaxInactiveInterval(60*30);
			
			obj.put("res_code", "200");
			obj.put("res_msg", "정상적으로 정보수정 되었습니다.");
		}
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(obj);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
