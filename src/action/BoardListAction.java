package action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dto.BoardDto;

public class BoardListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDao dao = new BoardDao();
		ArrayList<BoardDto> dtoList = null;
		
		try {
			dtoList = dao.getDtoList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("dtoList", dtoList);
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}

}
