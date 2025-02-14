package com.gn.member.service;

import static com.gn.common.sql.JDBCTemplate.close;
import static com.gn.common.sql.JDBCTemplate.getConnection;

import java.sql.Connection;

import com.gn.member.dao.MemberDao;
import com.gn.member.vo.Member;
public class MemberService {

	// createMember 메소드
	// Member를 매개변수로 받아서
	// Connection 객체 생성
	// MemberDao에게 Connection과 Member 전달
	// int 반환
	
	private MemberDao mbd = new MemberDao();

	public int createMember(Member mb) {
		Connection conn = getConnection();
		int result = mbd.createMember(mb,conn);
		close(conn);
		return result;
		
	}
	public int memberUpdateEnd(Member m) {
		Connection conn = getConnection();
		int result = mbd.memberUpdateEnd(m,conn);
		close(conn);
		return result;
	}
	

	

	

	
	
}
