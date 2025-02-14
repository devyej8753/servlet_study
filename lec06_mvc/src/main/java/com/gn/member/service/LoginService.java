package com.gn.member.service;
import static com.gn.common.sql.JDBCTemplate.getConnection;
import static com.gn.common.sql.JDBCTemplate.close;
import java.sql.Connection;

import com.gn.member.dao.LoginDao;
import com.gn.member.vo.Member;
public class LoginService {
	
	private LoginDao login = new LoginDao();
	
	public Member memberLoginEnd(String id,String pw){
		Connection conn = getConnection();
		Member m = login.memberLoginEnd(id,pw,conn);
		close(conn);
		return m;
	}

}
