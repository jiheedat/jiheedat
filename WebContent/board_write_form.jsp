<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2번째 게시판</title>
</head>
<body>
	<form action = "Controller" method ="post">
		글번호 : <input type = "text" name ="bno"/><br/> 
		제목 : <input type="text" name = "title"/><br/>
		내용 : <textarea name="content"></textarea><br/>
		작성자 : <input type="text" name="writer"/><br/>
		작성일시 : <input type="date" name="writedate"/>
		<input type="hidden" name="command" value="board_write_action"/>
		<input type="submit" name="작성완료"/>
		
		
	</form>
</body>
</html>