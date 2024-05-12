<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="dto.BoardDto"%>
    <% int bno = (Integer)(request.getAttribute("bno"));%>
    
    <script>
    	alert("수정이 완료 되었습니다");
    	location.href="Controller?command=board_detail&bno="+<%=bno%>;
    </script>