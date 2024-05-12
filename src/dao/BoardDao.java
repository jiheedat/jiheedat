package dao;

import java.sql.*;
import java.sql.DriverManager;
import java.util.ArrayList;

import dto.BoardDto;

public class BoardDao {
	public Connection getConnection () throws Exception{
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbId = "testw11";
		String dbPw = "pass123";
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url,dbId,dbPw);
		
		return conn;
	}
	
	public ArrayList<BoardDto> getDtoList() throws Exception{
	Connection conn = getConnection();
	
	ArrayList<BoardDto> list = new ArrayList<BoardDto>();
	
	String sql = "SELECT * FROM board ORDER BY bno desc";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	ResultSet rs = pstmt.executeQuery();
	while(rs.next()){
		int bno = rs.getInt("bno");
		String title = rs.getString("title");
		String content = rs.getString("content");
		String writer = rs.getString("writer");
		String writedate = rs.getString("writedate");
		BoardDto dtoList = new BoardDto(bno, title, content, writer, writedate);
		list.add(dtoList);
	}
	rs.close();
	pstmt.close();
	conn.close();
		return list;
	}
	public BoardDto getBoardDto (int bno) throws Exception {
		Connection conn = getConnection();
		
		String sql ="SELECT * FROM board WHERE bno=? ORDER BY bno desc";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bno);
		ResultSet rs = pstmt.executeQuery();
		
		BoardDto dto = null;
		while(rs.next()) {
			String title = rs.getString("title");
			String content = rs.getString("content");
			String writer = rs.getString("writer");
			String writedate = rs.getString("writedate");
			dto = new BoardDto(bno, title, content, writer, writedate);
		}
		rs.close();
		pstmt.close();
		conn.close();
		
		return dto;
	}
	
	public void DeleteBoard(int bno) throws Exception {
		Connection conn = getConnection();
		String sql = "DELETE FROM board WHERE bno =?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bno);
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
	}
	public void write(int bno,String title,String content,String writer) throws Exception{
		Connection conn = getConnection();
		String sql = "INSERT INTO board(bno,title,content,writer) VALUES(?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bno);
		pstmt.setString(2, title);
		pstmt.setString(3, content);
		pstmt.setString(4, writer);
		
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
	}
	
	public BoardDto boardUpdateDto(int bno) throws Exception {
		Connection conn = getConnection();
		String sql = "SELECT * FROM board WHERE bno=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bno);
		ResultSet rs = pstmt.executeQuery();
		
		BoardDto dto = null;
		String title ="";
		String content ="";
		String writer ="";
		String writedate ="";
		while(rs.next()) {
			 title = rs.getString("title");
			 content = rs.getString("content");
			 writer = rs.getString("content");
			 writedate = rs.getString("writedate");
			
			dto = new BoardDto(bno, title, content, writer, writedate);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return dto;
	}
	
	public void boardUpdate(int bno,String title,String content,String writer) throws Exception {
		Connection conn = getConnection();
		String sql = "UPDATE board SET title=?,content=?,writer=? WHERE bno=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,title);
		pstmt.setString(2,content);
		pstmt.setString(3, writer);
		pstmt.setInt(4, bno);
		
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
	}

}