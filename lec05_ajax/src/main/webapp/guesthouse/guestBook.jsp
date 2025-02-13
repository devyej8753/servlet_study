<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록</title>
<script src="<%=request.getContextPath()%>/resources/jquery-3.7.1.js">></script>
</head>
<body>
	<h2>방명록</h2>
    <input type="text" id="guest_name" placeholder="이름">
    <textarea id="guest_message" placeholder="메시지"></textarea>
    <button id="submit_btn">등록</button>

    <h3>📝 남긴 메시지</h3>
    <ul id="guestbook_list">
    
    </ul>
    <script>
    	$(function(){
    		$('#submit_btn').click(function(){
    			const name = $("#guest_name").val();
    			const message = $("#guest_message").val();
    			$.ajax({
    				url:"/guestbookajaxget",
    				type:"post",
    				data:{nameqqq:name,message:message},
    				datatype:"JSON",
    				contentType:"application/x-www-form-urlencoded; charset=UTF-8",
    				success:function(data){
    					$("#guestbook_list").append("<li>"+data.nameooo+" : "+data.message+"</li>")
    				},
    				error:function(){
    					alert("오류");
    				}
    			})
    		})
    	})
    </script>
</body>
</html>