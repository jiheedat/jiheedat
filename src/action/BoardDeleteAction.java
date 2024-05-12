package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;

public class BoardDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		BoardDao dao = new BoardDao();
		
		try {
			dao.DeleteBoard(bno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("delete.jsp").forward(request, response);
	}
	
}
