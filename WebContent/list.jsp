<%@page import="java.util.ArrayList"%>
<%@page import="dto.BoardDto"%>
<%@page import="dto.BoardDto"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
	
	ArrayList<dto.BoardDto> listDto = (ArrayList<dto.BoardDto>)request.getAttribute("dtoList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table{ border-collapse: collapse; }
	th,td { padding:8px; border:1px solid grey;}
</style>
<script src="js/jquery-3.7.0.min.js"></script>
<script>
	$(function(){
		$("tr").click(function(){
			let bno = $(this).find(".bno").text();
			location.href = "Controller?command=board_detail&bno="+bno;
		});
		$("#btn").click(function(){
			location.href="Controller?command=board_write";
		});
	});
</script>
</head>
<body>
	<table>
		<tr>
			<th>글 번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일시</th>
		</tr>
		
		<%
			for(BoardDto d : listDto) {
		%>
		<tr>
			<td class="bno"><%=d.getBno()%></td>
			<td><%=d.getContent()%></td>
			<td><%=d.getTitle()%></td>
			<td><%=d.getWriter()%></td>
		</tr>
		<%	} %>
	</table>
	<input type="button" value="글쓰기" id = "btn">
</body>
</html>


