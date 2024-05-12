package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.BoardDeleteAction;
import action.BoardDetailAction;
import action.BoardListAction;
import action.BoardUpdateAction;
import action.BoardUpdateFormAction;
import action.BoardWriteAction;
import action.BoardWriteFormAction;



@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("BoardJH Controller 입니당.");
		request.setCharacterEncoding("utf-8");
		String command = request.getParameter("command");
		Action action = null;
	
		switch(command) {
		case "board_list": action = new BoardListAction(); break; 
		case "board_detail" : action = new BoardDetailAction(); break;
		case "board_delete" : action = new BoardDeleteAction(); break;
		case "board_write" : action = new BoardWriteFormAction(); break;
		case "board_write_action" : action = new BoardWriteAction();break;
		case "board_update" : action = new BoardUpdateAction();break;
		case "board_update_action" : System.out.println("실행??"); action = new BoardUpdateFormAction();break;
		}	
		action.execute(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}