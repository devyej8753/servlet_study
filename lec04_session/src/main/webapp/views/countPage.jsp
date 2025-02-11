<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! int num = 1; %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 페이지</title>
</head>
<body>
	<%
		String count = String.valueOf(num++);
		Cookie c = new Cookie("visit_count",count);
		c.setMaxAge(60*60*24);
		response.addCookie(c);
	%>
	<p>
	당신은 이 페이지를 
	<strong><%=count%></strong>번 방문했습니다.
	</p>
</body>
</html>