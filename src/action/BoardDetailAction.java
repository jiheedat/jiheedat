package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dto.BoardDto;

public class BoardDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		BoardDao dao = new BoardDao();
		BoardDto dto = null;
		try {
			 dto = dao.getBoardDto(bno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("dto", dto);
		request.getRequestDispatcher("detail.jsp").forward(request, response);
	}

}
