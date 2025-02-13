package com.gn.guesthouse.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

@WebServlet("/guestbookajaxget")
public class GuestBookAjaxGet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GuestBookAjaxGet() {
        super();
    }
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("nameqqq");
		String message = request.getParameter("message");
		
		JSONObject o1 = new JSONObject();
		o1.put("nameooo", name);
		o1.put("message", message);
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(o1);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
