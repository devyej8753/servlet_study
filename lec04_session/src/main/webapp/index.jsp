<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie[] cookies = request.getCookies();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키, 세션</title>
</head>
<body>
	<%if(session.isNew() || session.getAttribute("account")==null) {%>
	<a href="/login">로그인</a>
	<%}else{%>
		<a href="/logout">로그아웃</a>
	<%} %>
	
	<h1>쿠키 연습하기</h1>
	<ul>
		<li>
			<a href="/createCookie">생성하기</a>
		</li>
		<li>
			<%
			String userId = "쿠키없음";
			if(cookies != null) {
				for(Cookie c : cookies){
					if("user_id".equals(c.getName())){
						userId = c.getValue();
					}
				}
			}%>
			아이디 : <%=userId%>
		</li>
		<li>
			<a href="/editCookie">수정하기</a>
		</li>
		<li>
			<a href="/removeCookie">삭제하기</a>
		</li>
	</ul>
	<a href="/changePage">화면전환</a>
	<h1>세션 연습하기</h1>
	<ol>
		<li>
			<a href="/createSession">
				생성하기
			</a>
		</li>
		<li>
			<%
				String memberId = "세션 없음";
				// 세션은 jsp의 내장객체
				if(session != null){
					if(session.getAttribute("member_id")==null){
						memberId = "세션 없음";
					}else{
					memberId = (String)session.getAttribute("member_id");
					}
				}
			%>
			<%=memberId%>
		</li>
	</ol>
	
</body>
</html>