<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%Board paging = (Board)request.getAttribute("paging"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html> 
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link href='<%=request.getContextPath()%>/resources/css/board/list.css' rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/include/paging.css" rel="stylesheet" type="text/css">
<%-- <script src="<%=request.getContextPath()%>/resources/js/jquery-3.7.1.js"></script> --%>
<script src="<c:url value='/resources/js/jquery-3.7.1.js'/>"></script>
</head>
<body>
<%@ include file="/views/include/header.jsp" %>
<%@ include file="/views/include/nav.jsp" %>
	<section>
		<div id="section_wrap">
				<div class="search">
			<form action="/boardList" name="search_board_form" method="get">
				<input type="text" name="board_title" placeholder="검색하고자 하는 게시글 제목을 입력하세요."
				value="<%=paging.getBoardTitle() == null ?  "" : paging.getBoardTitle()%>">
				<input type="submit" value="검색">
			</form>	
		</div>
			<div class="word">
				<h3>게시글 목록</h3>
				<p>1. Scriptlet : <%=paging.getBoardTitle() %></p>
				<p>2. EL : ${paging.boardTitle }</p>
			</div><br>
			<div class="board_list">
				<table>
					<colgroup>
						<col width="10%">
						<col width="50%">
						<col width="20%">
						<col width="20%">
					</colgroup>
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일시</th>
						</tr>
					</thead>
					<tbody>
						<%@ page import="com.gn.board.vo.Board, java.util.*, java.time.format.*" %>
						 <%-- <%List<Board> list = (List<Board>)request.getAttribute("resultList");
						DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm"); %>  --%>
						<%-- <%
							for(int i = 0; i < list.size() ; i++){ %>
								<tr data-board-no="<%=list.get(i).getBoardNo()%>">
									<td><%=((paging.getNowPage()-1)*paging.getNumPerPage())+(i+1) %></td>
									<td><%=list.get(i).getBoardTitle() %></td>
									<td><%=list.get(i).getMemberName() %></td>
									<td><%=list.get(i).getRegDate().format(dtf) %></td>
								</tr>
						<% }%>	 --%>
							<!-- EL,JSTL 로 풀어보기 (내 풀이) -->
							<%-- <c:forEach var="list" items="${resultList}" varStatus="vs">
								<tr data-board-no="${list.boardNo}">
									<td>${((paging.nowPage -1)*paging.numPerPage)+(vs.index+1)}</td>
									<td>${list.boardTitle}</td>
									<td>${list.memberName}</td>
									<td>${list.regDate}</td>
								</tr>
							</c:forEach> --%> 
							<!-- 강사님 풀이 -->
							<c:choose>
								<c:when test="${not empty resultList }">
									<c:forEach items="${resultList}" var="b" varStatus="vs">
									<tr data-board-no="${b.boardNo }">
										<td>${((paging.nowPage -1)*paging.numPerPage)+(vs.index+1)}</td>
										<td>${b.boardTitle}</td>
										<td>${b.memberName}</td>
										<%-- <td>${b.regDate}</td> --%>
										<fmt:parseDate value="${b.regDate}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="strRegDate"/>
										<td><fmt:formatDate value="${strRegDate}" pattern="yy-MM-dd HH:mm"/></td>
									</tr>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<tr>
										<td colspan="4">조회된 데이터가 없습니다.</td>
									</tr>
								</c:otherwise>
							</c:choose>
							
						
					</tbody>
				</table>
			</div>
		</div>
	</section>	
	<%-- <% 
	if(paging != null) {%>
		<div class="center">
			<div class="pagination">
				<%if(paging.isPrev()) {%>
					<a href="/boardList?nowPage=<%=(paging.getPageBarStart()-1)%>&board_title=<%=paging.getBoardTitle()== null ? "" : paging.getBoardTitle()%>">&laquo;</a>
				<%} %>
				
				<%for(int i = paging.getPageBarStart(); i <= paging.getPageBarEnd(); i++){ %>
					<a href="/boardList?nowPage=<%=i%>&board_title=<%=paging.getBoardTitle() == null ? "" : paging.getBoardTitle()%>"><%=i%></a>
				<%} %>
				
				<% if(paging.isNext()) {%>
					<a href="/boardList?nowPage=<%= (paging.getPageBarEnd()+1)%>&board_title=<%=paging.getBoardTitle() == null ? "" : paging.getBoardTitle()%>">&raquo;</a>
				<%} %>
			</div>
		</div>
	<%} %> --%>
	<!-- EL,JSTL 내 풀이  -->
	<c:if test="${not empty paging}">
		<div class="center">
			<div class="pagination">
				<c:if test="${paging.prev}">
					<a href="/boardList?nowPage=${paging.pageBarStart -1}&board_title=${empty paging.boardTitle ? '' : paging.boardTitle}">&laquo;</a>
				</c:if>
				<c:forEach begin="${paging.pageBarStart}" end="${paging.pageBarEnd}" varStatus="vs">
					<a href="/boardList?nowPage=${vs.index}&board_title=${empty paging.boardTitle ? '' : paging.boardTitle}">${vs.index}</a>
				</c:forEach>
				<c:if test="${paging.next}">
					<a href="/boardList?nowPage=${paging.pageBarEnd +1}&board_title=${empty paging.boardTitle ? '' : paging.boardTitle}">&raquo;</a>
				</c:if>
			</div>
		</div>
	</c:if> 
	<!-- 강사님 풀이  -->
	<%-- <div class="center">
			<div class="pagination">
				<c:if test="${paging.prev}">
					<c:url var="testUrl" value="/boardList">
						<c:param name="nowPage" value="${paging.pageBarStart -1}"/>
						<c:param name="board_title" value="${paging.boardTitle }"/>						 
					</c:url>
					<a href="${testUrl}">&laquo;</a>
					<a href="/boardList?nowPage=${paging.pageBarStart -1}&board_title=${empty paging.boardTitle}">&laquo;</a>
				</c:if>
				<c:forEach begin="${paging.pageBarStart}" end="${paging.pageBarEnd}" varStatus="vs">
					<a href="/boardList?nowPage=${vs.index}&board_title=${empty paging.boardTitle}">${vs.index}</a>
				</c:forEach>
				<c:if test="${paging.next}">
					<a href="/boardList?nowPage=${paging.pageBarEnd +1}&board_title=${empty paging.boardTitle}">&raquo;</a>
				</c:if>
			</div>
		</div> --%>
	<script>
		$('.board_list tbody tr').on("click",function(){
			const boardNo = $(this).data('board-no');
			location.href='/boardDetail?board_no='+boardNo;
		})
	</script>
</body>
</html>

