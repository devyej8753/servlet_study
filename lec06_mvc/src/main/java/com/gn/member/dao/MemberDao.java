package com.gn.member.dao;

import static com.gn.common.sql.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.gn.member.vo.Member;
public class MemberDao {
	
	// createMember 메소드
	// 매개변수로 Connection , member 받아서
	// DB에 INSERT(member_id, member_pw, member_name)
	// ResultSet(x) , executeUpdate(o)
	// 결과를 int로 반환
	
	public int createMember(Member mb, Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "INSERT INTO member (member_id , member_pw , member_name) "
					+ "VALUES(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mb.getMemberId());
			pstmt.setString(2, mb.getMemberPw());
			pstmt.setString(3, mb.getMemberName());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int memberUpdateEnd(Member m,Connection conn){
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "UPDATE member"
					+ " SET member_pw = ?, member_name = ?"
					+ " WHERE member_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,m.getMemberPw());
			pstmt.setString(2,m.getMemberName());
			pstmt.setInt(3,m.getMemberNo());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
		
	}
	
}
