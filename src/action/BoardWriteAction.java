package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;

public class BoardWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int bno =Integer.parseInt(request.getParameter("bno"));
		String title= request.getParameter("title");
		String content = request.getParameter("contetnt");
		String writer = request.getParameter("writer");
		
			
		BoardDao dao = new BoardDao();
		
		try {
			dao.write(bno, title, content, writer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("writeAction.jsp").forward(request, response);
		
	}

}
