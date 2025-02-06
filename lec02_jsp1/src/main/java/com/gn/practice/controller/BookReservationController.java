package com.gn.practice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/borrow")
public class BookReservationController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public BookReservationController() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		req.setCharacterEncoding("UTF-8");
		String userName = req.getParameter("user_name");
		String userPhone = req.getParameter("user_phone");
		String userEmail = req.getParameter("user_email");
		String book = req.getParameter("books");
		String loanTerm = req.getParameter("add");
		
		int price = 0;
		switch(book) {
			case "1": price = 1500;break;
			case "2": price = 1800;break;
			case "3": price = 2000;break;
		}
		switch(book) {
			case "1": book = "자바 프로그래밍 입문";break;
			case "2": book = "웹 개발의 기초";break;
			case "3": book = "데이터베이스 시스템";break;
		}
		int addPrice = (Integer.parseInt(loanTerm)-1)*500;
		price += addPrice;
		
		
		
		RequestDispatcher view = req.getRequestDispatcher("views/bookConfirmation.jsp");
		req.setAttribute("name", userName);
		req.setAttribute("phone",userPhone);
		req.setAttribute("email",userEmail);
		req.setAttribute("books", book);
		req.setAttribute("day", loanTerm);
		req.setAttribute("price", price);
		view.forward(req, resp);
		
		System.out.println("고객명 : "+userName);
		System.out.println("전화번호 : "+userPhone);
		System.out.println("이메일 : "+userEmail);
		System.out.println("도서제목 : "+book);
		 
		System.out.println("대출기간 : "+loanTerm+"일");
		
		System.out.println("가격 : "+price+"원");
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}

	
	
}
