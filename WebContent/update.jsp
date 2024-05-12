<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="dto.BoardDto"%>
<%@page import="java.sql.*"%>   
    <% BoardDto d = (BoardDto)request.getAttribute("dto");
    	
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src = "js/jquery-3.7.0.min.js"></script>
</head>
<body>
	<form>
		<table>
			<tr>
				<th>글번호</th>
				<td><input type="text" name="bno" value="<%=d.getBno()%>"/></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name ="title" value="<%=d.getTitle()%>"/></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name ="content"><%=d.getContent() %></textarea></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name ="writer" value="<%=d.getWriter()%>"/></td>
			</tr>
			<tr>
				<th>작성일자</th>
				<td><input type="text" name ="writedate" value="<%=d.getWritedate()%>"/></td>
			</tr>
		</table>
		<input type ="hidden" name="command" value="board_update_action"/>
		<input type="submit" value="수정완료"/>
	</form>
</body>
</html>