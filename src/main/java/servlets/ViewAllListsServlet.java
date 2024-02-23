package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.BookListDetailsHelper;
import model.BookListDetails;

/**
 * Servlet implementation class ViewAllListsServlet
 */
@WebServlet("/ViewAllListsServlet")
public class ViewAllListsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewAllListsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookListDetailsHelper slh = new BookListDetailsHelper();
		List<BookListDetails> abc = slh.getLists();
		request.setAttribute("allDetails", abc);
		if (abc.isEmpty()) {
			request.setAttribute("allDetails", " ");
		}
		getServletContext().getRequestDispatcher("/view-all-lists.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
