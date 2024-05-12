<%@page import="dto.BoardDto"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	BoardDto dto = (BoardDto) request.getAttribute("dto");
%>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>상세내용</title>
<style>
	table { border-collapse: collapse;}
	th,td {padding:8px; border:1px solid grey;}
</style>
<script src="js/jquery-3.7.0.min.js"></script>
<script>
	$(function(){
		$("#delete").click(function(){
		
			location.href = "Controller?command=board_delete&bno="+<%=dto.getBno()%>;
		});
		$("#list").click(function(){
			location.href="Controller?command=board_list";
		});
		$("#update").click(function(){
			location.href = "Controller?command=board_update&bno="+<%=dto.getBno()%>;
		});
	});
</script>
</head>
<body>
	<table>
		<tr>
			<th>글번호</th>
			<td><%= dto.getBno() %></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><%=dto.getTitle() %></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><%=dto.getWriter() %></td>
		</tr>
		<tr>
			<th>작성일자</th>
			<td><%=dto.getWritedate() %></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><%=dto.getContent() %></td>
		</tr>
	</table>
	<input type = "button" value = "목록으로" id = "list">
	<input type = "button" value = "수정하기" id = "update">
	<input type = "button" value = "삭제하기" id = "delete">
</body>
</html>